package cityStuff;

import java.util.*;
import teamStuff.*;


/**
 * Class for initializing the shop inventories with methods used primarily in gameEnvGui.
 * 
 * @author cwe55, vjj14
 *
 */
public class shop {
	
	
	/**
	 * An Integer[] array containing possible values for each of the shop's stocked HealingItem objects
	 */
	public Integer[] healingStockLevel = {5,3,1};
	
	
	
	/**
	 * An Integer[] array containing possible values for each of the shop's stocked PowerUp objects 
	 */
	public Integer[] powerUpStockLevel = {9,8,7,6,5,4,3,2,1};
	
	
	
	/**
	 * Initializes an ArrayList<HealingItem> of the shop's HealingItem objects.
	 */
	public ArrayList<HealingItem> healingItems = new ArrayList<HealingItem>() {{
		add(new RestoreHealthI());
		add(new RestoreHealthII());
		add(new RestoreHealthIII());
	}};
	
	
	
	/**
	 * Initializes an ArrayList<PowerUp> of the shop's PowerUp objects.
	 */
	public ArrayList<PowerUp> powerUpItems = new ArrayList<PowerUp>() {{
		add(new IronFleshI());
		add(new IronFleshII());
		add(new IronFleshIII());
		add(new AugmentVitalityI());
		add(new AugmentVitalityII());
		add(new AugmentVitalityIII());
		add(new SilverTongueI());
		add(new SilverTongueII());
		add(new SilverTongueIII());
	}};
	
		
	
	/**
	 * Getter for the powerUpStockLevel Integer[].
	 * 
	 * @return powerUpStockLevel        Integer[]
	 */
	public Integer[] getPowerUpStockLevel() {
		return powerUpStockLevel;
	}
	
	
	
	/**
	 * Getter for the healingStockLevel array.
	 * 
	 * @return healingStockLevel     Integer[]
	 */
	public Integer[] getHealingStockLevel() {
		return healingStockLevel;
	}

	
	
	/**
	 * Getter for the healingItems ArrayList.
	 * 
	 * @return healingItems ArrayList<HealingItem>
	 */
	public ArrayList<HealingItem> getHealingItems(){
		return healingItems;
	}

		
	
	/**
	 * Getter for the powerUpItems ArrayList<PowerUp>.
	 * 
	 * @return powerUpItems        ArrayList<PowerUp>
	 */
	public ArrayList<PowerUp> getPowerUpItems() {
		return powerUpItems;
	}
		
}
