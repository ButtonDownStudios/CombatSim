import java.util.ArrayList;
import java.util.HashMap;

public class LightCruiser extends CapitalShip{

    public LightCruiser(String[] stats, String[] newWeapons){
        super(stats[0], Integer.parseInt(stats[1]), Integer.parseInt(stats[2]), Integer.parseInt(stats[3]), Integer.parseInt(stats[4]), newWeapons);
        super.setType("Light Cruiser");
        
        HashMap<Integer, ArrayList<String>> priorities = new HashMap<Integer, ArrayList<String>>();
        ArrayList<String> prior1 = new ArrayList<>();
        ArrayList<String> prior2 = new ArrayList<>();
        ArrayList<String> prior3 = new ArrayList<>();
        prior1.add("Light Cruiser");
        prior1.add("Frigate");
        prior1.add("Heavy Cruiser");
        prior2.add("Carrier");
        prior2.add("Battleship");
        prior2.add("Gunship");
        prior3.add("Bomber");
        prior3.add("Light Fighter");
        prior3.add("Heavy Fighter");
        priorities.put(1, prior1);
        priorities.put(2, prior2);
        priorities.put(3, prior3);
        super.setPriorities(priorities);
    }

}