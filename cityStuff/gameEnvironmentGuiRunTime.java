package cityStuff;
import java.awt.Image;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

import javax.swing.ImageIcon;

import games.*;
import teamStuff.*;
import villianStuff.Villian;

/**
 * Class containing useful data and methods called from across all classes.<br>
 * An instance of this class is instantiated within gameEnvGui, the main program, so the game can use all relevant code. 
 * 
 * @author cwe55, vjj14
 *
 */
public class gameEnvironmentGuiRunTime {
	
	
	
	/**
	 * 
	 */
	private static boolean[] foundPlaces = {false, false, false, false};
	
	
	
	/**
	 * 
	 */
	private static boolean hasMap = false;
	
	
	
	/**
	 * 
	 */
	private static ArrayList<Villian> villians = new ArrayList<Villian>();
	
	
	
	/**
	 * 
	 */
	private static ArrayList<shop> shops = new ArrayList<shop>();
	
	
	
	/**
	 * 
	 */
	private static int currentHero;
	
	
	
	/**
	 * 
	 */
	private static ArrayList<String> thisMap;
	
	
	
	/**
	 * 
	 */
	private static shop currentShop;
	
	
	
	/**
	 * 
	 */
	public int num_of_cities;
	
	
	
	/**
	 * 
	 */
	private static Villian currentVillian;
	
	
	
	/**
	 * 
	 */
	private static boolean luck = false;
	
	
	
	/**
	 * 
	 */
	private boolean healingItemInUse = false;
	
	
	
	/**
	 * 
	 */
	public void refresh() {
		healingItemInUse = false;
		luck = false;
		currentVillian = null;
		currentShop = null;
		thisMap = null;
		currentHero = 0;
		shops = new ArrayList<shop>();
		villians = new ArrayList<Villian>();
		hasMap = false;
		foundPlaces[0] = false;
		foundPlaces[1] = false;
		foundPlaces[2] = false;
		foundPlaces[3] = false;
	}
	
	
	
	/**
	 * 
	 */
	public void useHealingItem() {
		healingItemInUse = true;
	}
	
	
	
	/**
	 * 
	 * @return
	 */
	public boolean usingHealingItem() {
		return healingItemInUse;
	}
	
	
	
	/**
	 * 
	 */
	public void stopUsingHealingItem() {
		healingItemInUse = false;
	}
	
	
	
	/**
	 * 
	 */
	public void giveLuck() {
		luck = true;
	}
	
	
	
	/**
	 * 
	 * @return
	 */
	public String randomEvent() {
		String theEvent ="Your Team Had A Safe Journey Back";
		Random happen = new Random();
		boolean event = happen.nextBoolean();
		if (event) {
			int number = happen.nextInt(4);
			switch(number) {
			case 0:
				theEvent = "Your Team Has Been Given An Item!";
				int itemNum = happen.nextInt(3);
				System.out.println(itemNum);
				team.addHealingItem(currentShop.getHealingItems().get(itemNum));
				break;
			case 1:
				theEvent = "Your Team Has Lost An Item!";
				try {
				team.getHealingItems().remove(happen.nextInt(team.getHealingItems().size()));
				} catch (Exception e) {
					theEvent = "Someone Tried To Rob You But You Got Nothin!";
				}
				break;
			case 2:
				theEvent = "Your Team Has Been Given Some Money!";
				team.addMoney(300);
				break;
			case 3:
				theEvent = "Your Team Has Been Robbed Of Some Money!";
				team.addMoney(-150);
				break;
			}
		}
		return theEvent;
	}
	
	
	
	/**
	 * 
	 * @return
	 */
	public boolean hasLuck() {
		return luck;
	}
	
	
	
	/**
	 * 
	 */
	public void giveMap() {
		hasMap = true;
	}
	
	
	
	/**
	 * 
	 * @return
	 */
	public boolean hasMap() {
		return hasMap;
	}
	
	
	
	/**
	 * 
	 */
	public void makeAllUnfound() {
		foundPlaces[0] = false;
		foundPlaces[1] = false;
		foundPlaces[2] = false;
		foundPlaces[3] = false;
	}
	
	
	
	/**
	 * 
	 */
	public void makeAllFound() {
		foundPlaces[0] = true;
		foundPlaces[1] = true;
		foundPlaces[2] = true;
		foundPlaces[3] = true;
	}
	
	
	
	/**
	 * 
	 * @param num
	 */
	public void setFoundPlaceTrue(int num) {
		foundPlaces[num] = true;
	}
	
	
	/**
	 * 
	 * @return
	 */
	public int getNumOfCities() {
		return baseCamps.size();
	}
	
	
	
	/**
	 * 
	 * @param num
	 * @param city
	 * @return
	 */
	public String getMapPlace(int num, int city) {
		if (foundPlaces[num] == true) {
			return baseCamps.get(city).getMap().get(num);
		} else {
			return "???";
		}
	}
	
	
	/**
	 * 
	 * @param num
	 * @return
	 */
	public ArrayList<String> getCurrentMap(int num){
		return baseCamps.get(num).getMap();
	}
	
	
	/**
	 * 
	 * @return
	 */
	public boolean[] getFoundPlaces() {
		return foundPlaces;
	}
	
	
	/**
	 * 
	 * @param num
	 */
	public void setCurrentHero(int num) {
		currentHero = num;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getCurrentHero() {
		return currentHero;
	}
	
	
	/**
	 * 
	 * @param num
	 */
	public void setCurrentVillian(int num) {
		currentVillian = villians.get(num);
	}
	
	/**
	 * 
	 * @return
	 */
	public Villian getCurrentVillian() {
		return currentVillian;
	}
	
	
	/**
	 * 
	 * @param num
	 */
	public void setCurrentShop(int num) {
		currentShop = shops.get(num);
	}
	
	
	/**
	 * 
	 * @return
	 */
	public shop getCurrentShop() {
		return currentShop;
	}
	
	
	/**
	 * 
	 */
	private ArrayList<baseCamp> baseCamps = new ArrayList<baseCamp>(); 
	
	
	/**
	 * 
	 */
	private Team team;
	
	
	/**
	 * 
	 */
	public Random rand = new Random();
	
	
	/**
	 * 
	 * @param map
	 */
	public void addBaseCamp(ArrayList<String> map) {
		baseCamp Camp = new baseCamp(map);
		baseCamps.add(Camp);
	}
	
	
	/**
	 * Allows for other classes to get the team in order
	 * to edit or add
	 */
	public Team getTeam() {
		return team;
	}
	
	/**
	 * @return info MerchantMan
	 */
	public MerchantMan getMerchant() {
		MerchantMan info = new MerchantMan();
		return info;
	}
	
	
	/**
	 * 
	 * @return info Tank
	 */
	public Tank getTank() {
		Tank info = new Tank();
		return info;
	}
	
	
	/**
	 * 
	 * @return info Cartographer 
	 */
	public Cartographer getCartographer() {
		Cartographer info = new Cartographer();
		return info;
	}
	
	
	/**
	 * 
	 * @return info Support
	 */
	public Support getSupport() {
		Support info = new Support();
		return info;
	}
	
	
	/**
	 * 
	 * @return info LuckyBoii
	 */
	public LuckyBoii getLuckyBoii() {
		LuckyBoii info = new LuckyBoii();
		return info;
	}
	
	
	
	/**
	 * 
	 * @return Edgy
	 */
	public EdgyScaryFiendLord getAntiHero() {
		EdgyScaryFiendLord info = new EdgyScaryFiendLord();
		return info;
	}
	
	
	
	/**
	 * 
	 * @return
	 */
	public RestoreHealthI getRHI() {
		RestoreHealthI info = new RestoreHealthI();
		return info;
	}
	
	
	
	/**
	 * 
	 * @return
	 */
	public RestoreHealthII getRHII() {
		RestoreHealthII info = new RestoreHealthII();
		return info;
	}
	
	
	/**
	 * 
	 * @return
	 */
	public RestoreHealthIII getRHIII() {
		RestoreHealthIII info = new RestoreHealthIII();
		return info;
	}
	
	
	/**
	 * 
	 * @return
	 */
	public AugmentVitalityI getAVI() {
		AugmentVitalityI info = new AugmentVitalityI();
		return info;
	}
	
	/**
	 * 
	 * @return
	 */
	public AugmentVitalityII getAVII() {
		AugmentVitalityII info = new AugmentVitalityII();
		return info;
	}
	
	
	/**
	 * 
	 * @return
	 */
	public AugmentVitalityIII getAVIII() {
		AugmentVitalityIII info = new AugmentVitalityIII();
		return info;
	}
	
	
	/**
	 * 
	 * @return
	 */
	public IronFleshI getIFI() {
		IronFleshI info = new IronFleshI();
		return info;
	}
	
	
	
	/**
	 * 
	 * @return
	 */
	public IronFleshII getIFII() {
		IronFleshII info = new IronFleshII();
		return info;
	}
	
	
	
	/**
	 * 
	 * @return
	 */
	public IronFleshIII getIFIII() {
		IronFleshIII info = new IronFleshIII();
		return info;
	}
	
	
	
	/**
	 * 
	 * @return
	 */
	public SilverTongueI getSTI() {
		SilverTongueI info = new SilverTongueI();
		return info;
	}
	
	
	
	/**
	 * 
	 * @return
	 */
	public SilverTongueII getSTII() {
		SilverTongueII info = new SilverTongueII();
		return info;
	}
	
	
	
	/**
	 * 
	 * @return
	 */
	public SilverTongueIII getSTIII() {
		SilverTongueIII info = new SilverTongueIII();
		return info;
	}
	
	

	
	/**
	 * This is used when finishing a city the team is returned
	 * through the game and set to theTeam in order to move
	 * into the next city
	 */
	public void setTeam(Team theTeam) {
		team = theTeam;
	} 
	
	
	/**
	 * Generates each villian for each city and stores them within villians an ArrayList<villian>.
	 */
	public void generateVillians(int num) {
		
		ArrayList<String> villianNames = new ArrayList<String>() 
		{{
		add("Grabbin Steams");
		add("Higher Being");
		add("The Outlander");
		add("Semem Knad");
		add("?/+=}_?//.../?'__");
		add("THE BEAN LORD");
		}};
		
		ArrayList<String> catchPhrase = new ArrayList<String>() 
		{{
		add("Be away, knowlessmen!");
		add("Get thee gone, filth!");
		add("PROCEED CHALLENGER.");
		add(".....");
		add("The enemy hath appear'd!");
		add("*uninteligible noise*");
		}};
		
		ArrayList<ImageIcon> villianIcons = new ArrayList<ImageIcon>() {{
			add(new ImageIcon(new ImageIcon(GameEnvironmentGui.class.getResource("/Images/vill1.png")).getImage().getScaledInstance(550, 550, Image.SCALE_DEFAULT)));
			add(new ImageIcon(new ImageIcon(GameEnvironmentGui.class.getResource("/Images/vill2.png")).getImage().getScaledInstance(550, 550, Image.SCALE_DEFAULT)));
			add(new ImageIcon(new ImageIcon(GameEnvironmentGui.class.getResource("/Images/vill3.png")).getImage().getScaledInstance(550, 550, Image.SCALE_DEFAULT)));
			add(new ImageIcon(new ImageIcon(GameEnvironmentGui.class.getResource("/Images/vill4.png")).getImage().getScaledInstance(550, 550, Image.SCALE_DEFAULT)));
			add(new ImageIcon(new ImageIcon(GameEnvironmentGui.class.getResource("/Images/vill5.png")).getImage().getScaledInstance(550, 550, Image.SCALE_DEFAULT)));
			add(new ImageIcon(new ImageIcon(GameEnvironmentGui.class.getResource("/Images/vill6.png")).getImage().getScaledInstance(550, 550, Image.SCALE_DEFAULT)));
		}};
		int numName;
		int numPhrase;	
		

		for (int i = 0; i < num; i++) {
			numName = rand.nextInt(villianNames.size());
			numPhrase = rand.nextInt(catchPhrase.size());
			boolean switchGame = false;
			
			if (numName % 2 == 0) 
			{
				switchGame = true;
			}
			Random thing = new Random();
			int changeNum = thing.nextInt(2);
			boolean changes = false;
			if (changeNum == 1) {
				changes = true;
			}
			Villian baddy = new Villian(villianNames.get(numName), 
					catchPhrase.get(numPhrase), switchGame, villianIcons.get(i), changes);
			villians.add(baddy);
			villianNames.remove(numName);														//Makes sure that any names used get removed in order for there to be no double ups
			catchPhrase.remove(numPhrase);														//Makes sure that any catch phrases used get removed in order for there to be no double ups
		}
	}
	
	
	/**
	 * This generates the city and how it will be laid out
	 * 
	 * @return areas
	 */
	public ArrayList<String> generateLayout() {
		ArrayList<String> options = new ArrayList<String>()
		{{add("Shop");
		add("Power Up Den");
		add("Hospital");
		add("Lair");
		}};
		
		String[] directions 	= 	{"North","East ","South","West "};
		ArrayList<String> areas = new ArrayList<String>();
		int size = options.size();
		int num;
		for (int i = size - 1; i != -1; i--) {
			num = rand.nextInt(i + 1);
			areas.add(options.get(num));
			options.remove(num);
		}
		return areas;
	}
	
	
	
	
	
	public void setNumOfCities(int num) {
		num_of_cities = num;
	}
	
	
	
	public void setThingsUp(int num) {
		team = new Team();
		for (int i = 0; i < num; i++) {
			shop newShop = new shop();
			shops.add(newShop);
		}
	}
}
