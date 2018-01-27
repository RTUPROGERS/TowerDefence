package com.td.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.td.game.GameClass;
import com.td.game.Renderer;
import com.td.game.WorldLogic;
import com.td.util.InputHandler;

public class GameScreen implements Screen {
	private WorldLogic world;
	private Renderer renderer;
	private int height;
	private int width;
	private GameClass game;
	
public	GameScreen(GameClass game){
		height=Gdx.graphics.getHeight();
		width=Gdx.graphics.getWidth();
		world=new WorldLogic(this);
		renderer= new Renderer(this,game.getLoader().getManager());
		InputMultiplexer input= new InputMultiplexer(new InputHandler(this,world));	
		input.addProcessor(renderer.getStage());
		Gdx.input.setInputProcessor(input);
		this.game=game;
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
		this.height=height;
		this.width=width;
		renderer.updateView(height, width);
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
	
	public WorldLogic getWorld() {return world;}



	public int getHeight() {
		return height;
	}



	public void setHeight(int height) {
		this.height = height;
	}



	public int getWidth() {
		return width;
	}



	public void setWidth(int width) {
		this.width = width;
	}
	

}
