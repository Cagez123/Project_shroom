package fi.tamk.tiko.projectshroom;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;

/**
 * Created by Kalle on 21.2.2017.
 */

public class GameScreen implements Screen {

    final Main game;
    OrthographicCamera camera;
    Stage gameStage;


    public GameScreen(final Main game) {
        this.game = game;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
        gameStage = new Stage(new FitViewport(800,
                480), game.batch);

        Gdx.input.setInputProcessor(gameStage);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        game.batch.setProjectionMatrix(camera.combined);
        gameStage.act(Gdx.graphics.getDeltaTime());
        gameStage.draw();
        game.batch.begin();
        game.font.draw(game.batch, "THIS IS THE GAME SCREEN ", 300, 150);
        game.font.draw(game.batch, "ROCKS PAPUR SCISRROR", 300, 100);
        game.batch.end();

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
