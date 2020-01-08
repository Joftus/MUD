package Dungeon;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import Dungeon.Entities.Item;
import Dungeon.Entities.Monster;
import Dungeon.Entities.Player;
import Dungeon.Tiles.Tile;
import Dungeon.Utility.ConnectRooms;
import Dungeon.Utility.Constants;
import Dungeon.Utility.Place.PlaceItem;
import Dungeon.Utility.Place.PlaceMonster;
import Dungeon.Utility.Place.PlacePlayer;
import Dungeon.Utility.Place.PlaceRoom;
import Dungeon.Utility.Place.PlaceStair;
import Functionality.Core;

public class Dungeon {

	public Tile[][] map;
	public Player pc;
	public int stair_total;
	public List<Monster> monsters;
	public List<Item> items;
	public List<Point> roomLocation;

	public Dungeon(String player_name) {
		this.map = new Tile[Constants.DUNGEON_Y][Constants.DUNGEON_X];
		this.monsters = new ArrayList<Monster>();
		this.items = new ArrayList<Item>();
		this.roomLocation = new ArrayList<Point>();
		initDungeon(Constants.NUMBER_OF_ROOMS, Constants.NUMBER_OF_STAIRS, Constants.NUMBER_OF_MONSTERS, Constants.NUMBER_OF_ITEMS, null, player_name);
	}
	
	public Dungeon(Player player) {
		this.map = new Tile[Constants.DUNGEON_Y][Constants.DUNGEON_X];
		this.monsters = new ArrayList<Monster>();
		this.items = new ArrayList<Item>();
		this.roomLocation = new ArrayList<Point>();
		initDungeon(Constants.NUMBER_OF_ROOMS, Constants.NUMBER_OF_STAIRS, Constants.NUMBER_OF_MONSTERS, Constants.NUMBER_OF_ITEMS, player, player.name);
	}
	
	void initDungeon(int numRooms, int numStairs, int numMons, int numItems, Player player, String player_name) {
		int room_count, monster_count, stair_count, item_count;
		int a, x, y;
		
		room_count = 0;
		stair_count = 0;
		monster_count = 0;
		item_count = 0;
		
		for (y = 0; y < Constants.DUNGEON_Y; y++) {
			for (x = 0; x < Constants.DUNGEON_X; x++) {
				map[y][x] = new Tile(x, y, null);
			}
		}
		while (room_count < numRooms) {																								// place rooms
			if (PlaceRoom.placeRoom(this)) room_count++;
		}
		while (stair_count < numStairs) {																								// place stairs
			if (PlaceStair.placeStair(this)) stair_count++;
		}
		for (a = 0; a < roomLocation.size(); a++) {																					// connect rooms
			if (a + 1 == roomLocation.size()) map = ConnectRooms.connectRooms(roomLocation.get(a), roomLocation.get(0), this.map);
			else map = ConnectRooms.connectRooms(roomLocation.get(a), roomLocation.get(a + 1), this.map);
		}
		if (Core.stair_up) {
			for (y = 0; y < Constants.DUNGEON_Y; y++) {
				for (x = 0; x < Constants.DUNGEON_X; x++) {
					if (map[y][x].symbol.equals(Constants.STAIR_DOWN)) {
						PlacePlayer.replacePlayerPrecise(this, x, y, player);
						x = Constants.DUNGEON_X;
						y = Constants.DUNGEON_Y;
					}
				}
			}
		}
		else if (Core.stair_down) {
			for (y = 0; y < Constants.DUNGEON_Y; y++) {
				for (x = 0; x < Constants.DUNGEON_X; x++) {
					if (map[y][x].symbol.equals(Constants.STAIR_UP)) {
						PlacePlayer.replacePlayerPrecise(this, x, y, player);
						x = Constants.DUNGEON_X;
						y = Constants.DUNGEON_Y;
					}
				}
			}
		}
		else PlacePlayer.placePlayer(this, player_name);																					// place player
		while (monster_count < numMons) {																								// place monsters
			PlaceMonster.placeMonster(this);
			monster_count++;
		}
		while (item_count < numItems) {
			PlaceItem.placeItem(this);
			item_count++;
		}
	}
	
	public int getEntityCount() {
		int entityCount;
		
		// Don't count player.
		entityCount = monsters.size();
		entityCount += items.size();
		return entityCount;
	}
}