package Functionality.GameStates;

import java.util.List;
import java.util.Scanner;

import Dungeon.Dungeon;
import Dungeon.Entities.ActiveEntity;
import Dungeon.Utility.Constants;
import Functionality.Core;
import Visual.Visual;

public class Attack {

	@SuppressWarnings("resource")
	public static void inGameAttack(List<ActiveEntity> in_attack_range, Dungeon dungeon, ActiveEntity current) throws InterruptedException {
		boolean attack_complete = false, isPc = false;
		String attack_response, confirm;
		Scanner scan = new Scanner(System.in);
		ActiveEntity attacking = null;
		int a, b, c, health_lost;
		if (current.name.equals(dungeon.pc.name)) isPc = true;
		while (!attack_complete) {
			System.out.println(Constants.SLIGHT_PUSHUP);
			if (isPc) {																			// formatting for visuals
				for (c = 0; c < (Constants.DUNGEON_X / 2) - 12; c++) System.out.print("-");
				System.out.print("| Monsters In Range |");
				for (c = 0; c < (Constants.DUNGEON_X / 2) - 12; c++) System.out.print("-");
				System.out.println("");
				for (a = 0; a < in_attack_range.size(); a++)
					System.out.println("- " + in_attack_range.get(a).name);
				System.out.print("\nAttack: ");
				attack_response = scan.nextLine().toUpperCase();
			}
			else attack_response = dungeon.pc.name;
			for (b = 0; b < in_attack_range.size(); b++) {
				if (in_attack_range.get(b).name.equals(attack_response))
					attacking = in_attack_range.get(b);
			}
			if (attacking != null) {
				Visual.refreshPageMain(dungeon);
				if (isPc) {
					System.out.println(attacking.toString());
					System.out.print("Continue with attack (y/n): ");
					confirm = scan.nextLine();
				}
				else confirm = "y";
				// ask to be sure after seeing enemy info
				if (confirm.equals("y")) {
					if (attacking.attack_damage > current.attack_damage) {
						System.out.println(current.name + "'s attack failed!");
						health_lost = (int) (attacking.attack_damage / current.armor);
						System.out.println(current.name + " lost " + health_lost + " health points!");
						Thread.sleep(Constants.ATTACK_MESSAGE_SLEEP);
						current.health_points = current.health_points - health_lost;
					}
					else if (attacking.attack_damage == current.attack_damage) {
						System.out.println("Attack damage equal, no result!");
						Thread.sleep(Constants.ATTACK_MESSAGE_SLEEP);
					}
					else if (attacking.attack_damage < current.attack_damage) {
						System.out.println(current.name + " attacked successfully!");
						health_lost = (int) (current.attack_damage / attacking.armor);
						System.out.println(current.name + " did " + health_lost + " damage to " + attacking.name);
						Thread.sleep(Constants.ATTACK_MESSAGE_SLEEP);
						attacking.health_points = attacking.health_points - health_lost;
					}
					attack_complete = true;
					Core.executed = true;
				}
				else {
					return;
				}
				if (attacking.health_points <= 0 && isPc) {
					System.out.println("You killed " + attacking.name);
					Thread.sleep(Constants.ATTACK_MESSAGE_SLEEP);
					dungeon.pc.kills++;
					dungeon.map[attacking.point.y][attacking.point.x].entity = null;
					dungeon.monsters.remove(attacking);
					if (dungeon.monsters.isEmpty()) Core.playing = false;
				}
				if (dungeon.pc.health_points <= 0) Core.playing = false;
				if (current.health_points <= 0 && !isPc) {
					dungeon.pc.kills++;
					dungeon.monsters.remove(current);
					dungeon.map[current.point.y][current.point.x].entity = null;
					if (dungeon.monsters.size() == 0) Core.playing = false;
				}
				return;
			}
		}
	}
}
