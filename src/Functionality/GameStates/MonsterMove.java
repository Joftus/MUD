package Functionality.GameStates;

import java.awt.Point;
import java.util.Random;

import Dungeon.Dungeon;
import Dungeon.Entities.Monster;
import Dungeon.Utility.GeneralMove;

public class MonsterMove {

	public static void inGameMoveMonster(Dungeon dungeon, Monster current_monster) {
		Point monster_position;
		int direction = 0;
		monster_position = current_monster.point;
		direction = testMonsterMove(dungeon, monster_position);
		if (direction == 0) direction = testMonsterMoveRandom(dungeon, monster_position);
		// add random move later with rand num for vision range
		GeneralMove.moveEntity(current_monster, dungeon, direction);
	}
	
	static int testMonsterMove(Dungeon dungeon, Point monster_position) {
		int direction = 0, m_x, m_y;
		Point pc_position;
		pc_position = dungeon.pc.point;
		m_x = monster_position.x;
		m_y = monster_position.y;
		// x + 1
		if (GeneralMove.isValidMove(m_x + 1, m_y, dungeon) && pc_position.getX() > monster_position.getX()) direction = 1;
		// x - 1
		else if (GeneralMove.isValidMove(m_x - 1, m_y, dungeon) && pc_position.getX() < monster_position.getX()) direction = 2;
		// y + 1
		else if (GeneralMove.isValidMove(m_x, m_y + 1, dungeon) && pc_position.getY() < monster_position.getY()) direction = 3;
		// y - 1
		else if (GeneralMove.isValidMove(m_x, m_y - 1, dungeon) && pc_position.getY() < monster_position.getY()) direction = 4;
		return direction;
	}
	
	static int testMonsterMoveRandom(Dungeon dungeon, Point monster_position) {
		int direction = 0, m_x, m_y, random_direction;
		Random rand = new Random();
		boolean move_found = false;
		m_x = monster_position.x;
		m_y = monster_position.y;
		while (!move_found) {
			random_direction = rand.nextInt(4) + 1;
			// x + 1
			if (GeneralMove.isValidMove(m_x + 1, m_y, dungeon) && random_direction == 1) {
				move_found = true;
				direction = 1;
			}
			// x - 1
			else if (GeneralMove.isValidMove(m_x - 1, m_y, dungeon) && random_direction == 2) {
				move_found = true;
				direction = 2;
			}
			// y + 1
			else if (GeneralMove.isValidMove(m_x, m_y + 1, dungeon) && random_direction == 3) {
				move_found = true;
				direction = 3;
			}
			// y - 1
			else if (GeneralMove.isValidMove(m_x, m_y - 1, dungeon) && random_direction == 4) {
				move_found = true;
				direction = 4;
			}
		}
		return direction;
	}
}
