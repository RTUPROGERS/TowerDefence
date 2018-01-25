package com.td.Entity;

public class Bullet extends Entity {
	private int speed=100;
	private Mob target;
	public Bullet(double startX, double startY) {
		setX(startX);
		setY(startY);
	}
}