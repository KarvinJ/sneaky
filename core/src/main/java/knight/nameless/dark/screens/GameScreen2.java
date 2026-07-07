package knight.nameless.dark.screens;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.audio.Music;
import knight.nameless.dark.Dark;
import knight.nameless.dark.helpers.AssetsHelper;
import knight.nameless.dark.helpers.Constants;
import knight.nameless.dark.helpers.LevelLoader;

public class GameScreen2 extends ScreenAdapter {

    private final Dark game;
    private final LevelLoader mapHelper;
    private final Music music;

    public GameScreen2() {

        Constants.ShouldChangeLevel = false;

        game = Dark.INSTANCE;

        mapHelper = new LevelLoader("maps/level2.tmx", game);
        music = AssetsHelper.loadMusic("peaceful.wav");
        music.play();
//        music.setVolume(0.2f);
        music.setLooping(true);
    }

    @Override
    public void resize(int width, int height) {
        game.viewport.update(width, height);
    }

    @Override
    public void render(float deltaTime) {

        if (Constants.ShouldChangeLevel)
            game.setScreen(new GameScreen3());

        else {

            mapHelper.update(deltaTime);
            mapHelper.draw();
        }
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
