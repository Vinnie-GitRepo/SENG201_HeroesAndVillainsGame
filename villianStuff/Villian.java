package villianStuff;

import javax.swing.ImageIcon;

public class Villian {
	public String name;
	public int lossCount = 0;
	public int damageAmmount = 25;
	public boolean defeated = false;
	public String battleCry;
	public int timesToBeat = 3;
	public boolean favGame;
	public ImageIcon icon;
	public boolean changesGame;
	
	public Villian(String Name, String BattleCry, boolean Fav, ImageIcon image, boolean change) {
		name = Name;
		battleCry = BattleCry;
		favGame = Fav;
		icon = image;
		changesGame = change;
	}
	
	public int getTimesToBeat() {
		return timesToBeat;
	}
	
	public int getDamageAmmount() {
		return damageAmmount;
	}
	
	public void superVillian() {
//		lossCount = -2;
		timesToBeat = 5;
		damageAmmount = 50;
	}
	public ImageIcon getIcon() {
		return icon;
	}
	
	public boolean changesTheGame() {
		return changesGame;
	}
	
	public boolean hasFavGame() {
		return favGame;
	}
	public void oneDefeat() {
		lossCount += 1;
	}
	public String getName() {
		return name;
	}
	
	public int getLossCount(){
		return lossCount;
	}
	public String getTaunt() {
		return battleCry;
	}
	public void lastDefeat() {
		defeated = true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}