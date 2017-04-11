import java.util.ArrayList;
import java.util.HashMap;

public class Bomber extends StarFighter{

    public Bomber(String[] stats, String[] newWeapons){
        super(stats[0], Integer.parseInt(stats[1]), Integer.parseInt(stats[2]), Integer.parseInt(stats[3]), newWeapons);
        super.setType("Bomber");
        
        HashMap<Integer, ArrayList<String>> priorities = new HashMap<Integer, ArrayList<String>>();
        ArrayList<String> prior1 = new ArrayList<>();
        ArrayList<String> prior2 = new ArrayList<>();
        ArrayList<String> prior3 = new ArrayList<>();
        prior1.add("Dreadnought");
        prior1.add("Carrier");
        prior1.add("Battleship");
        prior2.add("Heavy Cruiser");
        prior2.add("Light Crusier");
        prior3.add("Frigate");
        prior3.add("Gunship");
        priorities.put(1, prior1);
        priorities.put(2, prior2);
        priorities.put(3, prior3);
        super.setPriorities(priorities);
    }

}
