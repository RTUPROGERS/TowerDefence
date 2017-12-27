package com.td.Entity;

public class Weapon extends Entity {
	private int range;
	private int range_per_level;
	private int damage;
	private int damage_per_level;
	private int cost;
	private int cost_per_level;
	private int level;
	private int max_level;
	private int fire_rate;
	private int current_tick;
	
	public void setRange(int range) {
		this.range = range;
	}
	public int getRange() {
		return this.range;
	}
	public void setRangePerLevel(int range) {
		this.range_per_level = range;
	}
	public int getRangePerLevel() {
		return this.range_per_level;
	}
	
	public void setDamage(int damage) {
		this.damage = damage;
	}
	
	public int getDamage() {
		return this.damage;
	}
	
	public void setDamagePerLevel(int damage) {
		this.damage_per_level = damage;
	}
	
	public int getDamagePerLevel() {
		return this.damage_per_level;
	}
	
	public void setLevel(int level) {
		this.level = level;
	}
	
	public int getLevel() {
		return this.level;
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
	
	public void setMaxLevel(int level) {
		this.max_level = level;
	}
	public int getMaxLevel() {
		return this.max_level;
	}
		
	public void Upgrade() {
		this.level++;
	}
	
	public void setFireRate(int rate) {
		this.fire_rate = rate;
	}
	
	public int getFireRate() {
		return this.fire_rate;
	}
	
	public void setCurrentTick(int tick) {
		this.current_tick = tick;
	}
	
	public int getCurrentTick() {
		return this.current_tick;
	}
	
}
