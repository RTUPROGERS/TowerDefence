package com.td.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector3;
import com.td.game.WorldLogic;
import com.td.screens.GameScreen;

public class InputHandler implements InputProcessor {
	private GameScreen screen;
	private WorldLogic world;
	private OrthographicCamera cam;
	public InputHandler(GameScreen screen,WorldLogic world){
		this.screen=screen;
		this.world=world;
		cam=screen.getRenderer().getCam();
	}
	public InputHandler() {}
	
	
	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		switch(character) {
		case '1': Gdx.app.log("Handler", "1"); break;
		case '2': Gdx.app.log("Handle", "2"); break;
		case '3': Gdx.app.exit(); break;

		}
	
		
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		Gdx.app.log("Handler",String.valueOf(screenX)+"   "+String.valueOf(screenY)+"   "+String.valueOf(pointer)+"   "+String.valueOf(button));
		switch(button) {
		case 1: 
			world.setBuying(false);
			break;
		case 0:
			if (world.isBuying()) {
				 Vector3 coord = cam.unproject(new Vector3(screenX,screenY,0));
				int x= (((int)coord.x-100)/Const.CELL_SIZE);
				int y= (((int)coord.y-100)/Const.CELL_SIZE);
				world.spawnWeapon(x*10,y*10);
				world.setBuying(false);
			}break;
		}
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

}
