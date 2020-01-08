package Dungeon.Entities;

import java.util.List;

import Dungeon.Utility.Constants;

public class Item extends Entity{

	public double health_point_bonus;
	public double attack_damage_bonus;
	public double armor_bonus;
	
	public Item(int x, int y, int numEntities, List<Item> items) {
		super(x, y, numEntities);
		this.name = Constants.ITEM_NAMES[items.size()].toUpperCase();
		this.symbol = name.substring(0, 1);
		initBaseValues();
	}
	
	void initBaseValues() {
		if (this.name.contains("LVL III")) {
			if (this.name.contains("DAGGER")) this.attack_damage_bonus = Constants.DAGGER_BASE_VALUE * 3;
			else if (this.name.contains("SHEILD")) this.armor_bonus = Constants.SHEILD_BASE_VALUE * 3;
			else if (this.name.contains("HEALTH PACK")) this.health_point_bonus = Constants.HEALTH_PACK_BASE_VALUE * 3;
		}
		else if (this.name.contains("LVL II")) {
			if (this.name.contains("DAGGER")) this.attack_damage_bonus = Constants.DAGGER_BASE_VALUE * 2;
			else if (this.name.contains("SHEILD")) this.armor_bonus = Constants.SHEILD_BASE_VALUE * 2;
			else if (this.name.contains("HEALTH PACK")) this.health_point_bonus = Constants.HEALTH_PACK_BASE_VALUE * 2;
		}
		else if (this.name.contains("LVL I")) {
			if (this.name.contains("DAGGER")) this.attack_damage_bonus = Constants.DAGGER_BASE_VALUE;
			else if (this.name.contains("SHEILD")) this.armor_bonus = Constants.SHEILD_BASE_VALUE;
			else if (this.name.contains("HEALTH PACK")) this.health_point_bonus = Constants.HEALTH_PACK_BASE_VALUE;
		}
	}

	@Override
	public String toString() {
		String out = "\n    Name: " + this.name + "\n" +
				"    Health Point Given: " + this.health_point_bonus + "\n" +
				"    Attack Damage Given: " + this.attack_damage_bonus + "\n" +
				"    Armor Given: " + this.armor_bonus + "\n";
		return out;
	}
}
