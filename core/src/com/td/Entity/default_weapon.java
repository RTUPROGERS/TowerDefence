package com.td.Entity;

public class default_weapon extends Weapon {
	
	public default_weapon(int x, int y) {
		setX(x);
		setY(y);
		setTextureNumber(1);
		setRange(50);
		setRangePerLevel(50);
		setDamage(100);
		setDamagePerLevel(10);
		setCost(300);
		setCostPerLevel(250);
		setLevel(1);
		setMaxLevel(5);
		setFireRate(60);
	}
}
