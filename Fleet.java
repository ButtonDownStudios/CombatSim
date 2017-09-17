import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Iterator;
import java.util.Random;

public class Fleet{
    private ArrayList<ArrayList<Ship>> fleet;
    private String[] shipType;
    private ArrayList<int[]> damageCount;
    private ArrayList<Ship> shipTypeExample;
    private ArrayList<Ship> shipTypeHolder;
    private int holdCount;
    private static long creditLimit;
    private ArrayList<Message> messages;

    public Fleet(long credits, ArrayList<Ship> shipTypeExample){
        fleet = new ArrayList<ArrayList<Ship>>();
        shipTypeHolder = new ArrayList<Ship>();
        this.shipTypeExample = shipTypeExample;
        holdCount = 0;
        creditLimit = credits;

        for(int i = 0; i <= 5; i++){
            fleet.add(new ArrayList<Ship>());
        }
    }   

    public void collectFleetStats(){ 
        shipType= new String[holdCount];
        damageCount= new ArrayList<int[]>();

        for(int i = 0; i < holdCount; i++){
            shipType[i] = shipTypeHolder.get(i).getShipClass();
        }

        for(int i = 0; i < holdCount; i++){
            damageCount.add(new int[5]);
        }

        for(int i = 0; i < holdCount; i++){
            for(int j = 0; j <= 4; j++){
                damageCount.get(i)[j] = 0;
            }
        }

        for(int i = 0; i < holdCount; i++){
            for(int j = 0; j <= 4; j++){
                for(int k = 0; k < fleet.get(j).size(); k++){
                    if(shipType[i].equals(fleet.get(j).get(k).getShipClass())){
                        damageCount.get(i)[j]++;
                    }
                }
            }
        }
    }

    public void countInitial(){
        for(int i = 0; i < shipTypeExample.size(); i++){
            for(int j = 0; j < fleet.get(0).size(); j++){
                if(shipTypeExample.get(i).getShipClass().equals(fleet.get(0).get(j).getShipClass())){
                    holdCount++;
                    shipTypeHolder.add(fleet.get(0).get(j));
                    break;
                }
            }  
        }
    }

    public void combat(ArrayList<Ship> f, int counter){
        messages = new ArrayList<>();
        Iterator<Ship> it1 = fleet.get(0).iterator();
        while(it1.hasNext()){
            Ship s = it1.next();
            if(counter > 1){
                s.shieldRegen();             
                if(s.getIsTarget()){
                    s.takeDamage();
                    if(s.getDamagedHull() < (s.getHull() / 2)){
                        if(s.getDamagedHull() < (s.getHull() / 4)){
                            if(s.getDamagedHull() < (s.getHull() / 10)){
                                if(s.getDamagedHull() <= 0){
                                    fleet.get(4).add(s);
                                    messages.add(new Message(4,s,s.getTargetedBy()));
                                    s.getTargetedBy().setHasTarget(false);
                                    s.setIsTarget(false);
                                    it1.remove();
                                    continue;
                                }else{                                          
                                    int retreat = 1+Randomizer.getRgen(100);
                                    if(retreat > 10){
                                        fleet.get(3).add(s);
                                        messages.add(new Message(3,s,s.getTargetedBy()));
                                        s.getTargetedBy().setHasTarget(false);
                                        s.setIsTarget(false);
                                        it1.remove();
                                        continue;
                                    }
                                }
                            }else{                                            
                                int retreat = 1+Randomizer.getRgen(100);
                                if( retreat > 25){
                                    fleet.get(2).add(s);
                                    messages.add(new Message(2,s,s.getTargetedBy()));
                                    s.getTargetedBy().setHasTarget(false);
                                    s.setIsTarget(false);
                                    it1.remove();
                                    continue;
                                }
                            }
                        }else{                                     
                            int retreat = 1+Randomizer.getRgen(100);
                            if( retreat > 50){
                                fleet.get(1).add(s);
                                messages.add(new Message(1,s,s.getTargetedBy()));
                                s.getTargetedBy().setHasTarget(false);
                                s.setIsTarget(false);
                                it1.remove();
                                continue;
                            }
                        }
                    }
                }
            }
            if(f.isEmpty() || fleet.get(0).isEmpty()){
                break;
            }
            if(!s.getHasTarget() || !s.getTarget().getIsTarget()){
                s.findTarget(f);
            }
            s.fire(counter);
            s.retaliate();
        } 
    }

    public void repair(){
        for(int i = 1; i <=3; i++){
            Iterator<Ship> it1 = fleet.get(i).iterator();
            while(it1.hasNext()){
                Ship s = it1.next();
                s.repair();
                if(s.getDamagedHull() == s.getHull()){
                    fleet.get(0).add(s);
                    messages.add(new Message(5,s,null));
                    it1.remove();
                }else if(s.getDamagedHull() >= s.getHull() * .75){
                    int random = Randomizer.getRgen(101);
                    if(random >= 50){
                        fleet.get(0).add(s);
                        messages.add(new Message(5,s,null));
                        it1.remove();
                    }
                }
            }
        }
    }

    public static long getCreditLimit(){
        return creditLimit;
    }

    public void addShip(Ship s){
        fleet.get(0).add(s);
    }

    public ArrayList<ArrayList<Ship>> getFleet(){
        return fleet;
    }
    
    public String[] getShipType(){
        return shipType;
    }
    
    public ArrayList<int[]> getDamageCount(){
        return damageCount;
    }
    
    public ArrayList<Message> getMessages(){
        return messages;
    }
    
    public int getholdCount(){
        return holdCount;
    }
}