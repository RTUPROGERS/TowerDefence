package com.td.Entity;

public class default_mob extends Mob {
	public default_mob(int x, int y) {
		setX(x);
		setY(y);
		setTextureNumber(2);
		setSpeed(0);
		setSpeedPerLevel(1);
		setHealth(100);
		setHealthPerLevel(25);
		setLevel(1);
		setCost(100);
		setCostPerLevel(50);
		setCurrentPoint(1);
	}
}
