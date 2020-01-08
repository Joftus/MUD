package Dungeon.Entities;

import java.util.ArrayList;
import java.util.List;

import Dungeon.Dungeon;
import Dungeon.Utility.Constants;

public class Player extends ActiveEntity {
	
	public int floor;
	public int kills;
	
	// Inventory
	public List<Item> items;
	
	// Race and Profession
	String race;
	String profession;
	
	public Player(int x, int y, String name) {
		super(x, y, 0);
		this.name = name.toUpperCase();
		this.symbol = Constants.PLAYER;
		this.floor = 0;
		this.kills = 0;
		initBaseValues();
		initLists();
	}
	
	void initBaseValues() {
		this.health_points = Constants.BASE_PLAYER_HEALTH_POINTS;
		this.attack_damage = Constants.BASE_PLAYER_ATTACK_DAMAGE;
		//this.ability_power = Constants.BASE_PLAYER_ABILITY_POWER;
		this.armor = Constants.BASE_PLAYER_ARMOR;
		//this.magic_resist = Constants.BASE_PLAYER_MAGIC_RESIST;
		this.range = Constants.BASE_PLAYER_RANGE;
		//this.speed = Constants.BASE_PLAYER_SPEED;
	}
	
	void initLists() {
		this.items = new ArrayList<Item>();
	}
	
	public static List<Item> itemsInReach(Dungeon dungeon) {
		List<Item> items = new ArrayList<Item>();
		int player_x, player_y;
		player_x = (int) dungeon.pc.point.getX();
		player_y = (int) dungeon.pc.point.getY();
		// 1. x + 1, y
		if (player_x + 1 < Constants.DUNGEON_X &&
				dungeon.map[player_y][player_x + 1].entity != null && 
				dungeon.items.contains(dungeon.map[player_y][player_x + 1].entity))
			items.add((Item) dungeon.map[player_y][player_x + 1].entity);
		// 2. x - 1, y
		if (player_x - 1 >= 0 &&
				dungeon.map[player_y][player_x -1].entity != null && 
				dungeon.items.contains(dungeon.map[player_y][player_x -1].entity))
			items.add((Item) dungeon.map[player_y][player_x - 1].entity);
		// 3. x, y + 1
		if (player_y + 1 < Constants.DUNGEON_Y &&
				dungeon.map[player_y + 1][player_x].entity != null && 
				dungeon.items.contains(dungeon.map[player_y + 1][player_x].entity))
			items.add((Item) dungeon.map[player_y + 1][player_x].entity);
		// 4. x, y - 1
		if (player_y - 1 >= 0 &&
				dungeon.map[player_y - 1][player_x].entity != null && 
				dungeon.items.contains(dungeon.map[player_y - 1][player_x].entity))
			items.add((Item) dungeon.map[player_y - 1][player_x].entity);
		// 5. x + 1, y + 1
		if (player_x + 1 < Constants.DUNGEON_X && player_y + 1 < Constants.DUNGEON_Y &&
				dungeon.map[player_y + 1][player_x + 1].entity != null && 
				dungeon.items.contains(dungeon.map[player_y + 1][player_x + 1].entity))
			items.add((Item) dungeon.map[player_y + 1][player_x + 1].entity);
		// 6. x - 1, y - 1
		if (player_x - 1 >= 0 && player_y - 1 >= 0 &&
				dungeon.map[player_y - 1][player_x - 1].entity != null && 
				dungeon.items.contains(dungeon.map[player_y - 1][player_x - 1].entity))
			items.add((Item) dungeon.map[player_y - 1][player_x - 1].entity);
		// 7. x + 1, y - 1
		if (player_x + 1 < Constants.DUNGEON_X && player_y - 1 >= 0 &&
				dungeon.map[player_y - 1][player_x + 1].entity != null && 
				dungeon.items.contains(dungeon.map[player_y - 1][player_x + 1].entity))
			items.add((Item) dungeon.map[player_y - 1][player_x + 1].entity);
		// 8. x - 1, y + 1
		if (player_x - 1 >= 0 && player_y + 1 < Constants.DUNGEON_Y &&
				dungeon.map[player_y + 1][player_x - 1].entity != null && 
				dungeon.items.contains(dungeon.map[player_y + 1][player_x - 1].entity))
			items.add((Item) dungeon.map[player_y + 1][player_x - 1].entity);
		return items;
	}
		
	// pick-up item method
	
	@Override
	public String toString() {
		int a;	
		 
		String out = "\nName: " + this.name + "\n" +
				"Health Points: " + this.health_points + "\n" +
				"Attack Damage: " + this.attack_damage + "\n" +
				"Armor: " + this.armor + "\n" +
				"Range: " + this.range + "\n";
		if (!this.items.isEmpty()) out += "Inventory:";
		for (a = 0; a < items.size(); a++) out += "\n" + "    " + a + ". " + this.items.get(a).name;
		return out;
	}
}
