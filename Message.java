
public class Message{
   
    private int code;
    private Ship defender;
    private Ship attacker;
    
    public Message(int code, Ship defender, Ship attacker){
       this.code = code;
       this.defender = defender;
       this.attacker = attacker;
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

}
