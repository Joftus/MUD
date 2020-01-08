package Dungeon.Utility.Place;

import java.util.Random;

import Dungeon.Dungeon;
import Dungeon.Entities.Player;
import Dungeon.Utility.Constants;

public class PlacePlayer {

	public static void placePlayer(Dungeon dungeon, String player_name) {
		int pc_x, pc_y;
		Random rand = new Random();
		boolean placed = false;
		while (placed == false) {
			pc_x = rand.nextInt(Constants.DUNGEON_X);
			pc_y = rand.nextInt(Constants.DUNGEON_Y);
			if (dungeon.map[pc_y][pc_x].symbol.equals(Constants.ROOM) || dungeon.map[pc_y][pc_x].symbol.equals(Constants.CORRIDOR)) {
				dungeon.pc = new Player(pc_x, pc_y, player_name);
				dungeon.map[pc_y][pc_x].entity = dungeon.pc;
				placed = true;
			}
		}
	}
	
	public static void replacePlayerPrecise(Dungeon dungeon, int x, int y, Player player) {
		player.point.setLocation(x, y);
		dungeon.pc = player;
		dungeon.map[y][x].entity = dungeon.pc;
	}
}
