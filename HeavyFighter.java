import java.util.ArrayList;
import java.util.HashMap;

public class HeavyFighter extends StarFighter{

    public HeavyFighter(String[] stats, String[] newWeapons){
        super(stats[0], Integer.parseInt(stats[1]), Integer.parseInt(stats[2]), Integer.parseInt(stats[3]), newWeapons);
        super.setType("Heavy Fighter");
        
        HashMap<Integer, ArrayList<String>> priorities = new HashMap<Integer, ArrayList<String>>();
        ArrayList<String> prior1 = new ArrayList<>();
        ArrayList<String> prior2 = new ArrayList<>();
        ArrayList<String> prior3 = new ArrayList<>();
        prior1.add("Light Fighter");
        prior1.add("Bomber");
        prior1.add("Heavy Fighter");
        prior2.add("Interceptor");
        prior2.add("Gunship");
        prior2.add("Frigate");
        prior3.add("Battleship");
        prior3.add("Light Cruiser");
        prior3.add("Heavy Cruiser");
        priorities.put(1, prior1);
        priorities.put(2, prior2);
        priorities.put(3, prior3);
        super.setPriorities(priorities);
    }

}
