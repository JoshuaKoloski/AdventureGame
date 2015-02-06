package pa04;
/**
 * items are elements in rooms that
 * users can pickup or drop
 * @author tim
 *
 */
public class Item {
	public String name;
	public String description;
	public String clue;
	public Item(String name, String description) {
		this.name = name;
		this.description =description;
	}
	public Item(String name, String description, String clue) {
		this.name = name;
		this.description =description;
	    this.clue = clue;
	}	    
}
