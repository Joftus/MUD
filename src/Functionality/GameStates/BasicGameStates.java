package Functionality.GameStates;

import java.util.Scanner;

import Dungeon.Utility.GeneralUtility;
import Visual.Visual;

public class BasicGameStates {

	@SuppressWarnings("resource")
	public static String gameStart() {
		Scanner scan = new Scanner(System.in);
		Visual.logo(true);
		System.out.print("Player Name: ");
		return scan.nextLine();
	}
	
	@SuppressWarnings("resource")
	public static boolean gameOverLoss() {
		Scanner scan;
		
		scan = new Scanner(System.in);
		
		Visual.logo(false);
		System.out.println("You were killed!");
		System.out.print("Play Again (y/n): ");
		return GeneralUtility.yesOrNo(scan.nextLine());
	}
	
	@SuppressWarnings("resource")
	public static boolean gameOverWinByClearingFloor() {
		Scanner scan;
		
		scan = new Scanner(System.in);
		
		Visual.logo(false);
		System.out.println("You won by killing everything, great job murderer!");
		System.out.print("Play Again (y/n): ");
		return GeneralUtility.yesOrNo(scan.nextLine());
	}
	
	@SuppressWarnings("resource")
	public static boolean gameOverWinByReachingEnd() {
		Scanner scan;
		
		scan = new Scanner(System.in);
		
		Visual.logo(false);
		System.out.println("You won by reaching the end, congrats explorer!");
		System.out.print("Play Again (y/n): ");
		return GeneralUtility.yesOrNo(scan.nextLine());
	}
}
