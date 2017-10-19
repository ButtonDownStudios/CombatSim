public class TroopArmor{
  
    private double armor;
    private double accuracy;
    private double dodge;
    private double price;
    
    public TroopArmor(String[] stats){
       armor = Double.parseDouble(stats[1]);
       accuracy = Double.parseDouble(stats[2]);
       dodge = Double.parseDouble(stats[3]);
       price = armor * 20 / dodge;
       if(accuracy > 0){
           price *= accuracy;
        }
    }
    
    public double getArmor(){
        return armor;
    }
    
    public double getAccuracy(){
        return accuracy;
    }
    
    public double getDodge(){
        return dodge;
    }
    
    public double getPrice(){
        return price;
    }
}