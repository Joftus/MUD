package Dungeon.Utility;

import java.awt.Point;
import java.util.Random;

import Dungeon.Tiles.Corridor;
import Dungeon.Tiles.Tile;

public class ConnectRooms {

	public static Tile[][] connectRooms(Point fromRoom, Point toRoom, Tile[][] map) {
		int distanceThisDirection, tries = 0;
		int[] distances = GeneralUtility.compass(fromRoom, toRoom);
		Random rand = new Random();
		boolean direction = false;
		// direction: true = x, false = y.
		while (tries < Constants.PLACE_CORRIDOR_TRIES) {
			if (distances[0] == 0) direction = false;
			if (distances[1] == 0) direction = true;
			if (distances[0] == 0 && distances[1] == 0) break;
			distanceThisDirection = rand.nextInt(Constants.ROUNDNESS_CORRIDORS_RANGE) + Constants.ROUNDNESS_CORRIDORS_MIN;
			while (distanceThisDirection > 0) {
				if (direction) {
					if (distances[0] > 0) {
						fromRoom.setLocation(fromRoom.getX() + 1, fromRoom.getY());
						distances[0]--;
					}
					else if (distances[1] < 0) {
						fromRoom.setLocation(fromRoom.getX() - 1, fromRoom.getY());
						distances[0]++;
					}
				}
				else {
					if (distances[1] > 0) {
						fromRoom.setLocation(fromRoom.getX(), fromRoom.getY() + 1);
						distances[1]--;
					}
					else if (distances[1] < 0){
						fromRoom.setLocation(fromRoom.getX(), fromRoom.getY() - 1);
						distances[1]++;
					}
				}
				if (map[(int) fromRoom.getY()][(int) fromRoom.getX()].symbol.equals(Constants.WALL)) map[(int) fromRoom.getY()][(int) fromRoom.getX()] = new Corridor((int) fromRoom.getX(), (int) fromRoom.getY(), null);
				distanceThisDirection--;
			}
			if (direction) direction = false;
			else direction = true;
			tries++;
		}
		if (distances[0] != 0 || distances[1] != 0) map = crudeConnect(fromRoom, toRoom, distances, map);
		return map;
	}
	
	static Tile[][] crudeConnect(Point fromRoom, Point toRoom, int[] distances, Tile[][] map){
		while (distances[0] != 0) {
			if (distances[0] > 0) {
				fromRoom.setLocation(fromRoom.getX() + 1, fromRoom.getY());
				distances[0]--;
			}
			else {
				fromRoom.setLocation(fromRoom.getX() - 1, fromRoom.getY());
				distances[0]++;
			}
			if (map[(int) fromRoom.getY()][(int) fromRoom.getX()].symbol.equals(Constants.WALL)) map[(int) fromRoom.getY()][(int) fromRoom.getX()] = new Corridor((int) fromRoom.getX(), (int) fromRoom.getY(), null);
		}
		while (distances[1] != 0) {
			if (distances[1] > 0) {
				fromRoom.setLocation(fromRoom.getX(), fromRoom.getY() + 1);
				distances[1]--;
			}
			else {
				fromRoom.setLocation(fromRoom.getX(), fromRoom.getY() - 1);
				distances[1]++;
			}
			if (map[(int) fromRoom.getY()][(int) fromRoom.getX()].symbol.equals(Constants.WALL)) map[(int) fromRoom.getY()][(int) fromRoom.getX()] = new Corridor((int) fromRoom.getX(), (int) fromRoom.getY(), null);
		}
		return map;
	}
}
