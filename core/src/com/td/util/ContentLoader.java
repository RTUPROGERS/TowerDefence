package com.td.util;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;

public class ContentLoader {
	private AssetManager manager ;
	public ContentLoader() {
		manager=new AssetManager();
		manager.load("textures/hp.png",Texture.class);	
		manager.load("textures/cash.png",Texture.class);
		manager.load("textures/wepD.png",Texture.class);
		manager.load("textures/floor1.png",Texture.class);
		manager.load("textures/floor2.png",Texture.class);
		manager.load("textures/coin.png",Texture.class);
	}
	
	public void finishLoad() {manager.finishLoading();}
	
	public AssetManager getManager() {return manager;}
	
	
}
