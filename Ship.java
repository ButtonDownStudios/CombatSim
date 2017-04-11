import java.util.ArrayList;
import java.util.HashMap;

public abstract class Ship{
    private String shipClass;
    private String type;
    private int hull;
    private double damagedHull;
    private int shields;
    private double damagedShields;
    private ArrayList<Weapon> weapons;
    private boolean isTarget;
    private boolean hasTarget;
    private int shieldDamage;
    private int hullDamage;
    private Ship target;
    private Ship targetedBy;
    private int maneuverability;
    private int price;
    private HashMap<Integer, ArrayList<String>> priority;

    public Ship(String shipClass, int hull, int shields, int maneuverability, String[] newWeapons){
        this.shipClass = shipClass;
        this.hull = hull;
        this.shields = shields;
        damagedHull = hull;
        damagedShields = shields;
        shieldDamage = 0;
        hullDamage = 0;
        hasTarget = false;
        isTarget = false;
        this.maneuverability = maneuverability;
        addWeapons(newWeapons);
    }

    public void fire(int counter){
        for(int l = 0; l < weapons.size(); l++){
            if(counter % (weapons.get(l).getFirerate()) == 0 && weapons.get(l).hit() && target.isHit()){
                if(target.damagedShields - target.shieldDamage > 0){
                    target.shieldDamage = target.shieldDamage + weapons.get(l).getDamageshields();
                }else{
                    target.hullDamage = target.hullDamage + weapons.get(l).getDamagehull();
                }
            }
        }
    }

    public boolean isHit(){
        int hit = 1 + Randomizer.getRgen(100);

        boolean didHit;
        if(hit <= maneuverability){
            didHit = true;
        }else{
            didHit = false;
        }
        return didHit;
    }

    public void shieldRegen(){
        if(damagedShields < shields){
            if(shields - damagedShields <= (shields) / 50){
                damagedShields = shields;
            }else{
                damagedShields = damagedShields + (shields / 50);
            }  
        }
    }

    public void takeDamage(){
        damagedShields = damagedShields - shieldDamage;
        shieldDamage = 0;
        if(damagedShields < 0){
            damagedShields = 0;
        }
        damagedHull = damagedHull - hullDamage;
        hullDamage = 0;
    }

    public void findTarget(ArrayList<Ship> f){
        int newTarget = Randomizer.getRgen(f.size());
        for(int i = 1; i <=7; i++){
            if(checkTarget(1, f, newTarget)){
                setTarget(f, newTarget);
                return;
            }else{
                newTarget = Randomizer.getRgen(f.size());
            }
        }
        for(int i = 1; i <=5; i++){
            if(checkTarget(2, f, newTarget)){
                setTarget(f, newTarget);
                return;
            }
            newTarget = Randomizer.getRgen(f.size());
        }
        for(int i = 1; i <= 3; i++){
            if(checkTarget(3, f, newTarget)){
                setTarget(f, newTarget);
                return;
            }else{
                newTarget = Randomizer.getRgen(f.size());
            }
        }
        setTarget(f, newTarget);
    }

    public boolean checkTarget(int check, ArrayList<Ship> f, int newTarget){
        if(check == 1){
            for(String s : priority.get(1)){
                if(f.get(newTarget).getType().equals(s)){
                    return true;
                }
            }
            return false;
        }
        if(check == 2){
            for(String s : priority.get(1)){
                if(f.get(newTarget).getType().equals(s)){
                    return true;
                }
            }
            for(String s : priority.get(2)){
                if(f.get(newTarget).getType().equals(s)){
                    return true;
                }
            }
            return false;
        }
        if(check == 3){
            for(String s : priority.get(1)){
                if(f.get(newTarget).getType().equals(s)){
                    return true;
                }
            }
            for(String s : priority.get(2)){
                if(f.get(newTarget).getType().equals(s)){
                    return true;
                }
            }
            for(String s : priority.get(3)){
                if(f.get(newTarget).getType().equals(s)){
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public void setTarget(ArrayList<Ship> f, int newTarget){
        target = f.get(newTarget);
        f.get(newTarget).isTarget = true;
        f.get(newTarget).targetedBy = this;
        hasTarget = true;
    }

    public void setTarget(){
        target = targetedBy;
        target.isTarget = true;
        target.targetedBy = this;
        hasTarget = true;
    }

    public void retaliate(){
        if(isTarget && Randomizer.getRgen(101) < 30){
            setTarget();
        }
    }  

    public void addWeapons(String[] newWeapons){
        weapons = new ArrayList<>();
        for(int i = 1; i < newWeapons.length - 1; i += 2){
            int amount = Integer.parseInt(newWeapons[i]);
            for(int j = 0; j < amount; j++){
                weapons.add(WeaponFactory.makeWeapon(newWeapons[i+1]));
            }
        }
    }

    public void setPrice(int newPrice){
        price = newPrice;
    }

    public void setType(String newType){
        type = newType;
    }

    public void setPriorities(HashMap<Integer, ArrayList<String>> priority){
        this.priority = priority;
    }

    public int getHull(){
        return hull;
    }

    public int getShields(){
        return shields;
    }

    public ArrayList<Weapon> getWeapons(){
        return weapons;
    }

    public String getType(){
        return type;
    }

    public String getShipClass(){
        return shipClass;
    }

    public Ship getTargetedBy(){
        return targetedBy;
    }

    public int getPrice(){
        return price;
    }

    public int getHangar(){
        return -1;
    }

    public boolean getIsTarget(){
        return isTarget;
    }

    public boolean getHasTarget(){
        return hasTarget;
    }

    public double getDamagedHull(){
        return damagedHull;
    }

    public double getDamagedShields(){
        return damagedShields;
    }

    public void setHasTarget(boolean answer){
        hasTarget = answer;
    }

    public void setIsTarget(boolean answer){
        isTarget = answer;
    }

    public Ship getTarget(){
        return target;
    }
    
    public void repair(){
        if(damagedShields < shields){
            if(shields - damagedShields <= (shields) / 20){
                damagedShields = shields;
            }else{
                damagedShields = damagedShields + (shields / 20);
            }  
        }
        if(damagedHull < hull){
            if(hull - damagedHull <= (hull) / 40){
                damagedHull = hull;
            }else{
                damagedHull = damagedHull + (hull / 40);
            }  
        }
    }
}
