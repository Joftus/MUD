package Functionality.GameStates.Player;

import java.util.List;

import Dungeon.Dungeon;
import Dungeon.Entities.ActiveEntity;
import Dungeon.Entities.Item;
import Dungeon.Utility.GeneralUtility;
import Functionality.Core;
import Functionality.GameStates.Attack;
import Dungeon.Entities.Player;

public class OnResponse {

	public static List<String> responseFromKeyboard(String response, int player_x, int player_y, Dungeon dungeon, List<String> options, List<ActiveEntity> attackable_monsters, List<Item> reachable_items) throws InterruptedException {
		int optionNum;
		String chosen;
		String[] moveOptions = {"a", "d", "w", "s"};
		
		optionNum = 0;
		chosen = "";
		
		if (response.equals(" ") || response.equals("")) {
			Core.executed = true;
			return options;
		}
		if (GeneralUtility.arrayContainsStr(moveOptions, response)) Move.inGameMove(response, dungeon); // if pc inputs move command 
		else {
			try {
				optionNum = Integer.parseInt(response);
				chosen = options.get(optionNum);
			} catch (Exception e) {
				System.out.println("Invalid Option Input");
				Thread.sleep(5000);
				return options;
			}
			if (chosen.equals("Attack")) Attack.inGameAttack(attackable_monsters, dungeon, dungeon.pc);							// if pc inputs attack
			else if (chosen.equals("View Item")) {
				ItemInteraction.itemInterface(reachable_items, dungeon);
				if (Player.itemsInReach(dungeon).isEmpty()) options.remove("View Item");
			}
		}
		return options;
	}
}
