package Functionality.GameStates.Player;

import Dungeon.Dungeon;
import Dungeon.Utility.Constants;
import Dungeon.Utility.GeneralMove;
import Functionality.Core;

public class Move {

	public static void inGameMove(String response, Dungeon dungeon) throws InterruptedException {
		int player_x, player_y;
		
		player_x = (int) dungeon.pc.point.getX();
		player_y = (int) dungeon.pc.point.getY();
		
		if (response.equals("d")) { 																														// right
			if (GeneralMove.isValidMove(player_x + 1, player_y, dungeon)) {
				GeneralMove.moveEntity(dungeon.pc, dungeon, 1);
				Core.executed = true;
			}
			else if (dungeon.map[player_y][player_x + 1].symbol.equals(Constants.STAIR_UP)) {
				Core.executed = true;
				Core.stair_up = true;
			}
			else if (dungeon.map[player_y][player_x + 1].symbol.equals(Constants.STAIR_DOWN)) {
				Core.executed = true;
				Core.stair_down = true;
			}
			else {
				System.out.println("INVALID MOVE ERROR | PlayerMove.inGameMove()");
				Thread.sleep(5000);
			}
		} 
		else if (response.equals("a")) { 																												// left
			if (GeneralMove.isValidMove(player_x - 1, player_y, dungeon)) {
				GeneralMove.moveEntity(dungeon.pc, dungeon, 2);
				Core.executed = true;
			}
			else if (dungeon.map[player_y][player_x - 1].symbol.equals(Constants.STAIR_UP)) {
				Core.executed = true;
				Core.stair_up = true;
			}
			else if (dungeon.map[player_y][player_x - 1].symbol.equals(Constants.STAIR_DOWN)) {
				Core.executed = true;
				Core.stair_down = true;
			}
			else {
				System.out.println("INVALID MOVE ERROR | PlayerMove.inGameMove()");
				Thread.sleep(5000);
				}
		} 
		else if (response.equals("s")) { 																												// down
			if (GeneralMove.isValidMove(player_x, player_y + 1, dungeon)) {
				GeneralMove.moveEntity(dungeon.pc, dungeon, 3);
				Core.executed = true;
			}
			else if (dungeon.map[player_y + 1][player_x].symbol.equals(Constants.STAIR_UP)) {
				Core.executed = true;
				Core.stair_up = true;
			}
			else if (dungeon.map[player_y + 1][player_x].symbol.equals(Constants.STAIR_DOWN)) {
				Core.executed = true;
				Core.stair_down = true;
			}
			else {
				System.out.println("INVALID MOVE ERROR | PlayerMove.inGameMove()");
				Thread.sleep(5000);
			}
		} else if (response.equals("w")) { 																												// up
			if (GeneralMove.isValidMove(player_x, player_y - 1, dungeon)) {
				GeneralMove.moveEntity(dungeon.pc, dungeon, 4);
				Core.executed = true;
			}
			else if (dungeon.map[player_y - 1][player_x].symbol.equals(Constants.STAIR_UP)) {
				Core.executed = true;
				Core.stair_up = true;
			}
			else if (dungeon.map[player_y - 1][player_x].symbol.equals(Constants.STAIR_DOWN)) {
				Core.executed = true;
				Core.stair_down = true;
			}
			else {
				System.out.println("INVALID MOVE ERROR | PlayerMove.inGameMove()");
				Thread.sleep(5000);
			}
		}
	}
}
