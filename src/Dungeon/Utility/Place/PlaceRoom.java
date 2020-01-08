package Dungeon.Utility.Place;

import java.awt.Point;
import java.util.Random;

import Dungeon.Dungeon;
import Dungeon.Tiles.Room;
import Dungeon.Utility.Constants;

public class PlaceRoom {

	public static boolean placeRoom(Dungeon dungeon) {
		int room_size = 0, rand_x = 0, rand_y = 0, tries = 0, room_x, room_y;
		Random rand;
		while (tries < Constants.PLACE_ROOM_TRIES) {
			rand = new Random();
			room_size = rand.nextInt(Constants.ROOM_SIZE_RANGE) + Constants.ROOM_SIZE_MIN;
			rand_x = rand.nextInt(Constants.DUNGEON_X - room_size);
			rand_y = rand.nextInt(Constants.DUNGEON_Y - room_size);
			if (PlaceUtility.testLocationFan(rand_x, rand_y, room_size, dungeon.map, Constants.ROOM) == true) break;
			tries ++;
		}
		if (tries == Constants.PLACE_ROOM_TRIES) {
			System.out.println("ROOM PLACE ERROR | PlaceRoom.placeRoom()");
			return false;
		}
		int x, y;
		for (y = rand_y; y < rand_y + room_size; y++) {
			for (x = rand_x; x < rand_x + room_size; x++) {
				dungeon.map[y][x] = new Room(x, y, null);
			}
		}
		room_x = rand_x + (room_size / 2);
		room_y = rand_y + (room_size / 2);
		dungeon.roomLocation.add(new Point(room_x, room_y));
		PlaceUtility.testLocationFan(rand_x, rand_y, room_size, dungeon.map, Constants.ROOM);
		return true;
	}
}
