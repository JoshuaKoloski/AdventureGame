package pa04;

/**
 * a door is a connection to a room
 * to get to a room a player must be
 * admitted by a door
 * @author tim
 *
 */
public class Door {
	public Room destination;

	public Door( Room dest) {
		this.destination = dest;
	}

	public boolean admit(Player p){
		// change the player's location field
		p.location = destination;
		return true;  // some rooms might require keys
	}
	
}



