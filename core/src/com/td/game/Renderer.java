package com.td.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.td.screens.GameScreen;

public class Renderer {
	private GameScreen game;
	private OrthographicCamera cam;
	
	public Renderer(GameScreen g){
		game=g;
		cam = new OrthographicCamera();
		cam.setToOrtho(false, 1600, 1200);
		
	}
	
	public void render() {
		 Gdx.gl.glClearColor(200, 200, 200, 1);
	     Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		
	}
	
	
}
