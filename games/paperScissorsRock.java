package games;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;//randomizer import
import teamStuff.*;
import villianStuff.*;

public class paperScissorsRock {
	//public static boolean finish = false;
	public static boolean draw = false;
	public static Team thisTeam;
	public static Villian thisVillian;
	//public static boolean finish = false;
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
	
	public String getOutCome(String outcome) {
		String to_return = "hi";
		switch(outcome) {
		case "PaperScissors" :
			to_return = "The Villian Has Won";
			break;
		case "PaperRock" :
			to_return = "You Have Won";
			break;
		case "ScissorsPaper" :
			to_return = "You Have Won";
			break;
		case "ScissorsRock" :
			to_return = "The Villian Has Won";
			break;
		case "RockScissors" :
			to_return = "You Have Won";
			break;
		case "RockPaper" :
			to_return = "The Villian Has Won";
			break;
		case "RockRock" :
			to_return = "It Is A Draw, Next Round!";
			break;
		case "PaperPaper" :
			to_return = "It Is A Draw, Next Round!";
			break;
		case "ScissorsScissors" :
			to_return = "It Is A Draw, Next Round!";
			break;
		}
		return to_return;
	}
	
	public int getPlayerChoice() {
		Scanner pos = new Scanner(System.in);
		return pos.nextInt();
	}
	
	
	
	public String getVillianChoice(int num) {
		Random rand = new Random();
		return options[rand.nextInt(num)];
	}
	
	public void gameSequence() {
		//boolean heroWon = true;
		boolean continuePlaying = true;
		boolean finish = false;
		boolean selectChar = false;
		
		thisTeam.selectHero();
		int heroChoice = this.getPlayerChoice();
		Hero currentHero = thisTeam.getHeroArray().get(heroChoice);
		System.out.println("You Have Chosen To Play With " + currentHero.getName());
		while ((finish == false) || (continuePlaying == true)){
			if (selectChar) {
				thisTeam.selectHero();
				heroChoice = this.getPlayerChoice();
				currentHero = thisTeam.getHeroArray().get(heroChoice);
				System.out.println("You Have Chosen To Play With " + currentHero.getName());
				selectChar = false;}
			while (finish == false) {
				this.printOptions();
				int playerChoice = this.getHeroChoice();
				System.out.println("You have chosen " + options[playerChoice]);
				int villianChoice = ThreadLocalRandom.current().nextInt(0, 3);
				System.out.println("The Villian has chosen " + options[villianChoice]);
				String outcome = options[playerChoice] + options[villianChoice];
				this.getOutCome(outcome);
				int choice = 0;
				if (heroWon == false && draw == false) {
					currentHero.damageHealth(25);
					System.out.println(currentHero.getName() + " has taken 25 damage!");
					System.out.println("The heroes health is currently " + currentHero.getCurrentHealth() + "/" +currentHero.getMaxHealth());
					if (currentHero.getCurrentHealth() <= 0) {
						currentHero.deathHandling();
						choice = 0;
						if (thisTeam.getHeroArray().size() == 0) {
							continuePlaying = false;
							finish = true;
							break;
						}
					} else {
					//if there are still players
					System.out.println("Options:\n(0) Switch Character\n(1) Continue Playing\n(2) Flee From Lair");
					choice = this.getPlayerChoice();}
					if (choice == 0) {
					continuePlaying = true;
					selectChar = true;
					break;
					} else if (choice == 1){
						continuePlaying = true;
					} else if (choice == 2) {
						continuePlaying = false;
						finish = true;
						break;
					}
					heroWon = false;
				} else if (draw == false ){
					System.out.println("You Deal Damage Towards The Villian");
					thisVillian.oneDefeat();
					System.out.println("You have defeated the Villian " + thisVillian.getLossCount() + "/3 Times");
					System.out.println("Options:\n(0) Switch Character\n(1) Continue Playing\n(2) Flee From Lair");
					if (thisVillian.getLossCount() == 3) {
						continuePlaying = false;
						finish = true;
					} else {
					choice = this.getPlayerChoice();
					if (choice == 0) {
					continuePlaying = true;
					selectChar = true;
					break;
					} else if (choice == 1){
						continuePlaying = true;
					} else if (choice == 2) {
						continuePlaying = false;
						finish = true;
						break;
					}
					heroWon = false;}
				} else {
					draw = false;
					heroWon = false;
					continuePlaying = true;
				}
			}
		}
		
		
	}
	
	
	
	
	
	
	public static void playGame(Team team, Villian vill) {
		paperScissorsRock game = new paperScissorsRock();
		thisTeam = team;
		thisVillian = vill;
		System.out.println("Villian Taunts: " + thisVillian.getTaunt());
		game.gameSequence();
		System.out.println("The game ended");
		/*paperScissorsRock game = new paperScissorsRock();
		while (finish == false) {
		game.printOptions();
		int heroChoice = game.getHeroChoice();
		System.out.println("You have chosen " + options[heroChoice]);
		int villianChoice = ThreadLocalRandom.current().nextInt(0, 3);
		System.out.println("The Villian has chosen " + options[villianChoice]);
		String outcome = options[heroChoice] + options[villianChoice];
		game.getOutCome(outcome);
		}*/
	}
	
	public static void main(String[] args) {
		/*paperScissorsRock game = new paperScissorsRock();
		while (finish == false) {
		game.printOptions();
		int heroChoice = game.getHeroChoice();
		System.out.println("You have chosen " + options[heroChoice]);
		int villianChoice = ThreadLocalRandom.current().nextInt(0, 3);
		System.out.println("The Villian has chosen " + options[villianChoice]);
		String outcome = options[heroChoice] + options[villianChoice];
		game.getOutCome(outcome);
		}*/
		//System.out.println(outcome);
		
	}

}
