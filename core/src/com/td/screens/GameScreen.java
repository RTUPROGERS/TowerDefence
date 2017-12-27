package com.td.screens;

import com.badlogic.gdx.Screen;
import com.td.game.Renderer;
import com.td.game.WorldLogic;

public class GameScreen implements Screen {
	private WorldLogic world;
	private Renderer renderer;
	
	
public	GameScreen(){
		world=new WorldLogic(this);
		renderer= new Renderer(this);
		
		
	}
	
	
	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(float delta) {
		world.update();
		renderer.render();
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}
	
	private WorldLogic getWorld() {return world;}


}
