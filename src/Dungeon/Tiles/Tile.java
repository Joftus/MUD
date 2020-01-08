package Dungeon.Tiles;

import java.awt.Point;

import Dungeon.Entities.Entity;
import Dungeon.Utility.Constants;

public class Tile {

	Point point;
	public String symbol;
	public Entity entity;
	public int hardness;
	
	public Tile(int x, int y, Entity entity) {
		this.point = new Point(x, y);
		this.symbol = Constants.WALL;
		this.hardness = Constants.WALL_HARDNESS;
		this.entity = entity;
	}
}
