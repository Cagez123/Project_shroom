package fi.tamk.tiko.projectshroom;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;

/**
 * Created by Kalle on 21.2.2017.
 */

public class MenuScreen implements Screen {
    final Main game;
    Texture  playButton;
    Rectangle playRectangle;
    Texture highScoreButton;
    Rectangle highScoreRectangle;
    Stage MenuStage;
    Actor Tatti;


    OrthographicCamera camera;

    public class MyTextInputListener implements Input.TextInputListener {
        @Override
        public void input (String text) {
        }

        @Override
        public void canceled () {
        }
    }

    public MenuScreen(final Main game) {
        this.game = game;
        playButton = new Texture("playButton.png");
        playRectangle = new Rectangle();
        highScoreButton = new Texture("highscoreButton.png");
        highScoreRectangle = new Rectangle();

        playRectangle.set(300,300,playButton.getWidth()/2,playButton.getHeight()/2);
        playRectangle.set(300,150,highScoreButton.getWidth()/2,highScoreButton.getHeight()/2);

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
        MenuStage = new Stage(new FitViewport(800,400));
        Gdx.input.setInputProcessor(MenuStage);
        Tatti = new Tatti();

        MenuStage.addActor(Tatti);
        MenuStage.setKeyboardFocus(Tatti);
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

        game.batch.begin();

        game.font.draw(game.batch, "Welcome to Rock paper scissors!!! ", 100, 100);
        game.batch.draw(playButton, 300, 300, playButton.getWidth() / 2, playButton.getHeight() / 2);
        game.batch.draw(highScoreButton, 300, 150, highScoreButton.getWidth() / 2, highScoreButton.getHeight() / 2);
        game.batch.end();

        MenuStage.act(Gdx.graphics.getDeltaTime());

        MenuStage.draw();

        if (Gdx.input.isTouched()) {

            int x = Gdx.input.getX();
            int y = Gdx.input.getY();
            Gdx.app.log("TAG", "x = " + x);
            Gdx.app.log("TAG", "y = " + y);
            MyTextInputListener listener = new MyTextInputListener();

            if (x >= 300 && x <= 300 + playButton.getWidth() / 2) {

                if (y >= 85 && y <= 175) {
                    Gdx.input.getTextInput(listener, "Enter name","", "Hint Value");
                    game.setScreen(new GameScreen(game));
                    dispose();
                }
            }
            if (x >= 300 && x <= 300 + playButton.getWidth() / 2) {
                if (y >= 235 && y <= 330) {
                    game.setScreen(new HighScoreScreen(game));
                    dispose();
                }
            }

        }
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
