package cityStuff;
import java.util.*;
import teamStuff.*;


public class shop extends baseCamp implements Consumable {
	
	public Integer[] 	healingPrice 	= 	{5,15,30};
	
	public String[] 	healingItems 	= 	{"1 Minute Full Health","2 Minute Full Health", "Immediate 25 Health"};//{"Immediate 25 Health","2 Minute Full Health", "1 Minute Full Health"};
	
	public static Integer[] healingStockLevel = {5,3,1};
	
	/*public static ArrayList<Integer> healingStockLevel = new ArrayList<Integer>() 
	{{
	add(5);
	add(3);
	add(1);
	}};*/
	
	public Integer[] 	powerUpPrice 	= 	{5,15,30};
	
	public String[] 	powerUpItems 	= 	{"Augment Vitality","Iron Flesh", "Silver Tongue"};
	
	public static ArrayList<Integer> powerUpStockLevel = new ArrayList<Integer>() 
	{{
	add(5);
	add(3);
	add(1);
	}};
	
	public Team currentTeam;
	
	
	public String getName(){
		return "HI";
	}
	public void apply(Hero hero){
		
	}
	
	
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
		super.setTeam(currentTeam);
		//super.viewMenu();
	}
	
	
	//Shows the list of items that are available to purchase
	public void showHealingItems() {
		for (int i = 0; i < healingItems.length; i++) {
			System.out.println("(" + i + ") " + "Price - " + healingPrice[i] + " " + healingItems[i] + " Stock Level - " + healingStockLevel[i]);//healingStockLevel.get(i));
		}
		System.out.println("(" + healingItems.length + ") Exit");
		int choice = this.getPlayerChoice();
		switch(choice) {
			case 0 :
				//System.out.println(healingStockLevel.get(0));
				//System.out.println(currentTeam);
				//System.out.println(currentTeam.getMoney());
				//System.out.println(healingPrice[0]);
				if (healingStockLevel[0]/*healingStockLevel.get(0)*/ >= 1 && currentTeam.getMoney() >= healingPrice[0]) {
					System.out.println("1 Minute Full Health Has Been Added To Your Inventory");
					RestoreHealthI healthI = new RestoreHealthI();
					currentTeam.addItem(healthI);
					healingStockLevel[0] -= 1;//healingStockLevel.add(0,healingStockLevel.get(0) - 1);
					currentTeam.addMoney(-healingPrice[0]);}
				else if (currentTeam.getMoney() < healingPrice[0]){
					System.out.println("Your Team Does Not Have Enough Money");
				} else {
						System.out.println("There Are Not Enough In Stock");
				} 
				this.viewMenu();
				break;
			case 1 :
				if (healingStockLevel[1]/*healingStockLevel.get(1)*/ >= 1 && currentTeam.getMoney() >= healingPrice[1]) {
					System.out.println("2 Minute Full Health Has Been Added To Your Inventory");
					RestoreHealthII healthII = new RestoreHealthII();
					currentTeam.addItem(healthII);
					healingStockLevel[1] -= 1;//healingStockLevel.add(1,healingStockLevel.get(1) - 1);
					currentTeam.addMoney(-healingPrice[1]);
				} else if (currentTeam.getMoney() < healingPrice[1]){
					System.out.println("Your Team Does Not Have Enough Money");
				} else {
						System.out.println("There Are Not Enough In Stock");
				}
				this.viewMenu();
				break;
			case 2 :
				if (healingStockLevel[2]/*healingStockLevel.get(1)*/ >= 1 && currentTeam.getMoney() >= healingPrice[2]) {
					System.out.println("Immediate 25 Health Has Been Added To Your Inventory");
					RestoreHealthIII healthIII = new RestoreHealthIII();
					currentTeam.addItem(healthIII);
					healingStockLevel[2] -= 1;//healingStockLevel.add(1,healingStockLevel.get(1) - 1);
					currentTeam.addMoney(-healingPrice[2]);
				} else if (currentTeam.getMoney() < healingPrice[2]){
					System.out.println("Your Team Does Not Have Enough Money");
				} else {
						System.out.println("There Are Not Enough In Stock");
				}
				System.out.println("Immediate 25 Health Has Been Added To Your Inventory");
				this.viewMenu();
				break;
			case 3 :
				this.viewMenu();
				break;
			default :
				System.out.println("Please Input A Valid Command");
				break;
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
	
	public void setTeam(Team team) {
		currentTeam = team;
		System.out.println("it set the team");
	}
	
	public shop() {
		//System.out.println("\n-------------\nYou have made it into the shop!\n-------------\n");
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    shop Shop = new shop();
	    Shop.viewMenu();
	}

}
