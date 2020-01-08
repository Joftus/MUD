package Dungeon.Utility.Place;

import java.util.Random;

import Dungeon.Dungeon;
import Dungeon.Tiles.Stair;
import Dungeon.Utility.Constants;

public class PlaceStair {

	public static boolean placeStair(Dungeon dungeon) {
		boolean placed;
		int rand_x, rand_y;
		Random rand;
		
		rand = new Random();
		placed = false;
		
		while (!placed) {
			rand_x = rand.nextInt(Constants.DUNGEON_X);
			rand_y = rand.nextInt(Constants.DUNGEON_Y);
			if (PlaceUtility.testLocationRadius(rand_x, rand_y, 1, dungeon.map, Constants.ROOM)) {
				dungeon.map[rand_y][rand_x] = new Stair(rand_x, rand_y, null, dungeon.stair_total);
				dungeon.stair_total += 1;
				placed = true;
			}
		}
		return placed;
	}
}
