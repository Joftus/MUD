package Functionality;

import java.util.List;
import java.util.Scanner;

import Dungeon.Dungeon;
import Dungeon.Entities.ActiveEntity;
import Dungeon.Entities.Item;
import Dungeon.Entities.Monster;
import Dungeon.Entities.Player;
import Dungeon.Utility.Constants;
import Dungeon.Utility.GeneralUtility;
import Functionality.GameStates.BasicGameStates;
import Functionality.GameStates.Player.OnResponse;
import Visual.Visual;

public class Core {

	/*
	 * Game Loop
	 */
	
	public static boolean playing;
	public static boolean executed;
	public static boolean stair_up;
	public static boolean stair_down;
	public static int turn_number;
	
	public static Dungeon dungeon;

	public static void main(String[] args) throws InterruptedException {
		int a, player_x, player_y;
		boolean dora, another;
		String response;
		Scanner scan;
		//Dungeon dungeon;
		Monster current_monster;
		Player player;
		List<String> options;
		List<Item> reachable_items;
		List<ActiveEntity> attackable_monsters;
		
		another = true;
		
		while (another) {
			scan = new Scanner(System.in);
			dungeon = new Dungeon(BasicGameStates.gameStart());
			current_monster = null;
			dora = false;
			playing = true;
			turn_number = 0;
			
			while (playing) {
				executed = false;
				attackable_monsters = ActiveEntity.inAttackRange(dungeon, dungeon.pc);
				reachable_items = Player.itemsInReach(dungeon);
				options = GeneralUtility.findOptions(reachable_items, attackable_monsters);
				player_x = (int) dungeon.pc.point.x;
				player_y = (int) dungeon.pc.point.y;
				
				while (!executed) {
					Visual.refreshPageMain(dungeon);
					for (a = 0; a < options.size(); a++)
						System.out.println(a + ". " + options.get(a));
					System.out.print("Action: ");
					response = scan.nextLine();
					options = OnResponse.responseFromKeyboard(response, player_x, player_y, dungeon, options, attackable_monsters, reachable_items); 													// pc action
				}
				if (stair_up || stair_down) {
					player = dungeon.pc;
					player.kills = 0;
					dungeon = new Dungeon(player);
					if (stair_up) dungeon.pc.floor++;
					else dungeon.pc.floor--;
					stair_up = false;
					stair_down = false;
				}
				for (a = 0; a < dungeon.monsters.size(); a++) {
					current_monster = dungeon.monsters.get(a);
					Monster.executeMonsterOptions(dungeon, current_monster);
				}
				if (dungeon.pc.floor == Constants.TOP_FLOOR || dungeon.pc.floor == Constants.BOTTOM_FLOOR) {
					dora = true;
					playing = false;
				}
				turn_number++;
			}
			if (dungeon.monsters.isEmpty() && Constants.NUMBER_OF_MONSTERS > 0) another = BasicGameStates.gameOverWinByClearingFloor();
			else if (dora) another = BasicGameStates.gameOverWinByReachingEnd();
			else another = BasicGameStates.gameOverLoss();
		}
	}
}