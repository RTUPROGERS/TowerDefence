package com.td.Entity;

public class Mob extends Entity {
	private int health;
	private int health_per_level;
	private int level;
	private double speed;
	private double speed_per_level;
	private int cost;
	private int cost_per_level;
	private int currentPoint;
	
	public void setHealth(int health) {
		this.health = health;
	}
	
	public int getHealth() {
		return this.health;
	}

	public void setHealthPerLevel(int health) {
		this.health_per_level = health;
	}
	
	public int getHealthPerLevel() {
		return this.health_per_level;
	}
	
	public void setLevel(int level) {
		this.level = level;
	}
	
	public int getLevel() {
		return this.level;
	}
	
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	
	public double getSpeed() {
		return this.speed;
	}
	
	public void setSpeedPerLevel (double speed) {
		this.speed_per_level = speed;
	}
	
	public double getSpeedPerLevel() {
		return this.speed_per_level;
	}
	
	public void setCost(int cost) {
		this.cost = cost;
	}
	
	public int getCost() {
		return this.cost;
	}
	
	public void setCostPerLevel(int cost) {
		this.cost_per_level = cost;
	}
	
	public int getCostPerLevel() {
		return this.cost_per_level;
	}

	public int getCurrentPoint() {
		return currentPoint;
	}

	public void setCurrentPoint(int currentPoint) {
		this.currentPoint = currentPoint;
	}
}
