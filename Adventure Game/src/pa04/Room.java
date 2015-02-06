package pa04;
/**
 * a room contains items and has
 * doors that lead to other rooms
 * Players move through rooms and
 * pick up or drop items
 * @author tim
 * @see Player
 * @see Item
 * 
 */
public class Room {
	public Door[] exits;
	public ItemBox items;
	public String name;
	public String description;

	public Room(String name, String description) {
		this.name = name;
		this.description = description;
		this.items = new ItemBox(10);	
	}
	
	public String describeSelf(){
		String s;
		s="This is the "+name+"\n";
		s+= "It is "+description+"\n";
		if (items.size()==0) {
			s+= "there are no items\n";
		}else {
			s+= "the room contains\n";
			for (int i=0; i<items.size(); i++){
				Item x = items.getItem(i);
				s+= "item "+i+": "
						+x.name
						+" -- "+x.description+"\n";
			}
		}
		for (int i=0; i< exits.length; i++){
			Room x = exits[i].destination;
			s+="door "+i+": "+x.name+" -- "
					+x.description+"\n";
		}
		return s;
	}
}
