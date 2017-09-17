public class Weapon{
    private String type;
    private int damageshields;
    private int damagehull;
    private int accuracy;
    private int firerate;
    private int price;

    public Weapon(String[] stats){
        type = stats[0];
        damageshields = Integer.parseInt(stats[1]);
        damagehull = Integer.parseInt(stats[2]);
        firerate = Integer.parseInt(stats[3]);
        accuracy = Integer.parseInt(stats[4]);
        price = damageshields * 10 /firerate * accuracy;
    }

    public boolean hit(){
        int hit = 1 + Randomizer.getRgen(100);

        if(hit <= accuracy){
            return true;
        }
        return false;
    }
    
    public int getPrice(){
        return price;
    }
    
    public int getFirerate(){
        return firerate;
    }
    
    public int getDamageshields(){
        return damageshields;
    }
    
    public int getDamagehull(){
        return damagehull;
    }
    
    public String getType(){
        return type;
    }
    
    public int getAccuracy(){
        return accuracy;
    }
}