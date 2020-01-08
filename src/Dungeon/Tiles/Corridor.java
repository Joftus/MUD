package Dungeon.Tiles;

import Dungeon.Entities.Entity;
import Dungeon.Utility.Constants;

public class Corridor extends Room {
	
	public Corridor(int x, int y, Entity entity) {
		super(x, y, entity);
		this.symbol = Constants.CORRIDOR;
	}
}
