package pa04;
/**
 * a player moves from room to room
 * picking up and dropping items
 * @author tim
 *
 */
public class Player {
	public String name;
	public String description;
	public ItemBox backpack;
	public Room location;
	
	public Player(String name, String description){
		this.name = name;
		this.description = description;
		this.backpack = new ItemBox(10);
	}
	
	public void pickup(Item x){
		this.location.items.removeItem(x);
		this.backpack.addItem(x);
	}
	
	public void drop(Item x){
		this.backpack.removeItem(x);
		this.location.items.addItem(x);
	}
	
	public String describeSelf(){
		String s;
		s=this.name;
		if (backpack.size()>0){
			s+= " carrying \n";
			for (int i=0; i<backpack.size(); i++){
				if (backpack.getItem(i).clue != null) {
				    s+= "item "+i+": "+backpack.getItem(i).name + "   clue: " + backpack.getItem(i).clue + "\n";
				} else {
					s+= "item "+i+": "+backpack.getItem(i).name + "\n";	
				}
			}
		}
		return s;
	}


}
