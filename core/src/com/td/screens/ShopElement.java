package com.td.screens;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.HorizontalGroup;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.td.game.WorldLogic;

public class ShopElement extends HorizontalGroup {
private  int id;
private static Texture coin;
private int cost;
private WorldLogic logic;
	public ShopElement(Texture image, int cost,final int id,final WorldLogic logic){
		super();
		Image texture = new Image(image);
		Label costLabel = new Label(String.valueOf(cost),new Label.LabelStyle(new BitmapFont(), Color.GOLD));
		Image coinImage =new Image(coin);
		this.cost=cost;
		this.id=id;
		this.logic=logic;
		super.addListener(new ClickListener() {
			public void clicked(InputEvent event, float x, float y) {
				logic.setBuyingid(id);
				logic.setBuying(true);
			}
		});
		super.addActor(texture);
		super.addActor(coinImage);
		super.addActor(costLabel);
	}
	
public static void setCoinTexture(Texture tex) {coin=tex;}	
	
}
