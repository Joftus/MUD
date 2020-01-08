package Dungeon.Utility;

import Dungeon.Dungeon;
import Dungeon.Entities.Entity;

public class GeneralMove {

	public static boolean isValidMove(int x, int y, Dungeon dungeon) {
		if (x < 0 || x >= Constants.DUNGEON_X) return false;
		if (y < 0 || y >= Constants.DUNGEON_Y) return false;
		if (dungeon.map[y][x].entity != null) return false;
		if (!dungeon.map[y][x].symbol.equals(Constants.ROOM) && !dungeon.map[y][x].symbol.equals(Constants.CORRIDOR)) return false;
		return true;
	}
	
	public static void moveEntity(Entity entity, Dungeon dungeon, int direction) {
		int x, y;
		x = entity.point.x;
		y = entity.point.y;
		// x + 1
		if (direction == 1) {
			dungeon.map[y][x].entity = null;
			dungeon.map[y][x + 1].entity = entity;
			entity.point.setLocation(x + 1, y);
		}
		// x - 1
		else if (direction == 2) {
			dungeon.map[y][x].entity = null;
			dungeon.map[y][x - 1].entity = entity;
			entity.point.setLocation(x - 1, y);		
		}
		// y + 1
		else if (direction == 3) {
			dungeon.map[y][x].entity = null;
			dungeon.map[y + 1][x].entity = entity;
			entity.point.setLocation(x, y + 1);
		}
		// y - 1
		else {
			dungeon.map[y][x].entity = null;
			dungeon.map[y - 1][x].entity = entity;
			entity.point.setLocation(x, y - 1);
		}
	}
}
