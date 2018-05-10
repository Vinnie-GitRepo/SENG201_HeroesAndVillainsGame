package cityStuff;
import java.util.*;
import games.*;
import teamStuff.*;
import villianStuff.*;

public class lair extends baseCamp {
	public Team thisTeam;
	public Villian thisVillian;
	/**
	 * Shows the menu of for within the lair
	 * uses a switch to choose what happens
	 * 
	 */
	public void viewMenu() {
		
		System.out.println("Menu Options");
		System.out.println("0: Battle Villain");
		System.out.println("1: Woose Out");
		
		int selection = this.getPlayerChoice();
		
		switch(selection) {
		case 0 :
			this.displayBattleScreen();
			break;
		case 1 :
			this.exit();
			break;
		case 3 :
			super.endGame();//AGAIN HIDDEN FOR TESTING
			break;
		default:
			System.out.println("Please input a valid choice");
			this.viewMenu();
			break;
		}
	}
	
	/**
	 * Sets the Villian for within this lair
	 * this is called within the the basecamp initializer
	 * 
	 * @param vill
	 */
	public void setVillian(Villian vill) {
		thisVillian = vill;
	}
	
	
	/**
	 * Sets the team to the lair allowing for stats to change
	 * this is called within the the basecamp initializer
	 * 
	 * @param team
	 */
	public void setTeam(Team team) {
		thisTeam = team;
	}
	
	//The beggining of the whole battle section
	
	/**
	 * Show a menu of game options
	 * then uses a switch to choose which game is played and passes the team and villian into it
	 * 
	 */
	public void displayBattleScreen() {

		System.out.println("Select A Game");
		System.out.println("(0) Number Guess\n(1) Dice Rolling Game\n(2) Paper Scissors Rock");
		
		int choice = super.getPlayerChoice();
		
		switch(choice) {
		case 0 :
			games.numberGuess.playGame(thisTeam, thisVillian);
			break;
		case 1 :
			games.diceRollGame.playGame(thisTeam, thisVillian);
			break;
		case 2 :
			games.paperScissorsRock.playGame(thisTeam, thisVillian);
		}
		//this.exit();
	}
	
	
	/**
	 * Used if user decides they do not wish to battle the villian
	 * 
	 *
	 */
	public void exit() {
		System.out.println("Heading Back To The Base Camp");
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
