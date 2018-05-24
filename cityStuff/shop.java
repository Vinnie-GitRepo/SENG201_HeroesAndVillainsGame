package cityStuff;
import java.util.*;
import teamStuff.*;


public class shop {
	

	public Integer[] healingStockLevel = {5,3,1};
	public Integer[] getHealingStockLevel() {
		return healingStockLevel;
	}

	public ArrayList<HealingItem> getHealingItems(){
		return healingItems;
	}
	public ArrayList<HealingItem> healingItems = new ArrayList<HealingItem>(){{
		add(new RestoreHealthI());
		add(new RestoreHealthII());
		add(new RestoreHealthIII());
		}};
	
		
		public Integer[] powerUpStockLevel = {9,8,7,6,5,4,3,2,1};
		public Integer[] getPowerUpStockLevel() {
			return powerUpStockLevel;
		}

		public ArrayList<PowerUp> getPowerUpItems(){
			return getPowerUpItems;
		}
		public ArrayList<PowerUp> getPowerUpItems = new ArrayList<PowerUp>(){{
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

}
