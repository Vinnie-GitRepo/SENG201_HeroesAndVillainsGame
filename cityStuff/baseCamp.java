package cityStuff;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import teamStuff.*;
import villianStuff.*;



/**
 * 
 * @author cwe55, vjj14
 *
 */
public class baseCamp extends gameEnvironmentGuiRunTime {

	
	/**
	 * Stores the team's state of location discovery for a city.
	 * Resets to false when entering a new city.
	 */
	public static ArrayList<Boolean> foundPlace = new ArrayList<Boolean>() 
		{{
		add(false);
		add(false);
		add(false);
		add(false);
		}};
	
	
	
	/**
	 * A list of areas that are set according to a map made through random numbers. 
	 */
	public ArrayList<String> areas = new ArrayList<String>();
	
	
	
	/**
	 * 
	 * @return
	 */
	public ArrayList<String> getMap(){
		return areas;
	}
	
	
	
	//final intializer
	/**
	 * This sets up the city with the map/layout which has been generated in the game environment
	 * 
	 * @param map
	 */
	public baseCamp(ArrayList map) {
		areas = map;
	}
	

}
