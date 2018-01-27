package com.td.game;

import com.badlogic.gdx.Game;
import com.td.screens.MainMenu;
import com.td.util.ContentLoader;

public class GameClass extends Game {
	private ContentLoader loader;
	
	@Override
	public void create () {
		loader=new ContentLoader();
		setScreen(new MainMenu(this));
	}
	
	public ContentLoader getLoader() {return loader;}
	

}
