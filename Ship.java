import java.util.ArrayList;
import java.util.HashMap;

public abstract class Ship{
    private String shipClass;
    private ShipType type;
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
    private int maxTroops;
    private int currentTroops;
    private int price;
    private HashMap<Integer, ArrayList<String>> priority;
    private ArrayList<Troop> troops;

    public Ship(String shipClass, int hull, int shields, int maneuverability, int maxTroops, String[] newWeapons){
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
        this.maxTroops = maxTroops;
        if(this instanceof CapitalShip){
            currentTroops = maxTroops;
        }else{
            currentTroops = 0;
        }
        addWeapons(newWeapons);
        troops = new ArrayList<>();
    }

    public void fire(int counter){
        for(int l = 0; l < weapons.size(); l++){
            if(weapons.get(l).getDisabled()){
                if(Randomizer.getRgen(101) <= 20){
                    weapons.get(l).setDisabled(false);
                }
            }else if(counter % (weapons.get(l).getFirerate()) == 0 && weapons.get(l).hit() && target.isHit() && !(weapons.get(l).getDisabled())){
                if(target.damagedShields - target.shieldDamage > 0){
                    target.shieldDamage = target.shieldDamage + weapons.get(l).getDamageshields();
                }else{
                    target.hullDamage = target.hullDamage + weapons.get(l).getDamagehull();
                }
                if(weapons.get(l).getType().contains("Ion")){
                    target.disabledWeapons();
                }
            }
        }
    }

    public boolean isHit(){
        int hit = 1 + Randomizer.getRgen(100);

        if(hit <= maneuverability){
            return true;
        }
        return false;
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
            if(
            checkTarget(3, f, newTarget)){
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
            for(ShipType s : type.getPriority()[0]){
                if(f.get(newTarget).getType() == s){
                    return true;
                }
            }
        }
        if(check == 2){
            for(ShipType s : type.getPriority()[0]){
                if(f.get(newTarget).getType() == s){
                    return true;
                }
            }
            for(ShipType s : type.getPriority()[1]){
                if(f.get(newTarget).getType() == s){
                    return true;
                }
            }
        }
        if(check == 3){
            for(ShipType s : type.getPriority()[0]){
                if(f.get(newTarget).getType() == s){
                    return true;
                }
            }
            for(ShipType s : type.getPriority()[1]){
                if(f.get(newTarget).getType() == s){
                    return true;
                }
            }
            for(ShipType s : type.getPriority()[2]){
                if(f.get(newTarget).getType() == s){
                    return true;
                }
            }
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

    public void setType(ShipType newType){
        type = newType;
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

    public ShipType getType(){
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

    public int getShuttles(){
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

    public int getMaxTroops(){
        return maxTroops;
    }

    public int getCurrentTroops(){
        return currentTroops;
    }

    public void setTroops(int t){
        currentTroops = t;
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

    public void disabledWeapons(){
        for(Weapon w : weapons){
            if(Randomizer.getRgen(101) <= 5){
                w.setDisabled(true);
            }
        }
    }

    public boolean canLand(int counter){
        if(type == ShipType.SHUTTLE && currentTroops > 0 && counter % 16 >= 0 && counter % 16 < 8){
            return true;
        }else if(type == ShipType.FREIGHTER && currentTroops > 0 && counter >= 8 && Randomizer.getRgen(100) < 8){
            return true;
        }else if(this instanceof CapitalShip && type == ShipType.TRANSPORT && currentTroops > 0 &&((CapitalShip) this).getShuttles() == 0 && counter >= 10 && Randomizer.getRgen(100) < 14){
            return true;
        }else if(type == ShipType.PATROL && currentTroops > 0 && counter >= 7 && Randomizer.getRgen(100) < 10){
            return true;
        }else{
            return false;
        }
    }

    public int landTroops(int counter){
        if(canLand(counter)){
            int landing = currentTroops;
            currentTroops = 0;
            return landing;
        }else{
            return 0;
        }
    }

    public Ship canTake(int counter,ArrayList<Ship> f){
        if(type == ShipType.SHUTTLE && counter % 16 == 8 && currentTroops == 0){
            int take;
            for(int i = 0; i < 20; i++){
                take = Randomizer.getRgen(f.size());
                Ship s = f.get(take);
                if(!(s instanceof StarFighter) && s.getType() != ShipType.FREIGHTER && s.getType() != ShipType.PATROL && s.getCurrentTroops() > 0){
                    if(s.getType() == ShipType.TRANSPORT && s instanceof CapitalShip && ((CapitalShip) s).getShuttles() == 0){
                        continue;
                    }else{
                        return s;
                    }
                }
            }
        }
        return null;
    }

    public void takeTroops(int counter,ArrayList<Ship> f){
        Ship take = canTake(counter,f);
        if(take != null){
            int available = take.getCurrentTroops();
            if(available >= maxTroops){
                take.setTroops(available - maxTroops);
                currentTroops = maxTroops;
            }else{
                take.setTroops(0);
                currentTroops = available;
            }
        }
    }
}