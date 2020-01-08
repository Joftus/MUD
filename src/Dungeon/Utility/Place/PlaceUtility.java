package Dungeon.Utility.Place;

import Dungeon.Tiles.Tile;

public class PlaceUtility {

	// Tests area for room placement
	public static boolean testLocationFan(int rand_x, int rand_y, int distance, Tile[][]map, String value) {
		int x, y;
		
		for (y = rand_y; y < rand_y + distance; y++) {
			for (x = rand_x; x < rand_x + distance; x++) {
				if (map[y][x].symbol.equals(value)) return false;
			}
		}
		return true;
	}
	
	// Tests area for stair placement
	public static boolean testLocationRadius(int rand_x, int rand_y, int radius, Tile[][]map, String value) {
		int x, y;
		
		if (rand_y - radius < 0 || rand_x - radius < 0) return false;
		for (y = rand_y - radius; y < rand_y + (radius * 2); y++) {
			for (x = rand_x - radius; x < rand_x + (radius * 2); x++) {
				if (!map[y][x].symbol.equals(value)) return false;
			}
		}
		return true;
	}
}
