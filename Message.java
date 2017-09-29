
public class Message{
   
    private int code;
    private Ship defender;
    private Ship attacker;
    private int troops;
    
    public Message(int code, Ship defender, Ship attacker, int troops){
       this.code = code;
       this.defender = defender;
       this.attacker = attacker;
       this.troops = troops;
    }
    
    public int getCode(){
        return code;
    }
    
    public Ship getDefender(){
        return defender;
    }
    
    public Ship getAttacker(){
        return attacker;
    }
    
    public int getTroops(){
        return troops;
    }

}
