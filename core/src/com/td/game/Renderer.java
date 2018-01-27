package com.td.game;

import java.util.ArrayList;
import java.util.LinkedList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.HorizontalGroup;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.VerticalGroup;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
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
	private ScreenViewport view;
	private AssetManager manager;
	
	
	public Renderer(GameScreen g,AssetManager manager){
		this.manager=manager;
		
		hudTextures= new Texture[2];
		hudTextures[0]=manager.get("textures/hp.png");
		hudTextures[1]=manager.get("textures/cash.png");
		
		
		game=g;
		cam = new OrthographicCamera();
		cam.setToOrtho(false, g.getWidth(), g.getHeight());
		shapeRenderer = new ShapeRenderer();
		view=new ScreenViewport(cam);
		
	    shapeRenderer.setProjectionMatrix(cam.combined);
	    world=game.getWorld();
	    initStage();
	    
	}
	private void initStage() {
		stage= new Stage();
		skin= new Skin();
		Table tableHUD = new Table();
		//tableHUD.setDebug(true);
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
		
		Table tableShop= new Table();
		for(int i=0;i<150;i++) {
			Label lab= new Label("HEALTH"+i,new Label.LabelStyle(new BitmapFont(), Color.RED));
			tableShop.add(lab);
			tableShop.row();
		}
		ScrollPane buyList= new ScrollPane(tableShop);
		Table scrolltable= new Table();
		scrolltable.add(buyList);
		scrolltable.left();
		scrolltable.setFillParent(true);
		stage.addActor(scrolltable);

		
	}
	
	
	public void render() {
		 Gdx.gl.glClearColor(200, 200, 200, 1);
	     Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	     LinkedList<Entity> ent = world.getEntity();
	     int[][] field=world.getGameField();
	     ArrayList<Point> path=world.getPath();
	
	     shapeRenderer.setAutoShapeType(true);
	          if(world.isBuying()) {
	        	  shapeRenderer.begin();
	        	if(Gdx.app.getInput().getX()<100) {
	        	int x= Gdx.app.getInput().getX()-Const.CELL_SIZE/2;
	        	int y=Gdx.graphics.getHeight()-Gdx.app.getInput().getY()-Const.CELL_SIZE/2;
	        	System.out.println(y);
	    	 
	        	shapeRenderer.set(ShapeType.Filled);
	        	shapeRenderer.setColor(Color.RED);
	        	shapeRenderer.rect(x, y, Const.CELL_SIZE, Const.CELL_SIZE);
	    	   
	        	  }else {
	        		  int x= Gdx.app.getInput().getX();
	  	        	int y=Gdx.graphics.getHeight()-Gdx.app.getInput().getY();
	  	        	x=(x/Const.CELL_SIZE)*Const.CELL_SIZE+5;
	  	        	y=(y/Const.CELL_SIZE)*Const.CELL_SIZE+5;
	  	        	shapeRenderer.set(ShapeType.Filled);
		        	shapeRenderer.setColor(Color.RED);
		        	shapeRenderer.rect(x, y, Const.CELL_SIZE, Const.CELL_SIZE);
	        		  
	        	  }

	    	 shapeRenderer.end();
	     }

	     
	     shapeRenderer.begin();
	     shapeRenderer.setColor(Color.BROWN);
	     for(int i=0;i<field.length;i++) {
	    	 for(int j=0;j<field[i].length;j++) {
	    		// if(field[i][j]==0)shapeRenderer.setColor(Color.GREEN);else shapeRenderer.setColor(Color.BROWN);
	    		 shapeRenderer.rect(100+i*Const.CELL_SIZE, 100+j*Const.CELL_SIZE, Const.CELL_SIZE, Const.CELL_SIZE);
	    		 
	    		 
	    	 }
	    	 
	     }
	     shapeRenderer.setColor(Color.BLUE);
	     for(Point p:path)shapeRenderer.rect(100+p.x*Const.CELL_SIZE, 100+p.y*Const.CELL_SIZE, Const.CELL_SIZE, Const.CELL_SIZE);
	     shapeRenderer.setColor(Color.RED);
	     for(Entity e : ent) {
	    	 shapeRenderer.circle(100+(float)e.getX()/10*Const.CELL_SIZE+Const.CELL_SIZE/2, 100+(float)e.getY()/10*Const.CELL_SIZE+Const.CELL_SIZE/2, Const.CELL_SIZE/2);

	    	 
	     }
	     shapeRenderer.end();
	    hpLab.setText(String.valueOf(world.getHP())); 
	    cashLab.setText(String.valueOf(world.getMoney())); 
		stage.act();
		stage.draw();

	}
	
	public void setEntityTextures(Texture[] entityTextures) {
		this.entityTextures = entityTextures;
	}
	public void setFieldTextures(Texture[] fieldTextures) {
		this.fieldTextures = fieldTextures;
	}
	public void setHudTextures(Texture[] hudTextures) {
		this.hudTextures = hudTextures;
	}
	public Stage getStage() {return stage;}
	
	public void updateView(int h,int w) {
		view.update(w, h);
		
	}
	

	
	
	
}
