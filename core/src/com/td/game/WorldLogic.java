package com.td.game;

import java.util.ArrayList;
import java.util.LinkedList;

import com.badlogic.gdx.Gdx;
import com.td.Entity.Entity;
import com.td.Entity.Mob;
import com.td.Entity.Weapon;
import com.td.Entity.default_mob;
import com.td.screens.GameScreen;
import com.td.util.Const;

public class WorldLogic {
private GameScreen game;
private int playerHp;
private int playerMoney;
private int[][] gameField;
private ArrayList<Point> path;
private int lvl;
private LinkedList<Weapon> weaponList;
private LinkedList<Mob> mobList;
private int spawn;
private boolean run;
private boolean buying;

	public WorldLogic(GameScreen g) {
		game=g;
		playerHp=Const.START_HP;
		playerMoney=Const.START_CASH;
		weaponList=new LinkedList();
		mobList=new LinkedList();
		gameField = MapGenerator.drawField();
		path=MapGenerator.getPoint();
		run=true;
		buying=false;
	}	
	
	public void update() {
		if(run) {
			playerMoney++;  //for test
			
			
			
			spawn();
			move();
			
		}
	}
	
	private void spawn() {
		if(spawn==0) {
			mobList.add(new default_mob(0,0));
			spawn=Const.SPAWN_RATE;
		}else spawn--;
	}
		
	
	private void move() {
		LinkedList<Entity> removeafter=new LinkedList();
		for(Mob m: mobList) {
			double x=m.getX();
			double y=m.getY();
			int speed=m.getSpeed();
			int curpoint=m.getCurrentPoint();
			if(curpoint==path.size()) {removeafter.add(m);playerHp--;continue;}
			
			double dX=path.get(curpoint-1).x-path.get(curpoint).x;
			double dY=path.get(curpoint-1).y-path.get(curpoint).y;
			if(x/10==path.get(curpoint).x&&y/10==path.get(curpoint).y) {m.setCurrentPoint(m.getCurrentPoint()+1);continue;}
			if(dX!=0) {
				if(dX<0) {
					m.setX(x+1);
				}else {
					m.setX(x-1);
					
				}
				
			}else {
				if(dY<0) {
					m.setY(y+1);
					
				}else {
					m.setY(y-1);
					
				
				
			}
			}
			/*if(path.get(curpoint).x<path.get(curpoint+1).x) {
				if(x<=path.get(curpoint).x)m.setX(x+0.2);
				
			}
			else {if(x>=path.get(curpoint).x) m.setX(x-0.2);} 
			
			if(path.get(curpoint).y<path.get(curpoint+1).y) {
				if(y<path.get(curpoint).y)m.setY(y+0.2);
			}
			else {if(y>path.get(curpoint).y) m.setY(y-0.2);}
			if(x==path.get(curpoint).x&&y==path.get(curpoint).y) {m.setCurrentPoint(m.getCurrentPoint()+1);Gdx.app.log("","up");}
			//if(path.get(curpoint).y<path.get(curpoint+1).y)
			//if(y<=path.get(curpoint).y)m.setY(y+0.1f);else m.setY(y-0.1f);
			Gdx.app.log(String.valueOf(m.getX()), String.valueOf(m.getY()));
			Gdx.app.log(String.valueOf(path.get(curpoint).x), String.valueOf(path.get(curpoint).y));*/
		}
		mobList.removeAll(removeafter);
		
		
	}
	
	
	public LinkedList<Entity> getEntity(){
		LinkedList ent = new LinkedList(weaponList);
		ent.addAll(mobList);
		return ent;
	}
	
	public int[][] getGameField(){
		
		return gameField;
	}
	
	public int getMoney() {return playerMoney;}
	public int getHP() {return playerHp;}
	public boolean isBuying() {return buying;}
	public ArrayList<Point> getPath() {return path;}
}
