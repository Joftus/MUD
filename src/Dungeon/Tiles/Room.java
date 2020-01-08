package Dungeon.Tiles;

import Dungeon.Entities.Entity;
import Dungeon.Utility.Constants;

public class Room extends Tile{	
	
	public Room(int x, int y, Entity entity){
		super(x, y, null);
		this.symbol = Constants.ROOM;
		this.hardness = Constants.ROOM_HARDNESS;
	}
}
