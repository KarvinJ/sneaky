package knight.arkham.objects.structures;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.Filter;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.World;
import knight.arkham.helpers.Box2DBody;

import static knight.arkham.helpers.Box2DHelper.createFixture;
import static knight.arkham.helpers.Constants.*;

public class LightStructure {

    public final Fixture fixture;
    public boolean shouldHaveDeathCollision;

    public LightStructure(Rectangle bounds, World world) {
        fixture = createFixture(new Box2DBody(bounds, 0, world, this));
    }

    public void update() {

        Filter filter = new Filter();

        if (shouldHaveDeathCollision) {

            filter.categoryBits = LIGHT_BOUNDS_BIT;
            fixture.setFilterData(filter);
        }
        else {

            filter.categoryBits = GROUND_BIT;
            fixture.setFilterData(filter);
        }
    }
}
