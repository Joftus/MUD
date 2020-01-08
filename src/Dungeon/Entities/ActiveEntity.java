package Dungeon.Entities;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import Dungeon.Dungeon;
import Dungeon.Utility.Constants;

public class ActiveEntity extends Entity {

	public double health_points;
	public double attack_damage;
	public double armor;
	public double range;
	// vision range
	//public double ability_power;
	//public double magic_resist;
	//public double speed;
	
	public ActiveEntity(int x, int y, int numEntities) {
		super(x, y, numEntities);
	}
	
	public static List<ActiveEntity> inAttackRange(Dungeon dungeon, Entity entity) {
		int x = 0, y = 0, a;
		//int range, x, y, sub_range_x, sub_range_y, add_range_x, add_range_y;
		List<ActiveEntity> entitiesInRange = new ArrayList<ActiveEntity>();
		Entity current = null;
		boolean isPc;
		Point player_position;
		if (entity.name.equals(dungeon.pc.name)) isPc = true;
		else isPc = false;
		// PC section
		if (isPc) {
			x = (int) dungeon.pc.point.getX();
			y = (int) dungeon.pc.point.getY();
			// 1. x + 1, y
			if (x + 1 < Constants.DUNGEON_X &&
					dungeon.map[y][x + 1].entity != null && 
					dungeon.monsters.contains(dungeon.map[y][x + 1].entity))
				entitiesInRange.add((Monster) dungeon.map[y][x + 1].entity);
			// 2. x - 1, y
			if (x - 1 >= 0 &&
					dungeon.map[y][x -1].entity != null && 
					dungeon.monsters.contains(dungeon.map[y][x -1].entity))
				entitiesInRange.add((Monster) dungeon.map[y][x - 1].entity);
			// 3. x, y + 1
			if (y + 1 < Constants.DUNGEON_Y &&
					dungeon.map[y + 1][x].entity != null && 
					dungeon.monsters.contains(dungeon.map[y + 1][x].entity))
				entitiesInRange.add((Monster) dungeon.map[y + 1][x].entity);
			// 4. x, y - 1
			if (y - 1 >= 0 &&
					dungeon.map[y - 1][x].entity != null && 
					dungeon.monsters.contains(dungeon.map[y - 1][x].entity))
				entitiesInRange.add((Monster) dungeon.map[y - 1][x].entity);
			// 5. x + 1, y + 1
			if (x + 1 < Constants.DUNGEON_X && y + 1 < Constants.DUNGEON_Y &&
					dungeon.map[y + 1][x + 1].entity != null && 
					dungeon.monsters.contains(dungeon.map[y + 1][x + 1].entity))
				entitiesInRange.add((Monster) dungeon.map[y + 1][x + 1].entity);
			// 6. x - 1, y - 1
			if (x - 1 >= 0 && y - 1 >= 0 &&
					dungeon.map[y - 1][x - 1].entity != null && 
					dungeon.monsters.contains(dungeon.map[y - 1][x - 1].entity))
				entitiesInRange.add((Monster) dungeon.map[y - 1][x - 1].entity);
			// 7. x + 1, y - 1
			if (x + 1 < Constants.DUNGEON_X && y - 1 >= 0 &&
					dungeon.map[y - 1][x + 1].entity != null && 
					dungeon.monsters.contains(dungeon.map[y - 1][x + 1].entity))
				entitiesInRange.add((Monster) dungeon.map[y - 1][x + 1].entity);
			// 8. x - 1, y + 1
			if (x - 1 >= 0 && y + 1 < Constants.DUNGEON_Y &&
					dungeon.map[y + 1][x - 1].entity != null && 
					dungeon.monsters.contains(dungeon.map[y + 1][x - 1].entity))
				entitiesInRange.add((Monster) dungeon.map[y + 1][x - 1].entity);			
		}
		// Monster section
		else {
			player_position = dungeon.pc.point;
			for (a = 0; a < dungeon.monsters.size(); a++) {
				current = dungeon.monsters.get(a);
				if (current.name.equals(entity.name)) {
					x = (int) current.point.getX();
					y = (int) current.point.getY();
				}
			}
			// 1. x + 1, y
			if (x + 1 < Constants.DUNGEON_X &&
					x + 1 == player_position.getX() &&
					y == player_position.getY())
				entitiesInRange.add((Player) dungeon.map[y][x + 1].entity);
			// 2. x - 1, y
			if (x - 1 >= 0 &&
					x - 1 == player_position.getX() &&
					y == player_position.getY())
				entitiesInRange.add((Player) dungeon.map[y][x - 1].entity);
			// 3. x, y + 1
			if (y + 1 < Constants.DUNGEON_Y &&
					x == player_position.getX() &&
					y + 1 == player_position.getY())
				entitiesInRange.add((Player) dungeon.map[y + 1][x].entity);
			// 4. x, y - 1
			if (y - 1 >= 0 &&
					x == player_position.getX() &&
					y - 1 == player_position.getY())
				entitiesInRange.add((Player) dungeon.map[y - 1][x].entity);
			// 5. x + 1, y + 1
			if (x + 1 < Constants.DUNGEON_X && y + 1 < Constants.DUNGEON_Y &&
					x + 1 == player_position.getX() &&
					y + 1 == player_position.getY())
				entitiesInRange.add((Player) dungeon.map[y + 1][x + 1].entity);
			// 6. x - 1, y - 1
			if (x - 1 >= 0 && y - 1 >= 0 &&
					x - 1 == player_position.getX() &&
					y - 1 == player_position.getY())
				entitiesInRange.add((Player) dungeon.map[y - 1][x - 1].entity);
			// 7. x + 1, y - 1
			if (x + 1 < Constants.DUNGEON_X && y - 1 >= 0 &&
					x + 1 == player_position.getX() &&
					y - 1 == player_position.getY())
				entitiesInRange.add((Player) dungeon.map[y - 1][x + 1].entity);
			// 8. x - 1, y + 1
			if (x - 1 >= 0 && y + 1 < Constants.DUNGEON_Y &&
					x - 1 == player_position.getX() &&
					y + 1 == player_position.getY())
				entitiesInRange.add((Player) dungeon.map[y + 1][x - 1].entity);
		}
		return entitiesInRange;
		
		//range = (int) dungeon.pc.range;
		// need to add range loop checker, now only checks 1 away
	}
}
