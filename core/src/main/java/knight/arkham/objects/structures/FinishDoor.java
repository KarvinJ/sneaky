package knight.arkham.objects.structures;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.World;
import knight.arkham.helpers.Box2DBody;

import static knight.arkham.helpers.Box2DHelper.createBody;

public class FinishDoor {

    public FinishDoor(Rectangle bounds, World world) {
        createBody(new Box2DBody(bounds, world, this));
    }
}
