package Dungeon.Utility.Place;

import java.util.Random;

import Dungeon.Dungeon;
import Dungeon.Entities.Monster;
import Dungeon.Utility.Constants;

public class PlaceMonster {

	public static void placeMonster(Dungeon dungeon) {
		int monster_x, monster_y;
		Random rand = new Random();
		boolean placed = false;
		while (placed == false) {
			monster_x = rand.nextInt(Constants.DUNGEON_X);
			monster_y = rand.nextInt(Constants.DUNGEON_Y);
			if ((dungeon.map[monster_y][monster_x].symbol.equals(Constants.ROOM) || dungeon.map[monster_y][monster_x].symbol.equals(Constants.CORRIDOR)) && dungeon.map[monster_y][monster_x].entity == null) {
				dungeon.monsters.add(new Monster(monster_x, monster_y, dungeon.getEntityCount(), dungeon.monsters));
				dungeon.map[monster_y][monster_x].entity = dungeon.monsters.get(dungeon.monsters.size() - 1);
				placed = true;
			}
		}
	}
}
