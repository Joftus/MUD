package Dungeon.Utility;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import Dungeon.Entities.ActiveEntity;
import Dungeon.Entities.Item;

public class GeneralUtility {

	public static boolean arrayContainsStr(String[] array, String input) {
		for (int a = 0; a < array.length; a++) {
			if(array[a].equals(input)) return true;
		}
		return false;
	}

	public static List<String> findOptions(List<Item> reachable_items, List<ActiveEntity> attackable_monsters) {
		List<String> options = new ArrayList<String>();
		if (!reachable_items.isEmpty())
			options.add("View Item");
		if (!attackable_monsters.isEmpty())
			options.add("Attack");
		return options;
	}
	
	public static int[] compass(Point toRoom, Point fromRoom) {
		int[] distances = new int[2];
		distances[0] = (int) (fromRoom.getX() - toRoom.getX());
		distances[1] = (int) (fromRoom.getY() - toRoom.getY());
		return distances;
	}
	
	// convert "y" or "n" to boolean
	public static boolean yesOrNo(String str) {
		if (str.equals("y")) return true;
		return false;
	}
}
