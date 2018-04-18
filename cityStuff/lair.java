package cityStuff;
import java.util.*;
import games.*;

public class lair extends baseCamp {

	
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
	
	
	//The beggining of the whole battle section
	public void displayBattleScreen() {

		System.out.println("Select A Game");
		System.out.println("(0) Number Guess\n(1) Dice Rolling Game\n(2) Paper Scissors Rock");
		
		int choice = super.getPlayerChoice();
		
		switch(choice) {
		case 0 :
			games.numberGuess.playGame(super.getTeam());
			break;
		case 1 :
			games.diceRollGame.playGame(super.getTeam());
			break;
		case 2 :
			games.paperScissorsRock.playGame();
		}
		//this.exit();
	}
	
	
	
	public void exit() {
		System.out.println("Heading Back To The Base Camp");
		super.viewMenu();
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
