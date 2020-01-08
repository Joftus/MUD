package Dungeon.Entities;

import java.util.ArrayList;
import java.util.List;

import Dungeon.Dungeon;
import Dungeon.Utility.Constants;
import Functionality.GameStates.Attack;
import Functionality.GameStates.MonsterMove;

public class Monster extends ActiveEntity {
	
	// Race and Profession
	String type;
	
	public Monster(int x, int y, int numEntities, List<Monster> monsters) {
		super(x, y, numEntities);
		this.symbol = Constants.MONSTER;
		this.name = Constants.MONSTER_NAMES[monsters.size()].toUpperCase();
		initBaseValues();
	}
	
	void initBaseValues() {
		this.health_points = Constants.BASE_MONSTER_HEALTH_POINTS;
		this.attack_damage = Constants.BASE_MONSTER_ATTACK_DAMAGE;
		this.armor = Constants.BASE_MONSTER_ARMOR;
	}
	
	public static void executeMonsterOptions(Dungeon dungeon, Monster current_monster) throws InterruptedException {
		List<ActiveEntity> player = new ArrayList<ActiveEntity>(); 
		player = ActiveEntity.inAttackRange(dungeon, current_monster); 
		if (!player.isEmpty()) Attack.inGameAttack(player , dungeon, current_monster); // monster attacks
		else MonsterMove.inGameMoveMonster(dungeon, current_monster); // monster moves
	}
	
	@Override
	public String toString() {
		String out = "Name: " + this.name + "\n" +
				"Health Points: " + this.health_points + "\n" +
				"Attack Damage: " + this.attack_damage + "\n" +
				"Armor: " + this.armor + "\n";
		return out;
	}
}
