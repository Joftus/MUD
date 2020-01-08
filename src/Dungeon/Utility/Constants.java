package Dungeon.Utility;

public class Constants {

	// Dungeon Values
	public static int DUNGEON_X = 100;
    public static int DUNGEON_Y = 100;
    public static int VISUAL_X = DUNGEON_X * 10;
    public static int VISUAL_Y = DUNGEON_Y * 10;
    
    public static int NUMBER_OF_ROOMS = 1;
    public static int NUMBER_OF_STAIRS = 0;			// needs at least 2 for dora win condition
    public static int NUMBER_OF_MONSTERS = 1;
    public static int NUMBER_OF_ITEMS = 4;
    public static int INVENTORY_SIZE = 3;
    public static int DROP_ITEM_TRIES = 100;
    public static int ROOM_SIZE_RANGE = 7;
    public static int ROOM_SIZE_MIN = 9;
    public static int PLACE_ROOM_TRIES = 100;
    public static int PLACE_CORRIDOR_TRIES = 100;
    public static int ROUNDNESS_CORRIDORS_RANGE = 5;
    public static int ROUNDNESS_CORRIDORS_MIN = 1;
    public static int TOP_FLOOR = 10;
    public static int BOTTOM_FLOOR = -1;
    
    // Symbols and Hardness of tile
    public static String CORRIDOR = "#";
    public static String ROOM = ".";
    public static String WALL = " ";
    public static String STAIR_UP = ">";
    public static String STAIR_DOWN = "<";
    public static String PLAYER = "@";
    public static String MONSTER = "O";
    public static String ITEM = "A";
    public static String UNKOWNEN = "?";
    
    // Tile hardness
    public static int ROOM_HARDNESS = 1;
    public static int WALL_HARDNESS = 255;
    
    // Formatting
    public static String NEW_ERROR_PAGE = "\n\n\n\n\n"; // 5 new lines
    public static String SLIGHT_PUSHUP = "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n";
    public static String NEW_PAGE = "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n";
    public static int WELCOME_PAGE_SPACES = 43;
    public static int END_PAGE_SPACES = 42;
    public static int ATTACK_MESSAGE_SLEEP = 2000;
    
    // File Paths
    public static String LOAD_FILE_PATH = "";
    public static String SAVE_FILE_PATH = "";
    
    // Base Player Values
    public static double BASE_PLAYER_HEALTH_POINTS = 10.0;
    public static double BASE_PLAYER_ATTACK_DAMAGE = 10.0;
    public static double BASE_PLAYER_ABILITY_POWER = 10.0;
    public static double BASE_PLAYER_ARMOR = 10.0;
    public static double BASE_PLAYER_MAGIC_RESIST = 10.0;
    public static double BASE_PLAYER_RANGE = 1.0;
    public static double BASE_PLAYER_SPEED = 10.0;
    
    // Base Monster Values
    public static String[] MONSTER_NAMES = {"penny", "mark", "alex", "tim", "steve", "grant", "roman", "nate", "jake", "clay", "kyle", "matthias", "logan", "sean", "noah", "james"};
    public static double BASE_MONSTER_HEALTH_POINTS = 1.0;
    public static double BASE_MONSTER_ATTACK_DAMAGE = 5.0;
    public static double BASE_MONSTER_ABILITY_POWER = 1.0;
    public static double BASE_MONSTER_ARMOR = 5.0;
    public static double BASE_MONSTER_RANGE = 1.0;
    public static double BASE_MONSTER_SPEED = 1.0;
    
    // Base Item Values
    public static String[] ITEM_NAMES = {"dagger (lvl I)", "sheild (lvl I)", "health pack (lvl I)", "dagger (lvl II)", "sheild (lvl II)", "health pack (lvl II)", "dagger (lvl III)", "sheild (lvl III)", "health pack (lvl III)"};
    public static int DAGGER_BASE_VALUE = 3;
    public static int SHEILD_BASE_VALUE = 3;
    public static int HEALTH_PACK_BASE_VALUE = 3;
    
    /*
     * Entitiy Numbers
     * 0. Player
     * 1. -> ?: Monsters
     * ? -> ? + ?: Items
     */
}
