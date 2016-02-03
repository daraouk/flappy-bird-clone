package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.MyGdxGame;

/**
 * Created by dahua on 2/3/16.
 */
public class MenuState extends State {
    private Texture background;
    private Texture logo;
    private Texture credits;
    private Texture playBtn;

    private static final int CREDITS_OFFSET = 5;

    public MenuState(GameStateManager gsm) {
        super(gsm);
        cam.setToOrtho(false, MyGdxGame.WIDTH / 2, MyGdxGame.HEIGHT / 2);
        background = new Texture("bg.png");
        logo = new Texture("logo.png");
        credits = new Texture("credits.png");
        playBtn = new Texture("playbtn.png");
    }

    @Override
    public void handleInput() {
        if(Gdx.input.justTouched()) {
            gsm.set(new PlayState(gsm));
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(background, 0, 0);
        sb.draw(logo, cam.position.x - logo.getWidth() / 2, cam.position.y + playBtn.getHeight());
        sb.draw(playBtn, cam.position.x - playBtn.getWidth() / 2, cam.position.y);
        sb.draw(credits, cam.viewportWidth - credits.getWidth() - CREDITS_OFFSET, CREDITS_OFFSET);
        sb.end();
    }

    @Override
    public void dispose() {
        background.dispose();
        playBtn.dispose();
        logo.dispose();
        credits.dispose();

        System.out.println("Menu State Disposed");
    }
}
