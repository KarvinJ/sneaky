package knight.arkham.screens;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.ScreenUtils;
import knight.arkham.Dark;
import knight.arkham.helpers.Constants;
import knight.arkham.helpers.LevelLoader;

public class GameScreen3 extends ScreenAdapter {

    private final Dark game;
    private final OrthographicCamera camera;
    private final LevelLoader mapHelper;

    public GameScreen3() {

        Constants.ShouldChangeLevel = false;

        game = Dark.INSTANCE;

        camera = game.camera;

        mapHelper = new LevelLoader("maps/level3.tmx");
    }

    @Override
    public void resize(int width, int height) {
        game.viewport.update(width, height);
    }

    @Override
    public void render(float deltaTime) {

        if (Constants.ShouldChangeLevel)
            game.setScreen(new GameScreen());

        else {

            ScreenUtils.clear(0, 0, 0, 0);

            mapHelper.update(deltaTime, camera);

            mapHelper.draw(camera);
        }
    }

    @Override
    public void hide() {
        dispose();
    }

    @Override
    public void dispose() {
        mapHelper.dispose();
    }
}
