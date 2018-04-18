package games;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class paperScissorsRock {
	public static boolean finish = false;
	public static boolean heroWon = false;
	public static String[] options = {"Paper","Scissors","Rock"};
	public void printOptions() {
		System.out.println("Options");
		for (int i = 0; i < options.length; i++) {
			System.out.println(i + ", " + options[i]);
		}
		//System.out.println("Options");
		//Scanner num = new Scanner(System.in);
		//System.out.println(num.nextLine());
	}
	public int getHeroChoice() {
		System.out.println("Please Choose a number");
		Scanner num = new Scanner(System.in);
		return num.nextInt();//Integer.parseInt(num.nextLine());
	}
	public void getOutCome(String outcome) {
		switch(outcome) {
		case "PaperScissors" :
			System.out.println("The Villian Has Won");
			finish = true;
			break;
		case "PaperRock" :
			System.out.println("You Have Won");
			finish = true;
			break;
		case "ScissorsPaper" :
			System.out.println("You Have Won");
			finish = true;
			break;
		case "ScissorsRock" :
			System.out.println("The Villian Has Won");
			finish = true;
			break;
		case "RockScissors" :
			System.out.println("You Have Won");
			finish = true;
			break;
		case "RockPaper" :
			System.out.println("The Villian Has Won");
			finish = true;
			break;
		case "RockRock" :
			System.out.println("It Is A Draw, Next Round!");
			break;
		case "PaperPaper" :
			System.out.println("It Is A Draw, Next Round!");
			break;
		case "ScissorsScissors" :
			System.out.println("It Is A Draw, Next Round!");
			break;
		}
		
	}
	public static void playGame() {
		paperScissorsRock game = new paperScissorsRock();
		while (finish == false) {
		game.printOptions();
		int heroChoice = game.getHeroChoice();
		System.out.println("You have chosen " + options[heroChoice]);
		int villianChoice = ThreadLocalRandom.current().nextInt(0, 3);
		System.out.println("The Villian has chosen " + options[villianChoice]);
		String outcome = options[heroChoice] + options[villianChoice];
		game.getOutCome(outcome);
		}
	}
	public static void main(String[] args) {
		paperScissorsRock game = new paperScissorsRock();
		while (finish == false) {
		game.printOptions();
		int heroChoice = game.getHeroChoice();
		System.out.println("You have chosen " + options[heroChoice]);
		int villianChoice = ThreadLocalRandom.current().nextInt(0, 3);
		System.out.println("The Villian has chosen " + options[villianChoice]);
		String outcome = options[heroChoice] + options[villianChoice];
		game.getOutCome(outcome);
		}
		//System.out.println(outcome);
		
	}

}
