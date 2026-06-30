package knight.nameless.dark.helpers;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

public class AnimationHelper {

    public static Animation<TextureRegion> makeAnimation(TextureRegion region, int totalFrames, float frameDuration) {

        int regionWidth = region.getRegionWidth() / totalFrames;

        Array<TextureRegion> animationFrames = new Array<>();

        for (int i = 0; i < totalFrames; i++) {

            animationFrames.add(
                new TextureRegion(region, i * regionWidth, 0, regionWidth, region.getRegionHeight())
            );
        }

        return new Animation<>(frameDuration, animationFrames);
    }
}
