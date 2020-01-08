package Dungeon.Tiles;

import Dungeon.Entities.Entity;
import Dungeon.Utility.Constants;

public class Stair extends Room {

	public Stair(int x, int y, Entity entity, int stair_number) {
		super(x, y, entity);
		if (stair_number % 2 == 0) this.symbol = Constants.STAIR_DOWN;
		else this.symbol = Constants.STAIR_UP;
	}
}
