import java.util.ArrayList;
import java.util.HashMap;

public class GunShip extends CapitalShip{

    public GunShip(String[] stats, String[] newWeapons){
        super(stats[0], Integer.parseInt(stats[1]), Integer.parseInt(stats[2]), Integer.parseInt(stats[3]), Integer.parseInt(stats[4]), newWeapons);
        super.setType("Gunship");
        
        HashMap<Integer, ArrayList<String>> priorities = new HashMap<Integer, ArrayList<String>>();
        ArrayList<String> prior1 = new ArrayList<>();
        ArrayList<String> prior2 = new ArrayList<>();
        ArrayList<String> prior3 = new ArrayList<>();
        prior1.add("Frigate");
        prior1.add("Gunship");
        prior1.add("Light Cruiser");
        prior2.add("Bomber");
        prior2.add("Heavy Fighter");
        prior2.add("Heavy Cruiser");
        prior3.add("Interceptor");
        prior3.add("Light Fighter");
        priorities.put(1, prior1);
        priorities.put(2, prior2);
        priorities.put(3, prior3);
        super.setPriorities(priorities);
    }

}