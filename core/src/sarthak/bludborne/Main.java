package sarthak.bludborne;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import sarthak.bludborne.screens.MainGameScreen;

public class Main extends Game {
	MainGameScreen mainGameScreen = new MainGameScreen();

	@Override
	public void create () {
		setScreen(mainGameScreen);
	}
	
	@Override
	public void dispose () {
		mainGameScreen.dispose();
	}
}
