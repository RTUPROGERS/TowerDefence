package com.td.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.td.game.GameClass;

public class MainMenu implements Screen {
	private Stage stage;
	private GameClass game;
	
	
	public MainMenu(GameClass game) {
		this.game=game;
	}

		
	@Override
	public void show() {
		stage= new Stage();
		TextureAtlas atlas = new TextureAtlas(Gdx.files.internal("skin/skin.atlas"));
		Skin skin=new Skin(atlas);
		skin.load(Gdx.files.internal("skin/skin.json"));
		Table table = new Table();
		table.setFillParent(true);
		TextButton but = new TextButton("START BEST GAME EVER",skin);
		but.addListener(new ClickListener() {
			public void clicked(InputEvent event, float x, float y) {
				game.getLoader().finishLoad();
				game.setScreen(new GameScreen(game));
			}
		});
		table.add(but);
		
		stage.addActor(table);
		Gdx.input.setInputProcessor(stage);
	}

	@Override
	public void render(float delta) {
		stage.act();
		stage.draw();
		
		
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

}
