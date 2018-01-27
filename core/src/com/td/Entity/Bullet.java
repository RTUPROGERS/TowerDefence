package com.td.Entity;

public class Bullet extends Entity {
	private int speed=100;
	private double startX;
	private double startY;
	private double targX;
	private double targY;
	
	public Bullet(double startX, double startY, double targX, double targY) {
		this.startX = startX;
		this.startY = startY;
		this.targX = targX;
		this.targY = targY;
	}
	
	public double getStartX() {
		return this.startX;
	}
	public double getStartY() {
		return this.startY;
	}
	public double getTargX() {
		return this.targX;
	}
	public double getTargY() {
		return this.targY;
	}
}