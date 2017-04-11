import java.util.ArrayList;
import java.util.HashMap;
public abstract class CapitalShip extends Ship{

    private int hangar;

    public CapitalShip(String shipClass, int hull, int shields, int hangar, int maneuverability, String[] newWeapons)
    {
        super(shipClass, hull, shields, maneuverability, newWeapons);
        this.hangar = hangar;
        super.setPrice(getPrice());
    }
    
    public int getPrice(){
        int amount = (super.getHull() * 100) + (super.getShields() * 150);
            amount = amount + (hangar * 50000);
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
    
    public int getHangar(){
        return hangar;
    }
}
