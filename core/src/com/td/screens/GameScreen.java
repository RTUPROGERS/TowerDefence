package com.td.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.td.game.Renderer;
import com.td.game.WorldLogic;
import com.td.util.InputHandler;

public class GameScreen implements Screen {
	private WorldLogic world;
	private Renderer renderer;
	private Stage stage;
	private Table table;
	private int i;
	
public	GameScreen(){
		world=new WorldLogic(this);
		renderer= new Renderer(this);
		 Gdx.input.setInputProcessor(new InputHandler(this,world));
		stage= new Stage();
		table = new Table();
		table.setFillParent(true);
		stage.addActor(table);
		table.setDebug(true);
		i=0;
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
	
	public WorldLogic getWorld() {return world;}


}
