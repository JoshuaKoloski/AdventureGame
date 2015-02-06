package pa04;


/**
 * An ItemBox contains Items
 * The box stores items in a list
 * and lets you easily add or remove
 * elements and check for membership.
 * @author tim
 *
 */
public class ItemBox {
	private Item[] items;
	private int size=0;
	
	public ItemBox(int k){
		items = new Item[k];
	}
	
	public boolean isEmpty(){
		return size==0;
	}
	/**
	 * @return the number of element in the item box
	 */
	public int size(){
		return size;
	}
	
	/**
	 * get the kth item from the itemBox
	 * @param k the index of the element to return
	 * @return item at position k
	 */
	public Item getItem(int k){
		return items[k];
	}
	
	/**
	 * add the item a to the last position of the itemBox
	 * @param a the item to be added
	 */
	public void addItem(Item a){
		items[size]=a;
		size += 1;
	}
	
	/**
	 * remove the kth item from the item box
	 * @param k
	 */
	public void removeItem(int k){
		for (int i=k; i<size; i++){
			items[i] = items[i+1];
		}
		size -= 1;
	}
	/**
	 * remove the item x from the list of items
	 */
	public void removeItem(Item x){
		int k=0; // index of element
		// find the element to remove
		for (int i=0; i<size; i++){
			if (items[i].equals(x)){
				k=i;size = size-1;
			}
		}
		// shift the remaining elements down one
		for (int i=k; i<size; i++){
			items[i]= items[i+1];
		}
		
	}
	
	public boolean containsItem(Item x){
		// search for the element
		for (int i=0; i<size; i++){
			if (items[i].equals(x)){
				return true;
			}
		}
		return false;
	}

}
