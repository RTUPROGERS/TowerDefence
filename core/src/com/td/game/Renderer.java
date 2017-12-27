package com.td.game;

import java.util.LinkedList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.HorizontalGroup;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.VerticalGroup;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.td.Entity.Entity;
import com.td.screens.GameScreen;
import com.td.util.Const;

public class Renderer {
	private GameScreen game;
	private WorldLogic world;
	private OrthographicCamera cam;
	private Texture[] entityTextures;
	private Texture[] fieldTextures;
	private ShapeRenderer shapeRenderer;
	private Stage stage;
	private Skin skin;
	private Texture[] hudTextures;
	private Label hpLab;
	private Label cashLab;
	private StretchViewport view;
	
	
	public Renderer(GameScreen g){
		hudTextures= new Texture[2];
		hudTextures[0]=new Texture(Gdx.files.internal("textures/hp.png"));
		hudTextures[1]=new Texture(Gdx.files.internal("textures/cash.png"));
		
		
		game=g;
		cam = new OrthographicCamera();
		cam.setToOrtho(false, g.getWidth(), g.getHeight());
		shapeRenderer = new ShapeRenderer();
		view=new StretchViewport(g.getWidth(),g.getHeight(),cam);
		
	    shapeRenderer.setProjectionMatrix(cam.combined);
	    world=game.getWorld();
	    initStage();
	    
	}
	private void initStage() {
		stage= new Stage();
		skin= new Skin();
		Table tableHUD = new Table();
		tableHUD.setFillParent(true);
		Image hp = new Image(hudTextures[0]);
		hpLab=new Label("HEALTH",new Label.LabelStyle(new BitmapFont(), Color.RED));
		Image cash = new Image(hudTextures[1]);
		cashLab=new Label("MONEY",new Label.LabelStyle(new BitmapFont(), Color.RED));
		HorizontalGroup hpGroup= new HorizontalGroup();
		hpGroup.addActor(hp);
		hpGroup.addActor(hpLab);
		HorizontalGroup cashGroup= new HorizontalGroup();
		cashGroup.addActor(cash);
		cashGroup.addActor(cashLab);
		VerticalGroup vGroup = new VerticalGroup();
		vGroup.addActor(hpGroup);
		vGroup.addActor(cashGroup);
		tableHUD.top().right();
		tableHUD.add(vGroup).padRight(5.0f);
		stage.addActor(tableHUD);

		
	}
	
	
	public void render() {
		 Gdx.gl.glClearColor(200, 200, 200, 1);
	     Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	     LinkedList<Entity> ent = world.getEntity();
	     int[][] field=world.getGameField();
	     
	     if(world.isBuying()) {
	    	 Gdx.app.getInput().getX();
	    	 
	    	 
	     }
	     
	     shapeRenderer.setAutoShapeType(true);
	     shapeRenderer.begin();
	     for(int i=0;i<field.length;i++) {
	    	 for(int j=0;j<field[i].length;j++) {
	    		 if(field[i][j]==0)shapeRenderer.setColor(Color.GREEN);else shapeRenderer.setColor(Color.BROWN);
	    		 shapeRenderer.rect(100+i*Const.CELL_SIZE, 100+j*Const.CELL_SIZE, Const.CELL_SIZE, Const.CELL_SIZE);
	    		 
	    		 
	    	 }
	    	 
	     }
	     shapeRenderer.setColor(Color.RED);
	     for(Entity e : ent) {
	    	 shapeRenderer.circle(100+e.getX()*Const.CELL_SIZE+Const.CELL_SIZE/2, 100+e.getY()*Const.CELL_SIZE+Const.CELL_SIZE/2, Const.CELL_SIZE/2);
	    	 
	    	 
	     }
	     shapeRenderer.end();
	    hpLab.setText(String.valueOf(world.getHP())); 
	    cashLab.setText(String.valueOf(world.getMoney())); 
		stage.act();
		stage.draw();
	}
	
	public Stage getStage() {return stage;}
	
	public void updateView(int h,int w) {
		view.update(w, h);
		
	}
	
	
	
}
