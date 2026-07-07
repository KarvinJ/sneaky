package knight.nameless.dark.screens;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.audio.Music;
import knight.nameless.dark.Dark;
import knight.nameless.dark.helpers.AssetsHelper;
import knight.nameless.dark.helpers.Constants;
import knight.nameless.dark.helpers.LevelLoader;

public class PlayGroundScreen extends ScreenAdapter {

    private final Dark game;
    private final LevelLoader mapHelper;
    private final Music music;

    public PlayGroundScreen() {

        Constants.ShouldChangeLevel = false;

        game = Dark.INSTANCE;

        mapHelper = new LevelLoader("maps/playground.tmx", game);

        music = AssetsHelper.loadMusic("peaceful.wav");
        music.play();
        music.setLooping(true);
    }

    @Override
    public void resize(int width, int height) {
        game.viewport.update(width, height);
    }

    @Override
    public void render(float deltaTime) {

        mapHelper.update(deltaTime);
        mapHelper.draw();
    }

    @Override
    public void hide() {
        dispose();
    }

    @Override
    public void dispose() {
        mapHelper.dispose();
        music.dispose();
    }
}
