package Visual;

import Dungeon.Dungeon;
import Dungeon.Utility.Constants;
import Functionality.Core;

public class Visual {
	
	public static void printMap(Dungeon dungeon) {
		System.out.println("Turn: " + Core.turn_number + " | " + "Floor: " + dungeon.pc.floor + " | " + "Kills: " + dungeon.pc.kills + "/" + Constants.NUMBER_OF_MONSTERS);
		printBorder();
		for (int y = 0; y < Constants.DUNGEON_Y; y++) {
			System.out.print("|");
			for (int x = 0; x < Constants.DUNGEON_X; x++) {
				if (dungeon.map[y][x].entity != null) System.out.print(dungeon.map[y][x].entity.symbol);  
				else System.out.print(dungeon.map[y][x].symbol);
			}
			System.out.println("|");
		}
		printBorder();
	}
	
	public static void printBorder() {
		for (int i = 0; i < Constants.DUNGEON_X; i++) {
			System.out.print("-");
		}
		System.out.println("");
	}
	
	public static void refreshPageMain(Dungeon dungeon) {
		System.out.println(Constants.NEW_PAGE);
		Visual.printMap(dungeon);
		System.out.println(dungeon.pc.toString());
	}
	
	public static void logo(boolean welcome) {
		System.out.println("Version: 1.01");
		System.out.println("Date: 5-21-2019");
		System.out.println("___   ___ ___   ___ ___________");
		System.out.println("|  \\_/  | | |   | | | _____   |");
		System.out.println("|       | | |   | | | |   |   |");
		System.out.println("|       | | |   | | | |   |   |");
		System.out.println("| /\\_/\\ | | |___| | | |___|   |");
		System.out.println("|_|   |_| |_______| |_________|");
		if (welcome) for (int i = 0; i < Constants.WELCOME_PAGE_SPACES; i++) System.out.println("");
		else for (int i = 0; i < Constants.END_PAGE_SPACES; i++) System.out.println("");
	}
}