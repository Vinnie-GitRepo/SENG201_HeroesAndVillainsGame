package cityStuff;
import java.util.*;

public class shop extends baseCamp {
	
	public Integer[] 	healingPrice 	= 	{5,15,30};
	
	public String[] 	healingItems 	= 	{"Immediate 25 Health","2 Minute Full Health", "1 Minute Full Health"};
	
	public ArrayList<Integer> healingStockLevel = new ArrayList<Integer>() 
	{{
	add(5);
	add(3);
	add(1);
	}};
	
	public Integer[] 	powerUpPrice 	= 	{5,15,30};
	
	public String[] 	powerUpItems 	= 	{"Augment Vitality","Iron Flesh", "Silver Tongue"};
	
	public ArrayList<Integer> powerUpStockLevel = new ArrayList<Integer>() 
	{{
	add(5);
	add(3);
	add(1);
	}};
	
	
	//Show da menu oi
	public void viewMenu() {
		
		System.out.println("Menu Options");
		System.out.println("(0) View Healing Items");
		System.out.println("(1) View Power Ups");
		System.out.println("(2) Exit");
		
		int selection = this.getPlayerChoice();
		
		switch(selection) {
		case 0 :
			this.showHealingItems();
			break;
		case 1 :
			this.showPowerUpItems();
			break;
		case 2 :
			this.exit();
			break;
		default:
			System.out.println("Please input a valid choice");
			this.viewMenu();
			break;
		}
	}
	
	
	//Same exit method to head back to the base camp
	public void exit() {
		System.out.println("Heading Back To The Base Camp");
		super.viewMenu();
	}
	
	
	//Shows the list of items that are available to purchase
	public void showHealingItems() {
		for (int i = 0; i < healingItems.length; i++) {
			System.out.println("(" + i + ") " + "Price - " + healingPrice[i] + " " + healingItems[i] + " Stock Level - " + healingStockLevel.get(i));
		}
		//at this point need to add a swithc to buy different things
	}
	
	
	//Shows the list of power ups available to purchase
	public void showPowerUpItems() {
		for (int i = 0; i < healingItems.length; i++) {
			System.out.println("(" + i + ") " + "Price - " + powerUpPrice[i] + " " + powerUpItems[i] + " Stock Level - " + powerUpStockLevel.get(i));
		}
		//at this point need to add a swithc to buy different things
	}
	
	
	
	public shop() {
		System.out.println("\n-------------\nYou have made it into the shop!\n-------------\n");
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    shop Shop = new shop();
	    Shop.viewMenu();
	}

}
