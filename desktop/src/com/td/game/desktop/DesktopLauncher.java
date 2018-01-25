package com.td.game.desktop;

import java.awt.Dimension;
import java.awt.Toolkit;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.td.game.GameClass;

public class DesktopLauncher {
	public static void main (String[] arg) {
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.fullscreen=false;
		config.height=screen.height;
		config.width=screen.width;
		new LwjglApplication(new GameClass(), config);
	}
}
