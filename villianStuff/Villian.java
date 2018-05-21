package villianStuff;

public class Villian {
	public String name;
	public int lossCount = 0;
	public boolean defeated = false;
	public String battleCry;
	public boolean favGame;
	
	public Villian(String Name, String BattleCry, boolean Fav) {
		name = Name;
		battleCry = BattleCry;
		favGame = Fav;
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