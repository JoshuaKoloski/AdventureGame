package pa04;
/**
 * LockableDoor is a subclass of door that
 * can only be opened if the player is carrying
 * the necessary item.
 * @author josh
 */
public class LockableDoor extends Door {
	   public Item unlockItem;
	public LockableDoor(Room dest, Item unlockItem) {
	   super(dest);	
	   this.unlockItem = unlockItem;
	}
    public Item getItem() {
    	return this.unlockItem;
    }
    @Override
    public boolean admit(Player p){
    	if (p.backpack.containsItem(getItem())) {
		   p.location = destination;
		  return true;  
	    }
    	System.out.println("This door is locked. You need an item to open this door");
    	return false;
    }
}    
