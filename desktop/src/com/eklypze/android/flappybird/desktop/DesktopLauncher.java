package com.eklypze.android.flappybird.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.eklypze.android.flappybird.FlappyBirdClone;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = FlappyBirdClone.WIDTH;
		config.height = FlappyBirdClone.HEIGHT;
		config.title = FlappyBirdClone.TITLE;
		new LwjglApplication(new FlappyBirdClone(), config);
	}
}
