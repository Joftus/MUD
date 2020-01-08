package Functionality.GameStates.Player;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

import Dungeon.Dungeon;
import Dungeon.Entities.Item;
import Dungeon.Entities.Player;
import Dungeon.Utility.Constants;
import Visual.Visual;

public class ItemInteraction {

	@SuppressWarnings("resource")
	public static void itemInterface(List<Item> reachable_items, Dungeon dungeon) throws InterruptedException {
		Scanner scan;
		String response;
		int a, c;
		int itemNum;
		
		scan = new Scanner(System.in);
		
		Visual.refreshPageMain(dungeon);
		for (c = 0; c < (Constants.DUNGEON_X / 2) - 12; c++) System.out.print("-");
		System.out.print("| Items In Range |");
		for (c = 0; c < (Constants.DUNGEON_X / 2) - 12; c++) System.out.print("-");
		System.out.println("");
		for (a = 0; a < reachable_items.size(); a++) System.out.println(a + "." + reachable_items.get(a).toString() + "\n");
		System.out.print("Grab item number: ");
		response = scan.nextLine();
		try {
			itemNum = Integer.parseInt(response);
			System.out.println(reachable_items.get(itemNum));
			pickUpItem(reachable_items.get(itemNum), dungeon);
		}
		catch (Exception e) {
			System.out.println("The input didn't match any item.");
			Thread.sleep(3000);
		}
	}
	
	@SuppressWarnings("resource")
	public static void pickUpItem(Item item, Dungeon dungeon) {
		Player pc; 
		Scanner scan;
		int a;
		
		pc = dungeon.pc;
		scan = new Scanner(System.in);
		
		if (pc.items.size() < Constants.INVENTORY_SIZE) {
			dungeon.items.remove(item);
			dungeon.map[item.point.y][item.point.x].entity = null;
			pc.items.add(item);
			calculateNewStats(item, dungeon.pc, true);
		}
		else {
			System.out.println("Full Inventory!");
			System.out.print("Drop an Item (y/n): ");
			if (scan.nextLine().equals("y")) {
				try {
					for (a = 0; a < pc.items.size(); a++) System.out.println(a + ". " + pc.items.get(a));				
					System.out.print("Drop item number: ");
					
					dropItem(pc.items.get(scan.nextInt()), dungeon);
					pickUpItem(item, dungeon);
				}
				catch (Exception e) {
					System.out.println("Error in ItemInteractions | pickUpItem");
				}
			}
		}
	}
	
	public static void dropItem(Item item, Dungeon dungeon) {
		Player pc;
		int count, randNum, pc_x, pc_y;
		boolean dropped;
		Random rand;
		
		pc = dungeon.pc;
		pc_x = pc.point.x;
		pc_y = pc.point.y;
		dropped = false;
		count = 0;
		rand = new Random();
		
		if (pc.health_points - item.health_point_bonus <= 0) {
			System.out.println("Dropping this item would kill you idiot!");
			return;
		}
		pc.items.remove(item);
		calculateNewStats(item, pc, false);
		while (count < Constants.DROP_ITEM_TRIES && !dropped) {
			randNum = rand.nextInt(4);
			if (randNum == 0 && dungeon.map[pc_y - 1][pc_x].symbol.equals(Constants.ROOM) && dungeon.map[pc_y - 1][pc_x].entity == null) {
				dungeon.map[pc_y - 1][pc_x].entity = item;
				dropped = true;
			}
			else if (randNum == 1 && dungeon.map[pc_y + 1][pc_x].symbol.equals(Constants.ROOM) && dungeon.map[pc_y + 1][pc_x].entity == null) {
				dungeon.map[pc_y + 1][pc_x].entity = item;
				dropped = true;
			}
			else if (randNum == 2 && dungeon.map[pc_y][pc_x - 1].symbol.equals(Constants.ROOM) && dungeon.map[pc_y][pc_x - 1].entity == null) {
				dungeon.map[pc_y][pc_x - 1].entity = item;
				dropped = true;
			}
			else if (randNum == 3 && dungeon.map[pc_y][pc_x + 1].symbol.equals(Constants.ROOM) && dungeon.map[pc_y][pc_x + 1].entity == null) {
				dungeon.map[pc_y][pc_x + 1].entity = item;
				dropped = true;
			}
			count++;
		}
	}
	
	public static void calculateNewStats(Item item, Player player, boolean add) {
		if (add) {
			player.health_points += item.health_point_bonus;
			player.attack_damage += item.attack_damage_bonus;
			player.armor += item.armor_bonus;
		}
		else {
			player.health_points -= item.health_point_bonus;
			player.attack_damage -= item.attack_damage_bonus;
			player.armor -= item.armor_bonus;
		}
	}
}
