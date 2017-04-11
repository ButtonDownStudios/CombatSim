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
    private static int creditLimit;
    private ArrayList<Message> messages;

    public Fleet(int credits, ArrayList<Ship> shipTypeExample){

        fleet = new ArrayList<ArrayList<Ship>>();
        shipTypeHolder = new ArrayList<Ship>();
        this.shipTypeExample = shipTypeExample;
        holdCount = 0;
        creditLimit = credits;

        for(int i = 0; i <= 5; i++){
            fleet.add(new ArrayList<Ship>());
        }

        //Building Fleet 1
        /** System.out.println("You have " + creditLimit + " credits remaining");
        for(int i = 0; i < 95; i++){
        System.out.println("Enter number of " + shipTypeExample.get(i).getShipClass() + "s for Fleet");
        System.out.println("Price: " + shipTypeExample.get(i).getPrice());
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        for(int j = 1; j <= a; j++){
        if(creditLimit - shipTypeExample.get(i).getPrice() < 0){
        break;
        }
        fleet.get(0).add(ShipFactory.makeShip(shipTypeExample.get(i).getType(),shipTypeExample.get(i).getShipClass()));
        creditLimit = creditLimit - shipTypeExample.get(i).getPrice();
        }
        System.out.println("You have " + creditLimit + " credits remaining");
        }

        int numFighters = 0;
        for(int i = 0; i < fleet.get(0).size(); i++){
        numFighters = numFighters + fleet.get(0).get(i).getHangar();
        }
        System.out.println("Hangar Space: " + numFighters + " starfighters");

        for(int i = 95; i < shipTypeExample.size(); i++){
        if(numFighters > 0){
        System.out.println("Enter number of " + shipTypeExample.get(i).getShipClass() + "s for Fleet");
        System.out.println("Price: " + shipTypeExample.get(i).getPrice());
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        if(a > numFighters){
        a = numFighters;
        }
        ShipFactory shipFactory = new ShipFactory();
        for(int j = 1; j <= a; j++){
        if(creditLimit - shipTypeExample.get(i).getPrice() < 0){
        break;
        }
        fleet.get(0).add(ShipFactory.makeShip(shipTypeExample.get(i).getType(),shipTypeExample.get(i).getShipClass()));
        creditLimit = creditLimit - shipTypeExample.get(i).getPrice();
        numFighters--;
        }
        System.out.println("You have " + numFighters + " star fighters available");
        System.out.println("You have " + creditLimit + " credits remaining");
        }
        }
        System.out.println("Fleet size: " + fleet.get(0).size() + " Ship");

        System.out.println("Fleet:");

        for(int i = 0; i < shipTypeExample.size(); i++){
        for(int j = 0; j < fleet.get(0).size(); j++){
        if(shipTypeExample.get(i).getShipClass().equals(fleet.get(0).get(j).getShipClass())){
        holdCount++;
        shipTypeHolder.add(fleet.get(0).get(j));
        break;
        }
        }  
        }

        for(int i = 0; i < shipTypeHolder.size(); i++){
        int a = 0;
        for(int j = 0; j < fleet.get(0).size(); j++){
        if(shipTypeHolder.get(i).getShipClass().equals(fleet.get(0).get(j).getShipClass())){
        a++;
        }
        }
        System.out.println(a + " " + shipTypeHolder.get(i).getShipClass() + "s");
        } */
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

    public void printOutFleetStats(){
        System.out.println("\t\t\tUndamaged             Damaged               Heavily Damaged       Critically Damaged    Destroyed");
        for(int i = 0; i < holdCount; i++){
            System.out.println("");
            System.out.print(shipType[i] + "\t\t\t");
            for(int j = 0; j <= 4; j++){
                System.out.print(damageCount.get(i)[j]);
                if(damageCount.get(i)[j] < 10){
                    System.out.print("                     ");
                }else if(damageCount.get(i)[j] < 100 && damageCount.get(i)[j] >= 10){
                    System.out.print("                    ");
                }else if(damageCount.get(i)[j] < 1000 && damageCount.get(i)[j] >= 100){
                    System.out.print("                   ");
                }else{
                    System.out.print("                  ");
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
                if(s.getIsTarget() == true){
                    s.takeDamage();
                    if(s.getDamagedHull() < (s.getHull() / 2)){
                        if(s.getDamagedHull() < (s.getHull() / 4)){
                            if(s.getDamagedHull() < (s.getHull() / 10)){
                                if(s.getDamagedHull() <= 0){
                                    fleet.get(4).add(s);
                                  //  System.out.println(s.getShipClass() + " was destroyed by " + s.getTargetedBy().getShipClass());
                                    messages.add(new Message(4,s,s.getTargetedBy()));
                                    s.getTargetedBy().setHasTarget(false);
                                    s.setIsTarget(false);
                                    it1.remove();
                                    continue;
                                }else{                                          
                                    int retreat = 1+Randomizer.getRgen(100);
                                    if(retreat > 10){
                                        fleet.get(3).add(s);
                                     //   System.out.println(s.getShipClass() + " was critically damaged by " + s.getTargetedBy().getShipClass());
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
                                  //  System.out.println(s.getShipClass() + " was heavily damaged by " + s.getTargetedBy().getShipClass());
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
                               // System.out.println(s.getShipClass() + " was damaged by " + s.getTargetedBy().getShipClass());
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
            if(s.getHasTarget() == false || s.getTarget().getIsTarget() == false){                        
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
                 //   System.out.println(s.getShipClass() + " has rejoined the battle!");
                    messages.add(new Message(5,s,null));
                    it1.remove();
                }else if(s.getDamagedHull() >= s.getHull() * .75){
                    int random = Randomizer.getRgen(101);
                    if(random >= 50){
                        fleet.get(0).add(s);
                    //    System.out.println(s.getShipClass() + " has rejoined the battle!");
                        messages.add(new Message(5,s,null));
                        it1.remove();
                    }
                }
            }
        }
    }

    public static int getCreditLimit(){
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