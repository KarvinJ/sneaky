package knight.nameless.dark.objects;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import knight.nameless.dark.helpers.Box2DBody;

import static knight.nameless.dark.helpers.AnimationHelper.makeAnimation;
import static knight.nameless.dark.helpers.Box2DHelper.createBody;

public class Animal extends GameObject {

    private final Animation<TextureRegion> animation;
    private float animationTimer;

    public Animal(Rectangle bounds, World world, TextureRegion region, int totalFrames) {
        super(bounds, world, region);

        animation = makeAnimation(region, totalFrames, 0.2f);
    }

    @Override
    protected Body createObjectBody() {

        return createBody(
            new Box2DBody(actualBounds, 0, actualWorld, this)
        );
    }

    protected void childUpdate(float deltaTime) {

        animationTimer += deltaTime;

        actualRegion = animation.getKeyFrame(animationTimer, true);
    }
}
