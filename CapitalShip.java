public class CapitalShip extends Ship{

    private int hangar;
    private int shuttles;

    public CapitalShip(ShipType shipType, String[] stats, String[] newWeapons){
        super(stats[0], Integer.parseInt(stats[1]), Integer.parseInt(stats[2]), Integer.parseInt(stats[4]), Integer.parseInt(stats[6]), newWeapons);
        super.setType(shipType);
        hangar = Integer.parseInt(stats[3]);
        shuttles = Integer.parseInt(stats[5]);
        super.setPrice(getPrice());
    }

    public int getPrice(){
        int amount = (super.getHull() * 100) + (super.getShields() * 150) + (hangar * 50000) + (super.getMaxTroops() * 1000);
        for(int i = 0; i < super.getWeapons().size(); i++){
            amount = amount + super.getWeapons().get(i).getPrice();
        }
        return amount;
    }

    public int getHangar(){
        return hangar;
    }

    public int getShuttles(){
        return shuttles;
    }
}