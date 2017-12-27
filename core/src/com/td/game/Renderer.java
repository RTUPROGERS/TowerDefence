package com.td.game;

import java.util.LinkedList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.td.Entity.Entity;
import com.td.screens.GameScreen;

public class Renderer {
	private GameScreen game;
	private WorldLogic world;
	private OrthographicCamera cam;
	private Texture[] entityTextures;
	private Texture[] fieldTextures;
	private ShapeRenderer shapeRenderer;
	public Renderer(GameScreen g){
		game=g;
		cam = new OrthographicCamera();
		cam.setToOrtho(false, 1600, 1200);
		shapeRenderer = new ShapeRenderer();
	    shapeRenderer.setProjectionMatrix(cam.combined);
	    world=game.getWorld();
	}
	
	public void render() {
		 Gdx.gl.glClearColor(200, 200, 200, 1);
	     Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	     LinkedList<Entity> ent = world.getEntity();
	     int[][] field=world.getGameField();
	     shapeRenderer.setAutoShapeType(true);
	     shapeRenderer.begin();
	     for(int i=0;i<field.length;i++) {
	    	 for(int j=0;j<field[i].length;j++) {
	    		 if(field[i][j]==0)shapeRenderer.setColor(Color.GREEN);else shapeRenderer.setColor(Color.BROWN);
	    		 shapeRenderer.rect(100+i*40, j*40, 40, 40);
	    		 
	    		 
	    	 }
	    	 
	     }
	     for(Entity e : ent) {
	    	 shapeRenderer.circle(e.getX()*40+20, e.getY()*40+20, 20);
	    	 
	    	 
	     }
	     shapeRenderer.end();
		
	}
	

	
	
	
}
