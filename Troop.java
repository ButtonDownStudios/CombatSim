import java.util.ArrayList;

public class Troop{

    private TroopWeapon weapon;
    private TroopArmor armor;
    private double health;
    private Troop target;
    private Troop targetedBy;
    private boolean isTarget;
    private boolean hasTarget;
    private double damage;
    private double price;

    public Troop(String tWeapon, String tArmor){
        health = 100;
        setArmor(tArmor);
        setWeapon(tWeapon);
        hasTarget = false;
        isTarget = false;
        damage = 0;
        price = 5000 + armor.getPrice() + weapon.getPrice();
    }

    public double getHealth(){
        return health;
    }

    public void setArmor(String tArmor){
        armor = TroopFactory.makeArmor(tArmor);
    }

    public void setWeapon(String tWeapon){
        weapon = TroopFactory.makeWeapon(tWeapon);
    }

    public void setTarget(ArrayList<Troop> f){
        if(f.size() > 0){
            int newTarget = Randomizer.getRgen(f.size());
            target = f.get(newTarget);
            f.get(newTarget).isTarget = true;
            f.get(newTarget).targetedBy = this;
            hasTarget = true;
        }
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

    public boolean isHit(){
        int hit = 1 + Randomizer.getRgen(100);
        if(hit <= 100 - armor.getDodge()){
            return true;
        }
        return false;
    }

    public void fire(int counter){
        if(counter % (weapon.getFireRate()) == 0 && hit() && target.isHit()){
            target.setDamage(weapon.getDamage());
        }
    }

    public boolean hit(){
        int hit = Randomizer.getRgen(101);
        double help = armor.getAccuracy() + weapon.getAccuracy();
        if(hit <= help){
            return true;
        }
        return false;
    }

    public void setDamage(double inc){
        damage = inc / 100 * armor.getArmor();
    }

    public void takeDamage(){
        health -= damage;
        damage = 0;
    }

    public double getPrice(){
        return price;
    }
}