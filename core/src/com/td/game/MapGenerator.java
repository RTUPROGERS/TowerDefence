package com.td.game;

import java.util.ArrayList;

public class MapGenerator {
	public static int[][] l;
	public static int[][] drawField() {
		int[][] Field = {
				{0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
				{0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
				{0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
				{1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
				{1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
				{1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
				{1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
				{1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
				{1,1,1,1,1,1,1,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1},
				{1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1},
				{1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1},
				{1,1,1,1,1,1,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1},
				{1,1,1,1,1,1,0,1,1,1,1,1,1,1,0,0,0,0,0,0,1,1,1,1,1},
				{1,1,1,1,1,1,0,1,1,1,1,1,1,1,0,1,1,1,1,0,1,1,1,1,1},
				{1,1,1,1,1,1,0,1,1,1,1,1,1,1,0,1,1,1,1,0,1,1,1,1,1},
				{1,0,0,0,1,1,0,1,1,1,1,1,1,1,0,1,1,1,1,0,1,1,1,1,1},
				{1,0,1,0,1,1,0,1,1,1,1,1,1,1,0,1,1,1,1,0,1,1,1,1,1},
				{1,0,1,0,1,1,0,1,1,1,1,1,1,1,0,1,1,1,1,0,1,1,1,1,1},
				{1,0,1,0,1,1,0,0,0,0,0,0,0,0,0,1,1,1,1,0,1,1,1,1,1},
				{1,0,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1},
				{1,0,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1},
				{1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1},
				{1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
				{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0}
		};
		return Field;
	}
	
	public static ArrayList<Point> getPoint() {
		ArrayList<Point> points=new ArrayList();
		l=drawField();
		points=recursion(-1,0,3);
		return points;
	}
	
	private static ArrayList<Point> recursion(int x, int y, int w){
		ArrayList<Point> path=new ArrayList();
		
		String ww="";
		int x0=x,y0=y;
		boolean t=true;
		        switch(w){
		            case 1: x--; break;
		            case 2: y++; break;
		            case 3: x++; break;
		            case 4: y--; break;
		        }

		while(t){
		    if(x==l.length-1&&y==l[x].length-1){
		    	path.add(new Point(x,y));
		    
		    return path ;
		    }
		path.add(new Point(x,y));
		if(x-1!=x0 && x-1>=0 && x-1<l.length && l[x-1][y]==0)ww=ww+"1";
		if(x+1!=x0 && x+1>=0&&x+1<l.length&&l[x+1][y]==0)ww=ww+"3";
		if(y-1!=y0&& y-1>=0&& y-1<l[x].length &&l[x][y-1]==0)ww=ww+"4";
		if(y+1!=y0&&y+1>=0&&y+1<l[x].length&&l[x][y+1]==0)ww=ww+"2";

		if(ww.length()>0){
		    if(ww.length()==1){
		        switch(ww){
		            case "1":x0=x;y0=y; x--; break;
		            case "2":y0=y;x0=x; y++; break;
		            case "3":x0=x;y0=y; x++; break;
		            case "4":y0=y;x0=x; y--; break;
		        }
		        ww="";
		    }else{
		        t=false;
		    for(int i=0;i<ww.length();i++){
		    ArrayList<Point> tmp = recursion(x,y,Character.getNumericValue(ww.charAt(i)));
		    if(tmp!=null) {path.addAll(tmp);return path ;} 
		    }
		    return null;
		    }

		}else return null;

		}

		return null;
		}
	
	
}
