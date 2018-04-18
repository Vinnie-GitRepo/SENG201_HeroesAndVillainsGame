package cityStuff;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;


public class city implements menu {
	public static ArrayList<String> areas = new ArrayList<String>();//
	public static ArrayList<String> options = new ArrayList<String>() {{add("Shop");add("PowerUpDen");add("Hospital");add("Lair");}};//"Shop","PowerUpDen","Hospital","Lair");//String[] options = {"Shop","PowerUpDen","Hospital","Lair"};
	public static String[] directions = {"North","East ","South","West "};//{"West","South","East","North"};
	int villianChoice = ThreadLocalRandom.current().nextInt(0, 3);
	
	public void viewMenu() {
		for (int i = 0; i < areas.size(); i++) {
			System.out.println(i + ": " + directions[i] + " - " + areas.get(i));
		}
	}
	public void enter() {
		
	}
	public void exit() {
		
	}
	public void generateLayout() {
		int size = options.size();
		//System.out.println("hi");
		for (int i = size - 1; i != -1; i--) {
			//System.out.println(i);
			int num = ThreadLocalRandom.current().nextInt(0, i + 1);
			//String toAdd = options.get(i); 
			areas.add(options.get(num));
			options.remove(num);
		}
	}
	public int getPlayerChoice() {
		System.out.println("Choose where you would like to move to.");
		Scanner pos = new Scanner(System.in);
		return pos.nextInt();
	}
	public void movePlayer(int pos) {
		String direction = directions[pos];
		String area = areas.get(pos);
		System.out.println("You have chosen to move " + direction + " into the " + area);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		city map = new city();
		map.generateLayout();
		map.viewMenu();
		int position = map.getPlayerChoice();
		map.movePlayer(position);
	}

}
