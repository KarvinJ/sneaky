package knight.nameless.dark.objects.structures;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.World;
import knight.nameless.dark.helpers.Box2DBody;

import static knight.nameless.dark.helpers.AnimationHelper.makeAnimation;
import static knight.nameless.dark.helpers.AssetsHelper.loadSound;
import static knight.nameless.dark.helpers.Box2DHelper.createFixture;
import static knight.nameless.dark.helpers.GameDataHelper.savePlayerPosition;

public class Checkpoint extends InteractiveStructure {

    private final Animation<TextureRegion> animation;
    private float animationTimer;
    private boolean isActive;
    private final Sound activationSound;

    public Checkpoint(Rectangle rectangle, World world, TextureAtlas.AtlasRegion region) {
        super(
            rectangle, world,
            new TextureRegion(
                region, 0, 0, region.getRegionWidth() / 2, region.getRegionHeight()
            )
        );

        animation = makeAnimation(region, 2, 0.5f);

        activationSound = loadSound("okay.wav");
    }

    @Override
    protected Fixture createObjectFixture() {
        return createFixture(
            new Box2DBody(actualBounds, 0, actualWorld, this)
        );
    }

    public void update(float deltaTime) {

        animationTimer += deltaTime;

        if (isActive)
            actualRegion = animation.getKeyFrame(animationTimer, true);
    }

    public void createCheckpoint() {

        collisionWithPlayer();

        activationSound.play();

        isActive = true;

        savePlayerPosition(body.getPosition());
    }

    @Override
    public void dispose() {
        activationSound.dispose();
        super.dispose();
    }
}
