package villianStuff;

import javax.swing.ImageIcon;


/**
 * The class for the villains in the game, who must be defeated to progress to the next city or finish the game.<br>
 * The villains will have their primary attributes (those in the constructor) determined randomly within gameEnvironmentGuiRunTime.
 * 
 * @author cwe55, vjj14
 */
public class Villian {
	
	
	/**
	 * The Name of the villain set in the villain generator inside gameEnvGui
	 */
	public String name;
	
	
	/**
	 * Stores the number of times the villain has lost.<br>
	 * Increments after losses and is used to determine whether the villain has been defeated.
	 */
	public int lossCount = 0;
	
	
	/**
	 * The amount of damage the victorious villain deals to the battling hero.
	 */
	public int damageAmmount = 25;
	
	
	/**
	 * Determine's the villain's state of existence.<br>
	 * False means the villain is alive and well. True means the villain is defeated and the team can move on.
	 */
	public boolean defeated = false;
	
	
	/**
	 * The villain's unique taunt/catchphrase, said by the villain upon entering their lair.
	 */
	public String battleCry;
	
	
	/**
	 * The number of times the villain must lost a game to be defeated by the team.<br>
	 * This value is initialized to 3 for normal villains, and set to 5 for the final super villain.
	 */
	public int timesToBeat = 3;
	
	
	/**
	 * An attibute determining whether the team has a choice in what game will be played.
	 */
	public boolean favGame;
	
	
	/**
	 * The GUI representation of the villain shown in the lair. 
	 */
	public ImageIcon icon;
	
	
	/**
	 * Determines whether the villain will change the game after a battle.
	 */
	public boolean changesGame;
	
	
	/**
	 * <<Constructor>> for the Villain Class
	 * 
	 * @param Name String
	 * @param BattleCry String
	 * @param Fav boolean
	 * @param image ImageIcon
	 * @param change boolean
	 */
	public Villian(String Name, String BattleCry, boolean Fav, ImageIcon image, boolean change) {
		name = Name;
		battleCry = BattleCry;
		favGame = Fav;
		icon = image;
		changesGame = change;
	}
	
	
	
	/**
	 * Returns how many times the villain needs to be be beaten to be defeated.
	 * @return timesToBeat int
	 */
	public int getTimesToBeat() {
		return timesToBeat;
	}
	
	
	
	/**
	 * Used to calculate damage dealt to heroes upon losing a game.
	 * @return damageAmmount int
	 */
	public int getDamageAmmount() {
		return damageAmmount;
	}
	
	

	/**
	 * The villain at the last city will become the super villain.<br>
	 * The last villain must lose five games to be defeated, and deals twice as much damage compared to lesser villains.
	 */
	public void superVillian() {
		timesToBeat = 5;
		damageAmmount = 50;
	}
	
	
	
	/**
	 * For displating the villain's icon in the GUI.
	 * @return icon ImageIcon
	 */
	public ImageIcon getIcon() {
		return icon;
	}
	
	
	
	/**
	 * Determines whether the villain will change the battle game after playing
	 * @return changesGame
	 */
	public boolean changesTheGame() {
		return changesGame;
	}
	
	
	
	/**
	 * Determines whether the team can choose a battle game or not.
	 * @return favGame
	 */
	public boolean hasFavGame() {
		return favGame;
	}
	
	
	
	/**
	 * Increments the villain's lossCount int value by one after each loss. 
	 */
	public void oneDefeat() {
		lossCount += 1;
	}
	
	
	
	/**
	 * @return name String
	 */
	public String getName() {
		return name;
	}
	
	
	
	/**
	 * @return lossCount int
	 */
	public int getLossCount(){
		return lossCount;
	}
	
	
	
	/**
	 * @return battleCry String 
	 */
	public String getTaunt() {
		return battleCry;
	}
	
	
	
	/**
	 * Is called once the villain has lost 
	 */
	public void lastDefeat() {
		defeated = true;
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}