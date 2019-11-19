package sarthak.bludborne.desktop;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import sarthak.bludborne.Main;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "BludBorne";
		config.resizable = false;
		config.width = 800;
		config.height = 600;
		config.useGL30 = false;

		new LwjglApplication(new Main(), config).setLogLevel(Application.LOG_DEBUG);
	}
}
