package com.mygdx.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by dahua on 2/3/16.
 */
public class Bird {
    private static final int GRAVITY = -15;
    private static final int MOVEMENT = 100;

    private Vector3 position;
    private Vector3 velocity;
    private Texture bird;

    private Rectangle bounds;

    public Bird(int x, int y) {
        position = new Vector3(x, y, 0);
        velocity = new Vector3(0, 0, 0);
        bird = new Texture("bird.png");
        bounds = new Rectangle(x, y, bird.getWidth(), bird.getHeight());
    }

    public void update(float dt) {
        // only add gravity if y > 0
        if(position.y > 0) { velocity.add(0, GRAVITY, 0); }

        velocity.scl(dt); // scale velocity by change in time (dt)
        position.add(MOVEMENT * dt, velocity.y, 0);

        // don't allow bird to go below y = 0
        if(position.y < 0) {
            position.y = 0;
        }

        velocity.scl(1/dt); // reverse scaling

        bounds.setPosition(position.x, position.y);
    }

    public Vector3 getPosition() {
        return position;
    }

    public Texture getTexture() {
        return bird;
    }

    public void jump() {
        velocity.y = 250;
    }

    public Rectangle getBounds() {
        return bounds;
    }
}
