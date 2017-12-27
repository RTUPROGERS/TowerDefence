package com.td.Entity;

public class default_mob extends Mob {
	default_mob(int x, int y) {
		setX(x);
		setY(y);
		setTextureNumber(2);
		setSpeed(10);
		setSpeedPerLevel(5);
		setHealth(100);
		setHealthPerLevel(25);
		setLevel(1);
		setCost(100);
		setCostPerLevel(50);
	}
}
