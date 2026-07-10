package knight.nameless.dark.objects.structures;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.World;
import knight.nameless.dark.helpers.Box2DBody;

import static knight.nameless.dark.helpers.Box2DHelper.createBody;

public class FinishDoor {

    public FinishDoor(Rectangle bounds, World world) {
        createBody(new Box2DBody(bounds,0, world, this));
    }
}
