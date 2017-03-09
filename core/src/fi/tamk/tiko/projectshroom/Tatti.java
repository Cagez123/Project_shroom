package fi.tamk.tiko.projectshroom;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * Created by Kalle on 9.3.2017.
 */

public class Tatti extends Actor {
    private Texture texture;

    public Tatti() {
        texture = new Texture(Gdx.files.internal("badlogic.jpg"));
        setWidth(texture.getWidth() / 100f);
        setHeight(texture.getHeight() / 100f);
        setBounds(0, 0, getWidth(), getHeight());
    }
    @Override
    public void draw(Batch batch, float alpha) {
        batch.draw(texture, getX(), getY(), getWidth(), getHeight());
    }
    @Override
    public void act(float delta) {
        super.act(delta);
    }

}