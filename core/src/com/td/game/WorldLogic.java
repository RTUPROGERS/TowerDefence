package com.td.game;

import java.util.ArrayList;
import java.util.LinkedList;

import com.badlogic.gdx.Gdx;
import com.td.Entity.Bullet;
import com.td.Entity.Entity;
import com.td.Entity.Mob;
import com.td.Entity.Weapon;
import com.td.Entity.default_mob;
import com.td.Entity.default_weapon;
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
private LinkedList<Bullet> bulletList;
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
		bulletList = new LinkedList();
		gameField = MapGenerator.drawField();
		path=MapGenerator.getPoint();
		run=true;
		buying=false;		
		spawnWeapon(50,60);
	}	
	
	public void update() {
		if(run) {

			
			
			
			spawn();
			//System.out.println("SPAWN");
			move();
			//System.out.println("MOVE");
			fire();
			//System.out.println("FIRE");
			bulletFly();
		}
	}
	
	private void spawn() {
		if(spawn==0) {
			mobList.add(new default_mob(0,0));
			spawn=Const.SPAWN_RATE;			
			playerMoney++;  //for test
		}else spawn--;
	}
	private void spawnWeapon(int x, int y) {
		weaponList.add(new default_weapon(x,y));
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
	
	public void fire() {
		LinkedList<Entity> removeafter=new LinkedList();
		for (Weapon w: weaponList) {
			if(w.getCurrentTick()!=0) {
				w.setCurrentTick(w.getCurrentTick()-1);
				continue;
			}
			double wepX = w.getX();
			double wepY = w.getY();
			double r = w.getRange();
			for (Mob m : mobList) {
				double mobX = m.getX();
				double mobY = m.getY(); // krug ----> (x-a)^2 + (y-b)^2 = R^2; x,y = mobx,y; a,b = wepx,y;
				if (Math.pow(mobX - wepX, 2) + Math.pow(mobY - wepY, 2) < r*r) {
				// прямая, координата у - y = (x-x1) * (y2 - y1) / (x2 - x1) + y1; gde y - bullY, x - bullX, x1 - startX, x2 = targX;
					w.setCurrentTick(w.getFireRate());
					bulletList.add(new Bullet(wepX, wepY,m, w.getDamage()));
				/*	int hp = m.getHealth();
					hp = hp - w.getDamage();
					m.setHealth(hp);
					if (m.getHealth() <= 0) {
						removeafter.add(m);
						playerMoney+=m.getCost()+m.getCostPerLevel()*m.getLevel();
					} */
					break;
				}
			}
		}
		mobList.removeAll(removeafter);
	}
	
	public void bulletFly() {
		LinkedList<Entity> removeafter=new LinkedList();
		LinkedList<Entity> removeafter2=new LinkedList();
		for (Bullet b : bulletList) {
			Mob m = b.getTarget();
			double startX = b.getX();
			double startY = b.getY();
			System.out.println(startX);
			double targX = m.getX();
			double targY = m.getY();
			double bullX = startX;
			double bullY = startY;
			if (bullX >= targX) {
					bullX-=b.getSpeed();
					bullY = (bullX - startX) * (targY - startY) / (targX - startX) + startY;
					b.setX(bullX);
					b.setY(bullY);
					if (bullX <= targX) {
						removeafter.add(b);
					}
				
			} else
			{
				
					bullX+=b.getSpeed();
					bullY = (bullX - startX) * (targY - startY) / (targX - startX) + startY;
					b.setX(bullX);
					b.setY(bullY);
					if (bullX >= targX) {
						removeafter.add(b);
					}
				
			}
			int hp = m.getHealth();
			hp = hp - b.getDamage();
			m.setHealth(hp);
			if (m.getHealth() <= 0) {
				removeafter2.add(m);
				playerMoney+=m.getCost()+m.getCostPerLevel()*m.getLevel();
			}
		
		}
		bulletList.removeAll(removeafter);
		mobList.removeAll(removeafter2);
	}
	
	
	public LinkedList<Entity> getEntity(){
		LinkedList ent = new LinkedList(weaponList);
		ent.addAll(mobList);
		ent.addAll(bulletList);
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
