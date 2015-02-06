package pa04;
/**
 * A DemoGame is a skeleton of a game
 * which has 3 rooms and 3 items and
 * 1 player. The goal is to bring the
 * coin to the laboratory and you win.
 * 
 * @author tim
 *
 */
public class DemoGame extends Game {

	private Room start;
	private Room goalRoom; // the room you need to be in to win
	private Item goalItem; // the item you need to have to win

	/**
	 * create a simple DemoGame
	 */
	public DemoGame() {
		super("demogame",
				"this is a three room game"+
				"the goal is to bring the coin"+
				"to the laboratory");

	}
	
	/**
	 * create three rooms, three items, 
	 * put the items in the rooms and add
	 * doors to the rooms
	 * Set the goal to be bringing the coin
	 * to the laboratory.
	 * Finally create the player.
	 */
	@Override
	public void createWorld(){
		Room entry, cavern, laboratory;
		Item coin, apple, key;
		
		// create the rooms and items arrays
		rooms = new Room[3];
		items = new ItemBox(3);
		
		// create the rooms
		entry = new Room("entry",
				"a small room with a dirt floor");
		cavern = new Room("cavern",
				"a dark cave extending into the mist");
		laboratory = new Room("laboratory",
				"a shiny lab filled with electronics");	
		// store the entry in the start instance var
		this.start = entry;
		// store them in an array for debugging
		rooms[0] = entry;
		rooms[1] = cavern;
		rooms[2] = laboratory;
		
		//create the items
		coin = new Item("coin","a shiny gold coin");
		key = new Item("key","a blue key");
		apple = new Item("apple","a tasty red apple");
		// store them in an array for debugging
		items.addItem(coin);
		items.addItem(key);
		items.addItem(apple);

		// store the goal instance variables
		this.goalRoom = laboratory;
		this.goalItem = coin;
		// add doors and items to the entry
		entry.exits = new Door[1];
		entry.exits[0] = new Door(cavern);
		entry.items.addItem(coin);

		// add doors and items to the cavern
		cavern.exits = new Door[2];
		cavern.exits[0] = new Door(entry);
		cavern.exits[1] = new Door(laboratory);
		cavern.items.addItem(key);
		cavern.items.addItem(apple);
		
		
		// add doors and items to the laboratory
		laboratory.exits = new Door[1];
		laboratory.exits[0] = new Door(entry);
		
		// create the Players and place them in a room
		// in this case, we have only one player
		player1 = new Player("avatar",
				"a courageous adventurer");
		player1.location = start;
	}

	
	public boolean gameOver(Player p){
		return 
			p.location.equals(goalRoom)
			&&
			p.backpack.containsItem(goalItem);
	}
	
	/**
	 * takeTurn calls the main takeTurn method but prints
	 * its own message before and after the call
	 */
	@Override
	protected void takeTurn(Player p){
		System.out.println("<<<<< player "+p.name+" is about to take a turn.");
		super.takeTurn(p);
		System.out.println(">>>>> player "+p.name+" just took a turn.\n\n\n\n");
	}
	
	/**
	 * the main program creates a DemoGame
	 * and starts it for the user
	 * @param args the arguments are ignored
	 */
	public static void main(String[] args) {
		Game g = new DemoGame();
		System.out.println("DEMO GAME!!\n\n");
		
		g.printHelp();
		g.play();

	}
}
