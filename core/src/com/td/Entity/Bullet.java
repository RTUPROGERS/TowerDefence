package com.td.Entity;

public class Bullet extends Entity {
	private int speed=3;
	private Mob target;
	private int damage;
	
	public Bullet(double startX, double startY, Mob m, int damage) {
		setX(startX);
		setY(startY);
		this.damage = damage;
		this.target = m;
	}
	public Mob getTarget() {
		return this.target;
	}
	public int getSpeed() {
		return this.speed;
	}
	public int getDamage() {
		return this.damage;
	}
}