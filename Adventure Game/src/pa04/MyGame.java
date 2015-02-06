package pa04;

/**
 * MyGame is a game that resembles a scavenger hunt
 * which has 6 rooms and 10 items and
 * 1 player. The goal is to bring the
 * basketball to the court and you win.
 * 
 * @author josh
 *
 */
public class MyGame extends Game {

	private Room start;
	private Room goalRoom; // the room you need to be in to win
	private Item goalItem; // the item you need to have to win

	/**
	* create a simple MyGame
	*/
	public MyGame() {
		super("mygame",
				"this is a three room game"+
				"the goal is to bring the coin"+
				"to the laboratory");

	}
	
	/**
	* create six rooms, ten items, 
	* put the items in the rooms and add
	* doors to the rooms
	* Set the goal to be bringing the basketball
	* to the court.
	* Finally create the player.
	*/
	@Override
	public void createWorld(){
		Room lounge, library, laboratory, theater, lavatory, court;
		Item eraser, marker, acid, glass, flashlight, basketball, mask, broom, notebook, towel;
		
		// create the rooms and items arrays
		rooms = new Room[6];
		items = new ItemBox(10);
		
		// create the rooms
		lounge = new Room("lounge",
				"a bright room with students studying and watching television");
		library = new Room("library",
				"a cramped, dully lit room with shelves of overflowing books");
		laboratory = new Room("laboratory",
				"a lab filled with vials and chemicals");
		theater = new Room("theater",
				"a dusty room with a stage and violet curtains");
		lavatory = new Room("lavatory",
				"a closet-like room with a sink and a stall");
		court = new Room("court",
				"a shiny new basketball court with hoops and people playing");
		// store the entry in the start instance var
		this.start = lounge;
		// store them in an array for debugging
		rooms[0] = lounge;
		rooms[1] = library;
		rooms[2] = laboratory;
		rooms[3] = theater;
		rooms[4] = lavatory;
		rooms[5] = court;		
		
		//create the items
		eraser = new Item("eraser","a black whiteboard eraser", "item: the purpose of my existence");
		marker = new Item("marker","a blue marker", "item: how do you get through a lock without a key?");
		acid = new Item("acid","a corrosive acid that bites through and dissolves materials", "room: break a leg!");
		glass = new Item("glass", "a magnifying glass", "item: to see in the dark without fire");
		flashlight = new Item("flashlight", "a red flashlight", "room: you have sight to cite!");
		basketball = new Item("basketball", "a bright orange and bouncy basketball", "room: Finally! Time to play! My back is hurting...");
		mask = new Item("mask", "a gorilla mask", "item: it will sweep you off your feet");
		broom = new Item("broom", "a frayed straw broom", "room: what goes in must come out");
		notebook = new Item("notebook", "a green notebook", "room: the door won't open for you until you and it have better chemistry");
		towel = new Item("towel", "a brown paper towel", "item: you might have to use me to dry off some sweat after playing with this");
		
		// store them in an array for debugging 
		items.addItem(eraser);
		items.addItem(marker);
		items.addItem(acid);
		items.addItem(glass);
		items.addItem(flashlight);
		items.addItem(basketball);
		items.addItem(mask);
		items.addItem(broom);
		items.addItem(notebook);
		items.addItem(towel);

		// store the goal instance variables
		this.goalRoom = court;
		this.goalItem = basketball;
		
		// add doors and items to the lounge
		lounge.exits = new Door[2];
		lounge.exits[0] = new LockableDoor(library, flashlight);
		lounge.exits[1] = new LockableDoor(court, basketball);
		lounge.items.addItem(glass);
		lounge.items.addItem(flashlight);

		// add doors and items to the library
		library.exits = new Door[3];
		library.exits[0] = new Door(lounge);
		library.exits[1] = new Door(laboratory);
		library.exits[2] = new LockableDoor(theater, acid);
		library.items.addItem(notebook);	
		
		// add doors and items to the laboratory
		laboratory.exits = new Door[1];
		laboratory.exits[0] = new Door(library);
		laboratory.items.addItem(acid);
		laboratory.items.addItem(eraser);
		laboratory.items.addItem(marker);
		
		// add doors and items to the theater
		theater.exits = new Door[2];
		theater.exits[0] = new Door(library);
		theater.exits[1] = new LockableDoor(lavatory, broom);
		theater.items.addItem(broom);
		theater.items.addItem(mask);
		
		// add doors and items to the lavatory
		lavatory.exits = new Door[1];
		lavatory.exits[0] = new Door(theater);
		lavatory.items.addItem(towel);
		lavatory.items.addItem(basketball);
		
		// add doors to the court
		court.exits = new Door[1];
		court.exits[0] = new Door(lounge);
		
		// create the Players and place them in a room
		// in this case, we have only one player
		player1 = new Player("student",
				"a courageous adventurer");
		player1.location = start;
	}

	
	public boolean gameOver(Player p){
		return 
			p.location.equals(goalRoom)
			&&
			p.backpack.containsItem(goalItem)
		    &&
		    p.backpack.size() == 1; // player must be carrying only one item to win
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
	 * the main program creates a myGame
	 * and starts it for the user
	 * @param args the arguments are ignored
	 */
	public static void main(String[] args) {
		Game g = new MyGame();
		System.out.println("MyGame!!\n\n");
		
		g.printHelp();
		g.play();

	}
}


