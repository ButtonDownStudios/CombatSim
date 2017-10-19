public class TroopWeapon{

    private double damage;
    private double accuracy;
    private double fireRate;
    private double price;

    public TroopWeapon(String[] stats){
        damage = Double.parseDouble(stats[1]);
        accuracy = Double.parseDouble(stats[2]);
        fireRate = Double.parseDouble(stats[3]);
        price = damage * 20 / fireRate * accuracy;
    }

    public double getDamage(){
        return damage;
    }

    public double getAccuracy(){
        return accuracy;
    }

    public double getFireRate(){
        return fireRate;
    }

    public double getPrice(){
        return price;
    }
}