package Dungeon.Entities;

import java.awt.Point;

import Dungeon.Utility.Constants;

public class Entity{

	public String name;
	public int entityNum;
	public Point point;
	public String symbol;
	
	public Entity(int x, int y, int numEntities) {
		this.point = new Point(x, y);
		this.symbol = Constants.UNKOWNEN;
		this.entityNum = numEntities + 1;
	}
}
