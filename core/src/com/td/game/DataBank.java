package com.td.game;

import com.td.Entity.Weapon;
import com.td.Entity.default_weapon;
import com.td.util.Const;

public class DataBank {
	
	public static Weapon getWepById(int id) {
		
		switch (id) {
		case 0: return new default_weapon(0,0);
		}
		return null;
	}
}
