package com.td.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.td.game.Renderer;
import com.td.game.WorldLogic;
import com.td.util.InputHandler;

public class GameScreen implements Screen {
	private WorldLogic world;
	private Renderer renderer;
	private int height;
	private int width;

	
public	GameScreen(){
		height=Gdx.graphics.getHeight();
		width=Gdx.graphics.getWidth();
		world=new WorldLogic(this);
		renderer= new Renderer(this);
		InputMultiplexer input= new InputMultiplexer(new InputHandler(this,world));
		input.addProcessor(renderer.getStage());
		Gdx.input.setInputProcessor(input);
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
