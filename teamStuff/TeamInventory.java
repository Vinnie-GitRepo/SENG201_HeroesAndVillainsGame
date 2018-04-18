package teamStuff;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;

public class TeamInventory {
	
	/**
	 * An ArrayList where consumables are added and removed, which the displayInventory uses to sort inventory
	 */
	public static ArrayList<Consumable> workingInventory = new ArrayList<Consumable>();
	
	/**
	 * A TreeSet which gets updated every time the workingInventory changes  
	 */
	public static TreeSet<String> displayInventory;
	
	
	
	
	
	/**
	 * Refreshes the displayInventory when the workingInventory changes
	 */
	public void refreshDisplayInventory() {
		displayInventory = new TreeSet<String>();    
		for(Consumable item : workingInventory) {
			int itemFrequency = Collections.frequency(workingInventory, item);
			displayInventory.add(item.getName() + "(" + itemFrequency + ")");
		} 
	}
	
	
	
	/**
	 * Adds a consumable item to the workingInventory
	 * Reshreshes displayInventory
	 * @param item
	 */
	public void addItem(Consumable item) {    
		workingInventory.add(item);
		refreshDisplayInventory();
	}
	
	
	/**
	 * Removes a consumable item from the workingInventory
	 * Refreshes displayInventory
	 * @param item
	 */
	public void removeItem(Consumable item) {
		workingInventory.remove(item);
		refreshDisplayInventory();
	}
	
	
	
}
