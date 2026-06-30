package knight.nameless.dark;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.loaders.SkinLoader;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import knight.nameless.dark.screens.MainMenuScreen;

import static knight.nameless.dark.helpers.Constants.PIXELS_PER_METER;

public class Dark extends Game {

    public static Dark INSTANCE;
    public OrthographicCamera camera;
    public AssetDescriptor<Skin> uiSkin;
    public Viewport viewport;
    public int screenWidth = 960;
    public int screenHeight = 544;

    public Dark() {

        INSTANCE = this;
    }

    @Override
    public void create() {

        camera = new OrthographicCamera();

        viewport = new FitViewport(
            screenWidth / PIXELS_PER_METER,
            screenHeight / PIXELS_PER_METER,
            camera
        );

        camera.zoom -= 0.4f;

        camera.position.set(screenWidth / 2f / PIXELS_PER_METER, screenHeight / 2f / PIXELS_PER_METER, 0);

        uiSkin = new AssetDescriptor<>(
            "ui/uiskin.json", Skin.class, new SkinLoader.SkinParameter("ui/uiskin.atlas")
        );

        setScreen(new MainMenuScreen());
    }
}
