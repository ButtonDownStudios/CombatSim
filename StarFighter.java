import java.util.ArrayList;
import java.util.HashMap;
public abstract class StarFighter extends Ship{

    public StarFighter(String shipClass, int hull, int shields, int maneuverability, String[] newWeapons)
    {
        super(shipClass, hull, shields, maneuverability, newWeapons);
        super.setPrice(getPrice());
    }
    
    public int getPrice(){
        int amount = (super.getHull() * 100) + (super.getShields() * 150);
        for(int i = 0; i < super.getWeapons().size(); i++){
            amount = amount + super.getWeapons().get(i).getPrice();
        }
        return amount;
    }
    
    public void setType(String newType){
        super.setType(newType);
    }
    
    public void setPriorities(HashMap<Integer, ArrayList<String>> priority){
        super.setPriorities(priority);
    }
}
