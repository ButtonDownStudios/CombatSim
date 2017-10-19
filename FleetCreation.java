import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.ArrayList;
import java.util.HashMap;

public class FleetCreation{

    private JFrame frame;
    private JPanel contentPane;
    private boolean end;
    private Fleet f;
    private JPanel left;
    private JPanel right;

    private JPanel dChoice;
    private JPanel cChoice;
    private JPanel bsChoice;
    private JPanel hcChoice;
    private JPanel lcChoice;
    private JPanel fChoice;
    private JPanel gChoice;
    private JPanel frChoice;
    private JPanel pChoice;
    private JPanel tChoice;
    private JPanel hfChoice;
    private JPanel lfChoice;
    private JPanel iChoice;
    private JPanel bChoice;
    private JPanel sChoice;

    private ArrayList<ArrayList<Ship>> ship;
    private ArrayList<HashMap<String, Integer>> shipCount;
    private ArrayList<String[]> shipNames;
    private ArrayList<ArrayList<ShipStats>> shipStats;

    private JPanel currentCapital;
    private JPanel currentFighter;

    private JPanel currentD;
    private JPanel currentC;
    private JPanel currentBS;
    private JPanel currentHC;
    private JPanel currentLC;
    private JPanel currentF;
    private JPanel currentG;
    private JPanel currentFr;
    private JPanel currentP;
    private JPanel currentT;
    private JPanel currentHF;
    private JPanel currentLF;
    private JPanel currentI;
    private JPanel currentB;
    private JPanel currentS;

    private JPanel innerCap;
    private JPanel innerStar;

    private static int hangarSpace;
    private static int shuttleSpace;
    private static int currentTroops;
    private static long currentCost;

    private static CreditUpdater creditUpdate;
    private static HangarUpdater hangarUpdate;
    private static ShuttleUpdater shuttleUpdate;
    private static TroopUpdater troopUpdate;

    public FleetCreation(String fleet, Fleet f, ArrayList<ArrayList<Ship>> ship){
        end = false;
        this.f =  f;

        currentCost = f.getCreditLimit();
        hangarSpace = 0;
        shuttleSpace = 0;
        currentTroops = 0;

        this.ship = ship;
        shipCount = new ArrayList<HashMap<String, Integer>>();
        shipNames = new ArrayList<>();
        shipStats = new ArrayList<ArrayList<ShipStats>>();

        for(int i = 0; i < 15; i++){
            shipCount.add(new HashMap<String, Integer>());
        }

        shipCount.get(0).put("Emperor-class Star Dreadnought",0);
        shipCount.get(0).put("Imperial Dreadnought Cruiser",0);
        shipCount.get(0).put("Executor-class Star Dreadnought",0);
        shipCount.get(0).put("Eclipse-class Star Dreadnought",0);
        shipCount.get(0).put("Viscount-class Star Defender",0);
        shipCount.get(0).put("Sovereign-class Super Star Destroyer",0);
        shipCount.get(0).put("Super Star Destroyer",0); 
        shipCount.get(1).put("Trade Federation Battleship",0);
        shipCount.get(1).put("Reborn Sith Battle Carrier",0);
        shipCount.get(1).put("Revenge-class Heavy Carrier",0);
        shipCount.get(2).put("Mediator-class Battle Cruiser",0);
        shipCount.get(1).put("Festrian Super Carrier",0);
        shipCount.get(2).put("Allegiance-class Star Destroyer",0);
        shipCount.get(2).put("Invincible-class Dreadnought",0); 
        shipCount.get(2).put("Republic Class Cruiser",0);
        shipCount.get(2).put("Reborn Sith Battle Cruiser",0);
        shipCount.get(2).put("Galaforian Battle Cruiser",0);
        shipCount.get(2).put("United Galatic Battle Cruiser",0);
        shipCount.get(2).put("Pellaeon-class Star Destroyer",0);
        shipCount.get(2).put("Imperial-class Star Destroyer Mk1",0);
        shipCount.get(2).put("Imperial-class Star Destroyer Mk2",0); 
        shipCount.get(2).put("Quantum Cruiser",0);
        shipCount.get(3).put("Viceroy-class Star Destroyer",0);
        shipCount.get(3).put("Legacy-class Star Destroyer",0);
        shipCount.get(2).put("Raptorian-class Star Destroyer",0);
        shipCount.get(2).put("MC90 Star Cruiser",0);
        shipCount.get(2).put("Republic-class Star Destroyer",0); 
        shipCount.get(2).put("MC80a Star Cruiser",0);
        shipCount.get(2).put("Imperial Bulk Cruiser",0);
        shipCount.get(1).put("Venator-class Star Destroyer",0);
        shipCount.get(2).put("Trade Federation Cruiser",0);
        shipCount.get(2).put("Nebula-class Star Destroyer",0);
        shipCount.get(1).put("Endurance-class Fleet Carrier",0); 
        shipCount.get(2).put("Scythe-class Battle Cruiser",0);
        shipCount.get(2).put("Galactic Class Destroyer",0);
        shipCount.get(2).put("Harrow-class Star Destroyer",0);
        shipCount.get(2).put("Shree-class Battle Cruiser",0);
        shipCount.get(2).put("Victory-class Star Destroyer",0);
        shipCount.get(2).put("Bothan Assault Cruiser",0); 
        shipCount.get(3).put("Munificent-class Star Frigate",0);
        shipCount.get(3).put("Reborn Sith Heavy Cruiser",0);
        shipCount.get(3).put("Banking Clan Cruiser",0);
        shipCount.get(13).put("Republic Assault Ship",0);
        shipCount.get(1).put("Defender-class Assault Carrier",0);
        shipCount.get(3).put("Shunan Assault Destroyer",0);
        shipCount.get(3).put("Assault Frigate",0); 
        shipCount.get(3).put("Majestic-class Heavy Cruiser",0);
        shipCount.get(3).put("Dragon-class Heavy Cruiser",0);
        shipCount.get(3).put("Dreadnought-class Heavy Cruiser",0);
        shipCount.get(3).put("Vindicator-class Heavy Cruiser",0);
        shipCount.get(5).put("Tartan-class Patrol Cruiser",0);
        shipCount.get(4).put("Enforcer-class Patrol Cruiser",0); 
        shipCount.get(4).put("Immobilizer 418 Cruiser",0);
        shipCount.get(4).put("Interdictor-class Cruiser",0);
        shipCount.get(4).put("Commerce Guild Destroyer",0);
        shipCount.get(4).put("MC40a Light Cruiser",0);
        shipCount.get(5).put("Hammerhead-class Heavy Cruiser",0);
        shipCount.get(5).put("Gladiator-class Star Destroyer",0); 
        shipCount.get(1).put("Escort Carrier",0);
        shipCount.get(3).put("Republic Heavy Destroyer",0);
        shipCount.get(3).put("Hapan Battle Dragon",0);
        shipCount.get(4).put("Strike Cruiser",0);
        shipCount.get(5).put("Alliance Assault Frigate",0);
        shipCount.get(4).put("Reborn Sith Light Cruiser",0);
        shipCount.get(4).put("Hapes Nova-class Battle Cruiser",0); 
        shipCount.get(4).put("Belarus-class Medium Cruiser",0);
        shipCount.get(5).put("Galactic Defense Frigate",0);
        shipCount.get(5).put("Ardent-class Frigate",0);
        shipCount.get(5).put("Sacheen-class Light Escort",0);
        shipCount.get(5).put("Republic Battle Frigate",0);
        shipCount.get(5).put("Imperial Battle Frigate",0); 
        shipCount.get(4).put("Carrack-class Light Cruiser",0);
        shipCount.get(5).put("Dogan Support Frigate",0);
        shipCount.get(5).put("Kaloth-class Battle Cruiser",0);
        shipCount.get(5).put("Class 1000 Cruiser",0);
        shipCount.get(5).put("Star Galleon-class Frigate",0);
        shipCount.get(5).put("Nebulon-B Frigate",0); 
        shipCount.get(5).put("Corona-class Frigate",0);
        shipCount.get(5).put("Nebulon-B2 Frigate",0);
        shipCount.get(5).put("Lancer-class Frigate",0);
        shipCount.get(5).put("Armadia-class Thrustship",0);
        shipCount.get(5).put("Bayonet-class Light Cruiser",0);
        shipCount.get(6).put("Reborn Sith Gunship",0);
        shipCount.get(6).put("Federation Assault Gunship",0); 
        shipCount.get(6).put("Marauder Corvette",0);
        shipCount.get(6).put("Warrior-class Gunship",0);
        shipCount.get(6).put("Agave-class Picket Ship",0);
        shipCount.get(6).put("Shunan Gunship",0);
        shipCount.get(6).put("Corellian Corvette",0);
        shipCount.get(6).put("Imperial Assault Gunship",0); 
        shipCount.get(6).put("Assassin-class Corvette",0);
        shipCount.get(6).put("Corellian Gunship",0);
        shipCount.get(6).put("Old Republic Light Cruiser",0);
        shipCount.get(6).put("Braha'tok-class Gunship",0);
        shipCount.get(12).put("Fw'sen-class Picket Ship",0);
        shipCount.get(7).put("X-Wing",0); 
        shipCount.get(10).put("Y-Wing",0);
        shipCount.get(9).put("A-Wing",0);
        shipCount.get(7).put("B-Wing",0);
        shipCount.get(8).put("E-Wing",0);
        shipCount.get(10).put("K-Wing",0);
        shipCount.get(7).put("ARC-170",0); 
        shipCount.get(8).put("UG Fighter",0);
        shipCount.get(9).put("UG Interceptor",0);
        shipCount.get(10).put("UG Bomber",0);
        shipCount.get(8).put("TIE Fighter",0);
        shipCount.get(9).put("TIE Interceptor",0);
        shipCount.get(10).put("TIE Bomber",0); 
        shipCount.get(7).put("TIE Defender",0);
        shipCount.get(8).put("TIE Raptor",0);
        shipCount.get(8).put("TIE Phantom",0);
        shipCount.get(7).put("Reborn Sith Heavy Fighter",0);
        shipCount.get(8).put("Reborn Sith Light Fighter",0);
        shipCount.get(9).put("Reborn Sith Interceptor",0);
        shipCount.get(10).put("Reborn Sith Bomber",0);
        shipCount.get(2).put("Victory II-class Star Destroyer",0);
        shipCount.get(1).put("Secutor-class Star Destroyer",0);
        shipCount.get(5).put("Arquitens-class Light Cruiser",0);
        shipCount.get(7).put("Bes'uliik",0);
        shipCount.get(7).put("Aleph-class Starfighter",0);
        shipCount.get(9).put("Eta-2 Actis-class Interceptor",0);
        shipCount.get(9).put("Alpha-3 Nimbus-class V-wing Starfighter",0);
        shipCount.get(9).put("Delta-7 Aethersprite-class Light Interceptor",0);
        shipCount.get(9).put("A-9 Vigilance Interceptor",0);
        shipCount.get(8).put("Belbullab-22 Starfighter",0);
        shipCount.get(8).put("Droid Tri-Fighter",0);
        shipCount.get(8).put("Z-95 Headhunter",0);
        shipCount.get(8).put("N-1 Starfighter",0);
        shipCount.get(8).put("Vulture-class Droid Starfighter",0);
        shipCount.get(8).put("Miy'til Starfighter",0);
        shipCount.get(8).put("Nssis-class Clawcraft",0);
        shipCount.get(10).put("Hyena-class Bomber",0);
        shipCount.get(7).put("CloakShape Fighter",0);
        shipCount.get(10).put("Miy'til Assault Bomber",0);
        shipCount.get(1).put("Quasar Fire-class Bulk Cruiser",0);
        shipCount.get(8).put("Fang Fighter",0);
        shipCount.get(8).put("Aurek-class Tactical Strikefighter",0);
        shipCount.get(8).put("Rogue-class Starfighter",0);
        shipCount.get(8).put("V-19 Torrent Starfighter",0);
        shipCount.get(7).put("R-41 Starchaser",0);
        shipCount.get(7).put("StarViper-class Attack Platform",0);
        shipCount.get(7).put("Rihkxyrk Assault Fighter",0);
        shipCount.get(7).put("Ixiyen-class Fast Attack Craft",0);
        shipCount.get(10).put("GAT-12 Skipray Blastboat",0);
        shipCount.get(8).put("I-7 Howlrunner",0);
        shipCount.get(11).put("VCX-100 Light Freighter",0);
        shipCount.get(11).put("YT-2400 Light Freighter",0);
        shipCount.get(11).put("YT-2000 Light Freighter",0);
        shipCount.get(11).put("YT-1300 Light Freighter",0);
        shipCount.get(11).put("YT-1250 Freighter",0);
        shipCount.get(11).put("Stathas-class Freighter",0);
        shipCount.get(11).put("MC-18 Light Freighter",0);
        shipCount.get(11).put("Simiyiar-class Light Freighter",0);
        shipCount.get(12).put("SS-54 Assault Ship",0);
        shipCount.get(11).put("Stalwart-class Freighter",0);
        shipCount.get(12).put("RX4 Patrol Ship",0);
        shipCount.get(12).put("Mynock-class Assault Boat",0);
        shipCount.get(12).put("Firespray-31-class Attack Craft",0);
        shipCount.get(12).put("Pursuer-class Enforcement Ship",0);
        shipCount.get(13).put("UT-60D U-wing Starfighter",0);
        shipCount.get(12).put("PB-950 Patrol Boat",0);
        shipCount.get(12).put("Law-class Light Patrol Craft",0);
        shipCount.get(13).put("Beta-class ETR-3 Escort Transport",0);
        shipCount.get(13).put("Delta-class DX-9 Stormtrooper Transport",0);
        shipCount.get(13).put("Etti Lighter",0);
        shipCount.get(13).put("Gamma-class ATR-6 Assault Transport",0);
        shipCount.get(13).put("GR-75 Medium Transport",0);
        shipCount.get(13).put("ILH-KK Citadel-class Civilian Cruiser",0);
        shipCount.get(13).put("Kom'rk-class Transport",0);
        shipCount.get(13).put("Loronar Medium Transport",0);
        shipCount.get(13).put("Mobquet Medium Transport",0);
        shipCount.get(13).put("Seltiss-1 Caravel",0);
        shipCount.get(13).put("Shaadlar-type Troopship",0);
        shipCount.get(13).put("VT-49 Decimator",0);
        shipCount.get(13).put("Wayfarer-class Medium Transport",0);
        shipCount.get(13).put("YZ-775 Medium Transport",0);
        shipCount.get(14).put("Lambda-class T-4a Shuttle",0);
        shipCount.get(14).put("Aegis-class Combat Shuttle",0);
        shipCount.get(14).put("Delta-class JV-7 Escort Shuttle",0);
        shipCount.get(14).put("Flarestar-class Attack Shuttle",0);
        shipCount.get(14).put("Nu-class Attack Shuttle",0);
        shipCount.get(14).put("Sentinel-class Landing Craft",0);
        shipCount.get(14).put("Upsilon-class Command Shuttle",0);
        shipCount.get(14).put("Sheathipede-class Transport Shuttle",0);
        shipCount.get(14).put("Sigma-class Shuttle",0);
        shipCount.get(14).put("Low Altitude Assault Transport",0);
        shipCount.get(14).put("BR-23 Courier",0);
        shipCount.get(14).put("Y-4 Raptor-class Transport",0);
        shipCount.get(13).put("CR25 Troop Carrier",0);
        shipCount.get(11).put("YV-865 Aurore-class Freighter",0);
        shipCount.get(5).put("Pelta-class Frigate",0);
        shipCount.get(6).put("Consular-class Cruiser",0);
        shipCount.get(14).put("Delta-class T-3c Shuttle",0);
        shipCount.get(13).put("Imperial Armored Transport",0);
        shipCount.get(13).put("Tra'kad-class Transport",0);
        shipCount.get(10).put("Alpha-class Xg-1 Star Wing",0);
        shipCount.get(7).put("TIE Avenger",0);
        shipCount.get(13).put("Amphibious Interstellar Assault Transport",0);
        shipCount.get(14).put("Kappa-class Shuttle",0);
        shipCount.get(14).put("Grek-class Troop Shuttle",0);
        shipCount.get(14).put("Crix-class Assault Shuttle",0);
        shipCount.get(13).put("Hardcell-class Interstellar Transport",0);

        for(int i = 0; i < 15; i++){
            shipNames.add(new String[ship.get(i).size()]);
            shipStats.add(new ArrayList<ShipStats>());
        }

        for(int i = 0; i < ship.size(); i++){
            for(int j =0; j < ship.get(i).size(); j++){
                shipNames.get(i)[j] = ship.get(i).get(j).getShipClass();
                shipStats.get(i).add(new ShipStats(ship.get(i).get(j), shipCount.get(i)));
            }
        }

        makeFrame(fleet);
    }

    private void makeFrame(String fleet){
        frame = new JFrame(fleet + " Creation");
        contentPane = (JPanel) frame.getContentPane();
        contentPane.setBorder(new EmptyBorder(12,12,12,12));
        contentPane.setLayout(new BorderLayout(6,6));
        fillContent();
        frame.pack();
        frame.setVisible(true);
    }

    public void fillContent(){
        JPanel selection = new JPanel();
        selection.setLayout(new GridLayout(1,2));
        left = new JPanel();
        right = new JPanel();
        left.setLayout(new BorderLayout());
        right.setLayout(new BorderLayout());

        fillCapitalChoice();
        fillStarChoice();
        fillDisplay(selection);

        contentPane.add(selection, BorderLayout.CENTER);

        JPanel south = new JPanel();
        south.setLayout(new GridLayout(2,1));
        JPanel north = new JPanel();
        north.setLayout(new GridLayout(1,3));

        JLabel money = new JLabel();
        money.setLayout(new GridLayout(1,2));

        creditUpdate = new CreditUpdater(currentCost);
        creditUpdate.display();
        money.add(creditUpdate);
        troopUpdate = new TroopUpdater(currentTroops);
        troopUpdate.display();
        money.add(troopUpdate);
        north.add(money);

        JButton check = new JButton("Check Fleet");
        check.addActionListener((event) -> {
                checkFleet(shipCount);
            });
        north.add(check);

        JPanel hangar = new JPanel();
        hangar.setLayout(new GridLayout(1,2));

        hangarUpdate = new HangarUpdater(hangarSpace);
        shuttleUpdate = new ShuttleUpdater(shuttleSpace);
        hangarUpdate.display();
        shuttleUpdate.display();
        hangar.add(hangarUpdate);
        hangar.add(shuttleUpdate);
        north.add(hangar);

        south.add(north);

        JButton complete = new JButton("Complete");
        complete.addActionListener((event) -> {
                if(hangarSpace >= 0 && currentCost >= 0){
                    end();
                    frame.setVisible(false);
                }
            });
        south.add(complete);
        contentPane.add(south, BorderLayout.SOUTH);
    }

    public void fillDisplay(JPanel selection){
        selection.add(left);
        selection.add(right);
    }

    public void fillCapitalChoice(){
        JPanel outerDivide = new JPanel();
        outerDivide.setLayout(new GridLayout(1,2));

        String[] capTypes = {"Dreadnought","Carrier","Battleship","Heavy Cruiser","Light Cruiser","Frigate","Gunship","Freighter","Patrol Ship","Transport"};
        JComboBox<String> capChoice = new JComboBox<>(capTypes);
        capChoice.addActionListener((event) -> {
                chooseCapitalType(capChoice.getSelectedItem());
            });

        outerDivide.add(new JLabel("Capital Ship Types:"));
        outerDivide.add(capChoice);

        fillCapital();

        currentCapital = new JPanel();

        currentCapital = dChoice;

        left.add(currentCapital, BorderLayout.CENTER);

        left.add(outerDivide, BorderLayout.NORTH);
    }

    public void fillStarChoice(){
        JPanel outerDivide = new JPanel();
        outerDivide.setLayout(new GridLayout(1,2));

        String[] starTypes = {"Heavy Fighter","Light Fighter","Interceptor","Bomber","Shuttle"};
        JComboBox<String> starChoice = new JComboBox<>(starTypes);
        starChoice.addActionListener((event) -> {
                chooseFighterType(starChoice.getSelectedItem());
            });

        outerDivide.add(new JLabel("Star Fighter Types:"));
        outerDivide.add(starChoice);

        fillFighter();

        currentFighter = new JPanel();

        currentFighter = hfChoice;

        right.add(currentFighter, BorderLayout.CENTER);

        right.add(outerDivide, BorderLayout.NORTH); 
    }

    private void fillCapital(){
        dChoice = new JPanel();
        cChoice = new JPanel();
        bsChoice = new JPanel();
        hcChoice = new JPanel();
        lcChoice = new JPanel();
        fChoice = new JPanel();
        gChoice = new JPanel();
        frChoice = new JPanel();
        pChoice = new JPanel();
        tChoice = new JPanel();

        dChoice.setLayout(new BorderLayout());
        cChoice.setLayout(new BorderLayout());
        bsChoice.setLayout(new BorderLayout());
        hcChoice.setLayout(new BorderLayout());
        lcChoice.setLayout(new BorderLayout());
        fChoice.setLayout(new BorderLayout());
        gChoice.setLayout(new BorderLayout());
        frChoice.setLayout(new BorderLayout());
        pChoice.setLayout(new BorderLayout());
        tChoice.setLayout(new BorderLayout());

        JPanel dChoiceDivide = new JPanel();
        dChoiceDivide.setLayout(new GridLayout(1,2));
        JComboBox<String> dChoiceNames = new JComboBox<>(shipNames.get(0));
        dChoiceNames.addActionListener((event) -> {
                chooseDreadnoughtType(dChoiceNames.getSelectedIndex());
            });
        dChoiceDivide.add(new JLabel("Dreadnought Ship Classes:"));
        dChoiceDivide.add(dChoiceNames);

        JPanel cChoiceDivide = new JPanel();
        cChoiceDivide.setLayout(new GridLayout(1,2));
        JComboBox<String> cChoiceNames = new JComboBox<>(shipNames.get(1));
        cChoiceNames.addActionListener((event) -> {
                chooseCarrierType(cChoiceNames.getSelectedIndex());
            });
        cChoiceDivide.add(new JLabel("Carrier Ship Classes:"));
        cChoiceDivide.add(cChoiceNames);

        JPanel bsChoiceDivide = new JPanel();
        bsChoiceDivide.setLayout(new GridLayout(1,2));
        JComboBox<String> bsChoiceNames = new JComboBox<>(shipNames.get(2));
        bsChoiceNames.addActionListener((event) -> {
                chooseBattleshipType(bsChoiceNames.getSelectedIndex());
            });
        bsChoiceDivide.add(new JLabel("Battleship Ship Classes:"));
        bsChoiceDivide.add(bsChoiceNames);

        JPanel hcChoiceDivide = new JPanel();
        hcChoiceDivide.setLayout(new GridLayout(1,2));
        JComboBox<String> hcChoiceNames = new JComboBox<>(shipNames.get(3));
        hcChoiceNames.addActionListener((event) -> {
                chooseHeavyCruiserType(hcChoiceNames.getSelectedIndex());
            });
        hcChoiceDivide.add(new JLabel("Heavy Cruiser Ship Classes:"));
        hcChoiceDivide.add(hcChoiceNames);

        JPanel lcChoiceDivide = new JPanel();
        lcChoiceDivide.setLayout(new GridLayout(1,2));
        JComboBox<String> lcChoiceNames = new JComboBox<>(shipNames.get(4));
        lcChoiceNames.addActionListener((event) -> {
                chooseLightCruiserType(lcChoiceNames.getSelectedIndex());
            });
        lcChoiceDivide.add(new JLabel("Light Cruiser Ship Classes:"));
        lcChoiceDivide.add(lcChoiceNames);

        JPanel fChoiceDivide = new JPanel();
        fChoiceDivide.setLayout(new GridLayout(1,2));
        JComboBox<String> fChoiceNames = new JComboBox<>(shipNames.get(5));
        fChoiceNames.addActionListener((event) -> {
                chooseFrigateType(fChoiceNames.getSelectedIndex());
            });
        fChoiceDivide.add(new JLabel("Frigate Ship Classes:"));
        fChoiceDivide.add(fChoiceNames);

        JPanel gChoiceDivide = new JPanel();
        gChoiceDivide.setLayout(new GridLayout(1,2));
        JComboBox<String> gChoiceNames = new JComboBox<>(shipNames.get(6));
        gChoiceNames.addActionListener((event) -> {
                chooseGunshipType(gChoiceNames.getSelectedIndex());
            });
        gChoiceDivide.add(new JLabel("Gunship Ship Classes:"));
        gChoiceDivide.add(gChoiceNames);

        JPanel frChoiceDivide = new JPanel();
        frChoiceDivide.setLayout(new GridLayout(1,2));
        JComboBox<String> frChoiceNames = new JComboBox<>(shipNames.get(11));
        frChoiceNames.addActionListener((event) -> {
                chooseFreighterType(frChoiceNames.getSelectedIndex());
            });
        frChoiceDivide.add(new JLabel("Freighter Ship Classes:"));
        frChoiceDivide.add(frChoiceNames);

        JPanel pChoiceDivide = new JPanel();
        pChoiceDivide.setLayout(new GridLayout(1,2));
        JComboBox<String> pChoiceNames = new JComboBox<>(shipNames.get(12));
        pChoiceNames.addActionListener((event) -> {
                choosePatrolType(pChoiceNames.getSelectedIndex());
            });
        pChoiceDivide.add(new JLabel("Patrol Ship Classes:"));
        pChoiceDivide.add(pChoiceNames);

        JPanel tChoiceDivide = new JPanel();
        tChoiceDivide.setLayout(new GridLayout(1,2));
        JComboBox<String> tChoiceNames = new JComboBox<>(shipNames.get(13));
        tChoiceNames.addActionListener((event) -> {
                chooseTransportType(tChoiceNames.getSelectedIndex());
            });
        tChoiceDivide.add(new JLabel("Transport Ship Classes:"));
        tChoiceDivide.add(tChoiceNames);

        dChoice.add(dChoiceDivide, BorderLayout.NORTH);
        cChoice.add(cChoiceDivide, BorderLayout.NORTH);
        bsChoice.add(bsChoiceDivide, BorderLayout.NORTH);
        hcChoice.add(hcChoiceDivide, BorderLayout.NORTH);
        lcChoice.add(lcChoiceDivide, BorderLayout.NORTH);
        fChoice.add(fChoiceDivide, BorderLayout.NORTH);
        gChoice.add(gChoiceDivide, BorderLayout.NORTH);
        frChoice.add(frChoiceDivide, BorderLayout.NORTH);
        pChoice.add(pChoiceDivide, BorderLayout.NORTH);
        tChoice.add(tChoiceDivide, BorderLayout.NORTH);

        currentD = new JPanel();
        currentD = shipStats.get(0).get(0).getStats();
        currentC = new JPanel();
        currentC = shipStats.get(1).get(0).getStats();
        currentBS = new JPanel();
        currentBS = shipStats.get(2).get(0).getStats();
        currentHC = new JPanel();
        currentHC = shipStats.get(3).get(0).getStats();
        currentLC = new JPanel();
        currentLC = shipStats.get(4).get(0).getStats();
        currentF = new JPanel();
        currentF = shipStats.get(5).get(0).getStats();
        currentG = new JPanel();
        currentG = shipStats.get(6).get(0).getStats();
        currentFr = new JPanel();
        currentFr = shipStats.get(11).get(0).getStats();
        currentP = new JPanel();
        currentP = shipStats.get(12).get(0).getStats();
        currentT = new JPanel();
        currentT = shipStats.get(13).get(0).getStats();

        dChoice.add(currentD, BorderLayout.CENTER);
        cChoice.add(currentC, BorderLayout.CENTER);
        bsChoice.add(currentBS, BorderLayout.CENTER);
        hcChoice.add(currentHC, BorderLayout.CENTER);
        lcChoice.add(currentLC, BorderLayout.CENTER);
        fChoice.add(currentF, BorderLayout.CENTER);
        gChoice.add(currentG, BorderLayout.CENTER);
        frChoice.add(currentFr, BorderLayout.CENTER);
        pChoice.add(currentP, BorderLayout.CENTER);
        tChoice.add(currentT, BorderLayout.CENTER);
    }

    private void fillFighter(){
        hfChoice = new JPanel();
        lfChoice = new JPanel();
        iChoice = new JPanel();
        bChoice = new JPanel();
        sChoice = new JPanel();

        hfChoice.setLayout(new BorderLayout());
        lfChoice.setLayout(new BorderLayout());
        iChoice.setLayout(new BorderLayout());
        bChoice.setLayout(new BorderLayout());
        sChoice.setLayout(new BorderLayout());

        JPanel hfChoiceDivide = new JPanel();
        hfChoiceDivide.setLayout(new GridLayout(1,2));
        JComboBox<String> hfChoiceNames = new JComboBox<>(shipNames.get(7));
        hfChoiceNames.addActionListener((event) -> {
                chooseHeavyFighterType(hfChoiceNames.getSelectedIndex());
            });
        hfChoiceDivide.add(new JLabel("Heavy Fighter Ship Classes:"));
        hfChoiceDivide.add(hfChoiceNames);

        JPanel lfChoiceDivide = new JPanel();
        lfChoiceDivide.setLayout(new GridLayout(1,2));
        JComboBox<String> lfChoiceNames = new JComboBox<>(shipNames.get(8));
        lfChoiceNames.addActionListener((event) -> {
                chooseLightFighterType(lfChoiceNames.getSelectedIndex());
            });
        lfChoiceDivide.add(new JLabel("Light Fighter Ship Classes:"));
        lfChoiceDivide.add(lfChoiceNames);

        JPanel iChoiceDivide = new JPanel();
        iChoiceDivide.setLayout(new GridLayout(1,2));
        JComboBox<String> iChoiceNames = new JComboBox<>(shipNames.get(9));
        iChoiceNames.addActionListener((event) -> {
                chooseInterceptorType(iChoiceNames.getSelectedIndex());
            });
        iChoiceDivide.add(new JLabel("Interceptor Ship Classes:"));
        iChoiceDivide.add(iChoiceNames);

        JPanel bChoiceDivide = new JPanel();
        bChoiceDivide.setLayout(new GridLayout(1,2));
        JComboBox<String> bChoiceNames = new JComboBox<>(shipNames.get(10));
        bChoiceNames.addActionListener((event) -> {
                chooseBomberType(bChoiceNames.getSelectedIndex());
            });
        bChoiceDivide.add(new JLabel("Bomber Ship Classes:"));
        bChoiceDivide.add(bChoiceNames);

        JPanel sChoiceDivide = new JPanel();
        sChoiceDivide.setLayout(new GridLayout(1,2));
        JComboBox<String> sChoiceNames = new JComboBox<>(shipNames.get(14));
        sChoiceNames.addActionListener((event) -> {
                chooseShuttleType(sChoiceNames.getSelectedIndex());
            });
        sChoiceDivide.add(new JLabel("Shuttle Ship Classes:"));
        sChoiceDivide.add(sChoiceNames);

        hfChoice.add(hfChoiceDivide, BorderLayout.NORTH);
        lfChoice.add(lfChoiceDivide, BorderLayout.NORTH);
        iChoice.add(iChoiceDivide, BorderLayout.NORTH);
        bChoice.add(bChoiceDivide, BorderLayout.NORTH);
        sChoice.add(sChoiceDivide, BorderLayout.NORTH);

        currentHF = new JPanel();
        currentHF = shipStats.get(7).get(0).getStats();
        currentLF = new JPanel();
        currentLF = shipStats.get(8).get(0).getStats();
        currentI = new JPanel();
        currentI = shipStats.get(9).get(0).getStats();
        currentB = new JPanel();
        currentB = shipStats.get(10).get(0).getStats();
        currentS = new JPanel();
        currentS = shipStats.get(14).get(0).getStats();

        hfChoice.add(currentHF, BorderLayout.CENTER);
        lfChoice.add(currentLF, BorderLayout.CENTER);
        iChoice.add(currentI, BorderLayout.CENTER);
        bChoice.add(currentB, BorderLayout.CENTER);
        sChoice.add(currentS, BorderLayout.CENTER);
    }

    private void end(){
        for(int i = 0; i < 15; i++){
            for(int j = 0; j < ship.get(i).size(); j++){
                for(int k = 0; k < shipCount.get(i).get(ship.get(i).get(j).getShipClass()); k++){
                    f.addShip(ShipFactory.makeShip(ship.get(i).get(j).getType(), ship.get(i).get(j).getShipClass()));
                }
            }
        }
        f.setSpaceTroops(currentTroops);
        end = true;
    }

    private void chooseFighterType(Object o){
        String s = "";
        if(o instanceof String){
            s = (String) o;
        }
        if(s.equals("Heavy Fighter")){
            right.remove(currentFighter);
            currentFighter = hfChoice;
            right.add(currentFighter, BorderLayout.CENTER);
            contentPane.revalidate();
            contentPane.repaint();
            frame.pack();
        }else if(s.equals("Light Fighter")){
            right.remove(currentFighter);
            currentFighter = lfChoice;
            right.add(currentFighter, BorderLayout.CENTER);
            contentPane.revalidate();
            contentPane.repaint();
            frame.pack();
        }else if(s.equals("Interceptor")){
            right.remove(currentFighter);
            currentFighter = iChoice;
            right.add(currentFighter, BorderLayout.CENTER);
            contentPane.revalidate();
            contentPane.repaint();
            frame.pack();
        }else if(s.equals("Bomber")){
            right.remove(currentFighter);
            currentFighter = bChoice;
            right.add(currentFighter, BorderLayout.CENTER);
            contentPane.revalidate();
            contentPane.repaint();
            frame.pack();
        }else{
            right.remove(currentFighter);
            currentFighter = sChoice;
            right.add(currentFighter, BorderLayout.CENTER);
            contentPane.revalidate();
            contentPane.repaint();
            frame.pack();
        }
    }

    private void chooseCapitalType(Object o){
        String s = "";
        if(o instanceof String){
            s = (String) o;
        }
        if(s.equals("Dreadnought")){
            left.remove(currentCapital);
            currentCapital = dChoice;
            left.add(currentCapital, BorderLayout.CENTER);
            contentPane.revalidate();
            contentPane.repaint();
            frame.pack();
        }else if(s.equals("Carrier")){
            left.remove(currentCapital);
            currentCapital = cChoice;
            left.add(currentCapital, BorderLayout.CENTER);
            contentPane.revalidate();
            contentPane.repaint();
            frame.pack();
        }else if(s.equals("Battleship")){
            left.remove(currentCapital);
            currentCapital = bsChoice;
            left.add(currentCapital, BorderLayout.CENTER);
            contentPane.revalidate();
            contentPane.repaint();
            frame.pack();
        }else if(s.equals("Heavy Cruiser")){
            left.remove(currentCapital);
            currentCapital = hcChoice;
            left.add(currentCapital, BorderLayout.CENTER);
            contentPane.revalidate();
            contentPane.repaint();
            frame.pack();
        }else if(s.equals("Light Cruiser")){
            left.remove(currentCapital);
            currentCapital = lcChoice;
            left.add(currentCapital, BorderLayout.CENTER);
            contentPane.revalidate();
            contentPane.repaint();
            frame.pack();
        }else if(s.equals("Frigate")){
            left.remove(currentCapital);
            currentCapital = fChoice;
            left.add(currentCapital, BorderLayout.CENTER);
            contentPane.revalidate();
            contentPane.repaint();
            frame.pack();
        }else if(s.equals("Gunship")){
            left.remove(currentCapital);
            currentCapital = gChoice;
            left.add(currentCapital, BorderLayout.CENTER);
            contentPane.revalidate();
            contentPane.repaint();
            frame.pack();
        }else if(s.equals("Freighter")){
            left.remove(currentCapital);
            currentCapital = frChoice;
            left.add(currentCapital, BorderLayout.CENTER);
            contentPane.revalidate();
            contentPane.repaint();
            frame.pack();
        }else if(s.equals("Patrol Ship")){
            left.remove(currentCapital);
            currentCapital = pChoice;
            left.add(currentCapital, BorderLayout.CENTER);
            contentPane.revalidate();
            contentPane.repaint();
            frame.pack();
        }else{
            left.remove(currentCapital);
            currentCapital = tChoice;
            left.add(currentCapital, BorderLayout.CENTER);
            contentPane.revalidate();
            contentPane.repaint();
            frame.pack();
        }
    }

    private void chooseDreadnoughtType(int i){
        dChoice.remove(currentD);
        currentD = shipStats.get(0).get(i).getStats();
        dChoice.add(currentD, BorderLayout.CENTER);
        contentPane.revalidate();
        contentPane.repaint();
        frame.pack();
    }

    private void chooseCarrierType(int i){
        cChoice.remove(currentC);
        currentC = shipStats.get(1).get(i).getStats();
        cChoice.add(currentC, BorderLayout.CENTER);
        contentPane.revalidate();
        contentPane.repaint();
        frame.pack();
    }

    private void chooseBattleshipType(int i){
        bsChoice.remove(currentBS);
        currentBS = shipStats.get(2).get(i).getStats();
        bsChoice.add(currentBS, BorderLayout.CENTER);
        contentPane.revalidate();
        contentPane.repaint();
        frame.pack();
    }

    private void chooseHeavyCruiserType(int i){
        hcChoice.remove(currentHC);
        currentHC = shipStats.get(3).get(i).getStats();
        hcChoice.add(currentHC, BorderLayout.CENTER);
        contentPane.revalidate();
        contentPane.repaint();
        frame.pack();
    }

    private void chooseLightCruiserType(int i){
        lcChoice.remove(currentLC);
        currentLC = shipStats.get(4).get(i).getStats();
        lcChoice.add(currentLC, BorderLayout.CENTER);
        contentPane.revalidate();
        contentPane.repaint();
        frame.pack();
    }

    private void chooseFrigateType(int i){
        fChoice.remove(currentF);
        currentF = shipStats.get(5).get(i).getStats();
        fChoice.add(currentF, BorderLayout.CENTER);
        contentPane.revalidate();
        contentPane.repaint();
        frame.pack();
    }

    private void chooseGunshipType(int i){
        gChoice.remove(currentG);
        currentG = shipStats.get(6).get(i).getStats();
        gChoice.add(currentG, BorderLayout.CENTER);
        contentPane.revalidate();
        contentPane.repaint();
        frame.pack();
    }

    private void chooseFreighterType(int i){
        frChoice.remove(currentFr);
        currentFr = shipStats.get(11).get(i).getStats();
        frChoice.add(currentFr, BorderLayout.CENTER);
        contentPane.revalidate();
        contentPane.repaint();
        frame.pack();
    }

    private void choosePatrolType(int i){
        pChoice.remove(currentP);
        currentP = shipStats.get(12).get(i).getStats();
        pChoice.add(currentP, BorderLayout.CENTER);
        contentPane.revalidate();
        contentPane.repaint();
        frame.pack();
    }

    private void chooseTransportType(int i){
        tChoice.remove(currentT);
        currentT = shipStats.get(13).get(i).getStats();
        tChoice.add(currentT, BorderLayout.CENTER);
        contentPane.revalidate();
        contentPane.repaint();
        frame.pack();
    }

    private void chooseHeavyFighterType(int i){
        hfChoice.remove(currentHF);
        currentHF = shipStats.get(7).get(i).getStats();
        hfChoice.add(currentHF, BorderLayout.CENTER);
        contentPane.revalidate();
        contentPane.repaint();
        frame.pack();
    }

    private void chooseLightFighterType(int i){
        lfChoice.remove(currentLF);
        currentLF = shipStats.get(8).get(i).getStats();
        lfChoice.add(currentLF, BorderLayout.CENTER);
        contentPane.revalidate();
        contentPane.repaint();
        frame.pack();
    }

    private void chooseInterceptorType(int i){
        iChoice.remove(currentI);
        currentI = shipStats.get(9).get(i).getStats();
        iChoice.add(currentI, BorderLayout.CENTER);
        contentPane.revalidate();
        contentPane.repaint();
        frame.pack();
    }

    private void chooseBomberType(int i){
        bChoice.remove(currentB);
        currentB = shipStats.get(10).get(i).getStats();
        bChoice.add(currentB, BorderLayout.CENTER);
        contentPane.revalidate();
        contentPane.repaint();
        frame.pack();
    }

    private void chooseShuttleType(int i){
        sChoice.remove(currentS);
        currentS = shipStats.get(14).get(i).getStats();
        sChoice.add(currentS, BorderLayout.CENTER);
        contentPane.revalidate();
        contentPane.repaint();
        frame.pack();
    }

    public boolean getEnd(){
        return end;
    }

    private void checkFleet(ArrayList<HashMap<String, Integer>> shipCount){
        FleetStats fleetStat = new FleetStats(shipCount);
    }

    public static void setFighters(int code, int space, int old, int knew){
        if(code == 0){
            hangarSpace -= (old * space);
            hangarSpace += (knew * space);
        }else{
            hangarSpace += old;
            hangarSpace -= knew;
        }
        hangarUpdate.update(hangarSpace);
    }

    public static void setShuttles(int code, int space, int old, int knew){
        if(code == 0){
            shuttleSpace -= (old * space);
            shuttleSpace += (knew * space);
        }else{
            shuttleSpace += old;
            shuttleSpace -= knew;
        }
        shuttleUpdate.update(shuttleSpace);
    }

    public static void setTroops(int code, int space, int old, int knew){
        if(code == 0){
            currentTroops -= (old * space);
            currentTroops += (knew * space);
        }else{
            currentTroops += old;
            currentTroops -= knew;
        }
        troopUpdate.update(currentTroops);
    }

    public static void setCredits(int old, int knew, int cost){
        currentCost += (old * cost);
        currentCost -= (knew * cost);
        creditUpdate.update(currentCost);
    }   
}