package knight.nameless.dark.objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import knight.nameless.dark.helpers.Box2DBody;

import static knight.nameless.dark.helpers.Box2DHelper.createBody;

public class Box extends GameObject {

    public Box(Rectangle bounds, World world) {
        super(bounds, world, new TextureRegion(new Texture("images/box.png")));
    }

    @Override
    protected Body createObjectBody() {
        return createBody(
            new Box2DBody(actualBounds, 20, actualWorld, this)
        );
    }

    @Override
    protected void childUpdate(float deltaTime) {}
}
