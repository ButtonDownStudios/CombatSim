import java.util.ArrayList;
import java.util.HashMap;
public class CapitalShip extends Ship{

    private int hangar;

    public CapitalShip(ShipType shipType, String[] stats, String[] newWeapons){
        super(stats[0], Integer.parseInt(stats[1]), Integer.parseInt(stats[2]), Integer.parseInt(stats[4]), newWeapons);
        super.setType(shipType);
        hangar = Integer.parseInt(stats[3]);
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
    
    public int getHangar(){
        return hangar;
    }
}
