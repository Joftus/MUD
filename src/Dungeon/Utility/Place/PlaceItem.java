package Dungeon.Utility.Place;

import java.util.Random;

import Dungeon.Dungeon;
import Dungeon.Entities.Item;
import Dungeon.Utility.Constants;

public class PlaceItem {

	// place item, make sure to do map.entity == null check
	
	public static void placeItem(Dungeon dungeon) {
		int item_x, item_y;
		Random rand;
		boolean placed;
		Item item;
		
		placed = false;
		rand = new Random();
		
		while (placed == false) {
			item_x = rand.nextInt(Constants.DUNGEON_X);
			item_y = rand.nextInt(Constants.DUNGEON_Y);
			if (dungeon.map[item_y][item_x].symbol.equals(Constants.ROOM) && dungeon.map[item_y][item_x].entity == null) {
				item = new Item(item_x, item_y, dungeon.getEntityCount(), dungeon.items);
				dungeon.items.add(item);
				dungeon.map[item_y][item_x].entity = item;
				placed = true;
			}
		}
	}
}
