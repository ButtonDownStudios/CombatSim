import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.HashMap;
/**
 * Write a description of class Main here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class CombatSim{

    public static void main(String[] args){

        SimSetup setup = new SimSetup();

        endSetup(setup);

        ArrayList<Ship> shipTypeExample = new ArrayList<>();
        ArrayList<ArrayList<Ship>> ship = new ArrayList<ArrayList<Ship>>();
        ReportHolder reports = new ReportHolder();

        for(int i = 0; i < 11; i++){
            ship.add(new ArrayList<Ship>());
        }

        shipTypeExample.add(ShipFactory.makeShip("Dreadnought","Emperor-class Star Dreadnought"));
        shipTypeExample.add(ShipFactory.makeShip("Dreadnought","Imperial Dreadnought Cruiser"));
        shipTypeExample.add(ShipFactory.makeShip("Dreadnought","Executor-class Star Dreadnought"));
        shipTypeExample.add(ShipFactory.makeShip("Dreadnought","Eclipse-class Star Dreadnought"));
        shipTypeExample.add(ShipFactory.makeShip("Dreadnought","Viscount-class Star Defender"));
        shipTypeExample.add(ShipFactory.makeShip("Dreadnought","Sovereign-class Super Star Destroyer"));
        shipTypeExample.add(ShipFactory.makeShip("Dreadnought","Super Star Destroyer")); 
        shipTypeExample.add(ShipFactory.makeShip("Carrier","Trade Federation Battleship"));
        shipTypeExample.add(ShipFactory.makeShip("Carrier","Reborn Sith Battle Carrier"));
        shipTypeExample.add(ShipFactory.makeShip("Carrier","Revenge-class Heavy Carrier"));
        shipTypeExample.add(ShipFactory.makeShip("Battleship","Mediator-class Battle Cruiser"));
        shipTypeExample.add(ShipFactory.makeShip("Carrier","Festrian Super Carrier"));
        shipTypeExample.add(ShipFactory.makeShip("Battleship","Allegiance-class Star Destroyer"));
        shipTypeExample.add(ShipFactory.makeShip("Battleship","Invincible-class Dreadnought")); 
        shipTypeExample.add(ShipFactory.makeShip("Battleship","Republic Class Cruiser"));
        shipTypeExample.add(ShipFactory.makeShip("Battleship","Reborn Sith Battle Cruiser"));
        shipTypeExample.add(ShipFactory.makeShip("Battleship","Galaforian Battle Cruiser"));
        shipTypeExample.add(ShipFactory.makeShip("Battleship","United Galatic Battle Cruiser"));
        shipTypeExample.add(ShipFactory.makeShip("Battleship","Pellaeon-class Star Destroyer"));
        shipTypeExample.add(ShipFactory.makeShip("Battleship","Imperial-class Star Destroyer Mk1"));
        shipTypeExample.add(ShipFactory.makeShip("Battleship","Imperial-class Star Destroyer Mk2")); 
        shipTypeExample.add(ShipFactory.makeShip("Battleship","Quantum Cruiser"));
        shipTypeExample.add(ShipFactory.makeShip("Heavy Cruiser","Viceroy-class Star Destroyer"));
        shipTypeExample.add(ShipFactory.makeShip("Heavy Cruiser","Legacy-class Star Destroyer"));
        shipTypeExample.add(ShipFactory.makeShip("Battleship","Raptorian-class Star Destroyer"));
        shipTypeExample.add(ShipFactory.makeShip("Battleship","MC90 Star Cruiser"));
        shipTypeExample.add(ShipFactory.makeShip("Battleship","Republic-class Star Destroyer")); 
        shipTypeExample.add(ShipFactory.makeShip("Battleship","MC80a Star Cruiser"));
        shipTypeExample.add(ShipFactory.makeShip("Battleship","Imperial Bulk Cruiser"));
        shipTypeExample.add(ShipFactory.makeShip("Carrier","Venator-class Star Destroyer"));
        shipTypeExample.add(ShipFactory.makeShip("Battleship","Trade Federation Cruiser"));
        shipTypeExample.add(ShipFactory.makeShip("Battleship","Nebula-class Star Destroyer"));
        shipTypeExample.add(ShipFactory.makeShip("Carrier","Endurance-class Fleet Carrier")); 
        shipTypeExample.add(ShipFactory.makeShip("Battleship","Scythe-class Battle Cruiser"));
        shipTypeExample.add(ShipFactory.makeShip("Battleship","Galactic Class Destroyer"));
        shipTypeExample.add(ShipFactory.makeShip("Battleship","Harrow-class Star Destroyer"));
        shipTypeExample.add(ShipFactory.makeShip("Battleship","Shree-class Battle Cruiser"));
        shipTypeExample.add(ShipFactory.makeShip("Battleship","Victory-class Star Destroyer"));
        shipTypeExample.add(ShipFactory.makeShip("Battleship","Bothan Assault Cruiser")); 
        shipTypeExample.add(ShipFactory.makeShip("Heavy Cruiser","Munificent-class Star Frigate"));
        shipTypeExample.add(ShipFactory.makeShip("Heavy Cruiser","Reborn Sith Heavy Cruiser"));
        shipTypeExample.add(ShipFactory.makeShip("Heavy Cruiser","Banking Clan Cruiser"));
        shipTypeExample.add(ShipFactory.makeShip("Light Cruiser","Republic Assault Ship"));
        shipTypeExample.add(ShipFactory.makeShip("Carrier","Defender-class Assault Carrier"));
        shipTypeExample.add(ShipFactory.makeShip("Heavy Cruiser","Shunan Assault Destroyer"));
        shipTypeExample.add(ShipFactory.makeShip("Heavy Cruiser","Assault Frigate")); 
        shipTypeExample.add(ShipFactory.makeShip("Heavy Cruiser","Majestic-class Heavy Cruiser"));
        shipTypeExample.add(ShipFactory.makeShip("Heavy Cruiser","Dragon-class Heavy Cruiser"));
        shipTypeExample.add(ShipFactory.makeShip("Heavy Cruiser","Dreadnought-class Heavy Cruiser"));
        shipTypeExample.add(ShipFactory.makeShip("Heavy Cruiser","Vindicator-class Heavy Cruiser"));
        shipTypeExample.add(ShipFactory.makeShip("Light Cruiser","Tartan-class Patrol Cruiser"));
        shipTypeExample.add(ShipFactory.makeShip("Light Cruiser","Enforcer-class Patrol Cruiser")); 
        shipTypeExample.add(ShipFactory.makeShip("Light Cruiser","Immobilizer 418 Cruiser"));
        shipTypeExample.add(ShipFactory.makeShip("Light Cruiser","Interdictor-class Cruiser"));
        shipTypeExample.add(ShipFactory.makeShip("Light Cruiser","Commerce Guild Destroyer"));
        shipTypeExample.add(ShipFactory.makeShip("Light Cruiser","MC40a Light Cruiser"));
        shipTypeExample.add(ShipFactory.makeShip("Frigate","Hammerhead-class Heavy Cruiser"));
        shipTypeExample.add(ShipFactory.makeShip("Frigate","Gladiator-class Star Destroyer")); 
        shipTypeExample.add(ShipFactory.makeShip("Carrier","Escort Carrier"));
        shipTypeExample.add(ShipFactory.makeShip("Heavy Cruiser","Republic Heavy Destroyer"));
        shipTypeExample.add(ShipFactory.makeShip("Heavy Cruiser","Hapan Battle Dragon"));
        shipTypeExample.add(ShipFactory.makeShip("Light Cruiser","Strike Cruiser"));
        shipTypeExample.add(ShipFactory.makeShip("Frigate","Alliance Assault Frigate"));
        shipTypeExample.add(ShipFactory.makeShip("Light Cruiser","Reborn Sith Light Cruiser"));
        shipTypeExample.add(ShipFactory.makeShip("Light Cruiser","Hapes Nova-class Battle Cruiser")); 
        shipTypeExample.add(ShipFactory.makeShip("Light Cruiser","Belarus-class Medium Cruiser"));
        shipTypeExample.add(ShipFactory.makeShip("Frigate","Galactic Defense Frigate"));
        shipTypeExample.add(ShipFactory.makeShip("Frigate","Ardent-class Frigate"));
        shipTypeExample.add(ShipFactory.makeShip("Frigate","Sacheen-class Light Escort"));
        shipTypeExample.add(ShipFactory.makeShip("Frigate","Republic Battle Frigate"));
        shipTypeExample.add(ShipFactory.makeShip("Frigate","Imperial Battle Frigate")); 
        shipTypeExample.add(ShipFactory.makeShip("Light Cruiser","Carrack-class Light Cruiser"));
        shipTypeExample.add(ShipFactory.makeShip("Frigate","Dogan Support Frigate"));
        shipTypeExample.add(ShipFactory.makeShip("Frigate","Kaloth-class Battle Cruiser"));
        shipTypeExample.add(ShipFactory.makeShip("Frigate","Class 1000 Cruiser"));
        shipTypeExample.add(ShipFactory.makeShip("Frigate","Star Galleon-class Frigate"));
        shipTypeExample.add(ShipFactory.makeShip("Frigate","Nebulon-B Frigate")); 
        shipTypeExample.add(ShipFactory.makeShip("Frigate","Corona-class Frigate"));
        shipTypeExample.add(ShipFactory.makeShip("Frigate","Nebulon-B2 Frigate"));
        shipTypeExample.add(ShipFactory.makeShip("Frigate","Lancer-class Frigate"));
        shipTypeExample.add(ShipFactory.makeShip("Frigate","Armadia-class Thrustship"));
        shipTypeExample.add(ShipFactory.makeShip("Frigate","Bayonet-class Light Cruiser"));
        shipTypeExample.add(ShipFactory.makeShip("Gunship","Reborn Sith Gunship"));
        shipTypeExample.add(ShipFactory.makeShip("Gunship","Federation Assault Gunship")); 
        shipTypeExample.add(ShipFactory.makeShip("Gunship","Marauder Corvette"));
        shipTypeExample.add(ShipFactory.makeShip("Gunship","Warrior-class Gunship"));
        shipTypeExample.add(ShipFactory.makeShip("Gunship","Agave-class Picket Ship"));
        shipTypeExample.add(ShipFactory.makeShip("Gunship","Shunan Gunship"));
        shipTypeExample.add(ShipFactory.makeShip("Gunship","Corellian Corvette"));
        shipTypeExample.add(ShipFactory.makeShip("Gunship","Imperial Assault Gunship")); 
        shipTypeExample.add(ShipFactory.makeShip("Gunship","Assassin-class Corvette"));
        shipTypeExample.add(ShipFactory.makeShip("Gunship","Corellian Gunship"));
        shipTypeExample.add(ShipFactory.makeShip("Gunship","Old Republic Light Cruiser"));
        shipTypeExample.add(ShipFactory.makeShip("Gunship","Braha'tok-class Gunship"));
        shipTypeExample.add(ShipFactory.makeShip("Gunship","Fw'sen-class Picket Ship"));
        shipTypeExample.add(ShipFactory.makeShip("Heavy Fighter","X-Wing")); 
        shipTypeExample.add(ShipFactory.makeShip("Bomber","Y-Wing"));
        shipTypeExample.add(ShipFactory.makeShip("Interceptor","A-Wing"));
        shipTypeExample.add(ShipFactory.makeShip("Heavy Fighter","B-Wing"));
        shipTypeExample.add(ShipFactory.makeShip("Light Fighter","E-Wing"));
        shipTypeExample.add(ShipFactory.makeShip("Bomber","K-Wing"));
        shipTypeExample.add(ShipFactory.makeShip("Heavy Fighter","ARC-170")); 
        shipTypeExample.add(ShipFactory.makeShip("Light Fighter","UG Fighter"));
        shipTypeExample.add(ShipFactory.makeShip("Interceptor","UG Interceptor"));
        shipTypeExample.add(ShipFactory.makeShip("Bomber","UG Bomber"));
        shipTypeExample.add(ShipFactory.makeShip("Light Fighter","TIE Fighter"));
        shipTypeExample.add(ShipFactory.makeShip("Interceptor","TIE Interceptor"));
        shipTypeExample.add(ShipFactory.makeShip("Bomber","TIE Bomber")); 
        shipTypeExample.add(ShipFactory.makeShip("Heavy Fighter","TIE Defender"));
        shipTypeExample.add(ShipFactory.makeShip("Light Fighter","TIE Raptor"));
        shipTypeExample.add(ShipFactory.makeShip("Light Fighter","TIE Phantom"));
        shipTypeExample.add(ShipFactory.makeShip("Heavy Fighter","Reborn Sith Heavy Fighter"));
        shipTypeExample.add(ShipFactory.makeShip("Light Fighter","Reborn Sith Light Fighter"));
        shipTypeExample.add(ShipFactory.makeShip("Interceptor","Reborn Sith Interceptor"));
        shipTypeExample.add(ShipFactory.makeShip("Bomber","Reborn Sith Bomber"));
        shipTypeExample.add(ShipFactory.makeShip("Battleship","Victory II-class Star Destroyer"));
        shipTypeExample.add(ShipFactory.makeShip("Carrier","Secutor-class Star Destroyer"));
        shipTypeExample.add(ShipFactory.makeShip("Frigate","Arquitens-class Light Cruiser"));
        shipTypeExample.add(ShipFactory.makeShip("Heavy Fighter","Bes'uliik"));
        shipTypeExample.add(ShipFactory.makeShip("Heavy Fighter","Aleph-class Starfighter"));
        shipTypeExample.add(ShipFactory.makeShip("Interceptor","Eta-2 Actis-class Interceptor"));
        shipTypeExample.add(ShipFactory.makeShip("Interceptor","Alpha-3 Nimbus-class V-wing Starfighter"));
        shipTypeExample.add(ShipFactory.makeShip("Interceptor","Delta-7 Aethersprite-class Light Interceptor"));
        shipTypeExample.add(ShipFactory.makeShip("Interceptor","A-9 Vigilance Interceptor"));
        shipTypeExample.add(ShipFactory.makeShip("Light Fighter","Belbullab-22 Starfighter"));
        shipTypeExample.add(ShipFactory.makeShip("Light Fighter","Droid Tri-Fighter"));
        shipTypeExample.add(ShipFactory.makeShip("Light Fighter","Z-95 Headhunter"));
        shipTypeExample.add(ShipFactory.makeShip("Light Fighter","N-1 Starfighter"));
        shipTypeExample.add(ShipFactory.makeShip("Light Fighter","Vulture-class Droid Starfighter"));
        shipTypeExample.add(ShipFactory.makeShip("Light Fighter","Miy'til Starfighter"));
        shipTypeExample.add(ShipFactory.makeShip("Light Fighter","Nssis-class Clawcraft"));
        shipTypeExample.add(ShipFactory.makeShip("Bomber","Hyena-class Bomber"));

        ship.get(0).add(ShipFactory.makeShip("Dreadnought","Emperor-class Star Dreadnought"));
        ship.get(0).add(ShipFactory.makeShip("Dreadnought","Imperial Dreadnought Cruiser"));
        ship.get(0).add(ShipFactory.makeShip("Dreadnought","Executor-class Star Dreadnought"));
        ship.get(0).add(ShipFactory.makeShip("Dreadnought","Eclipse-class Star Dreadnought"));
        ship.get(0).add(ShipFactory.makeShip("Dreadnought","Viscount-class Star Defender"));
        ship.get(0).add(ShipFactory.makeShip("Dreadnought","Sovereign-class Super Star Destroyer"));
        ship.get(0).add(ShipFactory.makeShip("Dreadnought","Super Star Destroyer")); 
        ship.get(1).add(ShipFactory.makeShip("Carrier","Trade Federation Battleship"));
        ship.get(1).add(ShipFactory.makeShip("Carrier","Reborn Sith Battle Carrier"));
        ship.get(1).add(ShipFactory.makeShip("Carrier","Revenge-class Heavy Carrier"));
        ship.get(2).add(ShipFactory.makeShip("Battleship","Mediator-class Battle Cruiser"));
        ship.get(1).add(ShipFactory.makeShip("Carrier","Festrian Super Carrier"));
        ship.get(2).add(ShipFactory.makeShip("Battleship","Allegiance-class Star Destroyer"));
        ship.get(2).add(ShipFactory.makeShip("Battleship","Invincible-class Dreadnought")); 
        ship.get(2).add(ShipFactory.makeShip("Battleship","Republic Class Cruiser"));
        ship.get(2).add(ShipFactory.makeShip("Battleship","Reborn Sith Battle Cruiser"));
        ship.get(2).add(ShipFactory.makeShip("Battleship","Galaforian Battle Cruiser"));
        ship.get(2).add(ShipFactory.makeShip("Battleship","United Galatic Battle Cruiser"));
        ship.get(2).add(ShipFactory.makeShip("Battleship","Pellaeon-class Star Destroyer"));
        ship.get(2).add(ShipFactory.makeShip("Battleship","Imperial-class Star Destroyer Mk1"));
        ship.get(2).add(ShipFactory.makeShip("Battleship","Imperial-class Star Destroyer Mk2")); 
        ship.get(2).add(ShipFactory.makeShip("Battleship","Quantum Cruiser"));
        ship.get(3).add(ShipFactory.makeShip("Heavy Cruiser","Viceroy-class Star Destroyer"));
        ship.get(3).add(ShipFactory.makeShip("Heavy Cruiser","Legacy-class Star Destroyer"));
        ship.get(2).add(ShipFactory.makeShip("Battleship","Raptorian-class Star Destroyer"));
        ship.get(2).add(ShipFactory.makeShip("Battleship","MC90 Star Cruiser"));
        ship.get(2).add(ShipFactory.makeShip("Battleship","Republic-class Star Destroyer")); 
        ship.get(2).add(ShipFactory.makeShip("Battleship","MC80a Star Cruiser"));
        ship.get(2).add(ShipFactory.makeShip("Battleship","Imperial Bulk Cruiser"));
        ship.get(1).add(ShipFactory.makeShip("Carrier","Venator-class Star Destroyer"));
        ship.get(2).add(ShipFactory.makeShip("Battleship","Trade Federation Cruiser"));
        ship.get(2).add(ShipFactory.makeShip("Battleship","Nebula-class Star Destroyer"));
        ship.get(1).add(ShipFactory.makeShip("Carrier","Endurance-class Fleet Carrier")); 
        ship.get(2).add(ShipFactory.makeShip("Battleship","Scythe-class Battle Cruiser"));
        ship.get(2).add(ShipFactory.makeShip("Battleship","Galactic Class Destroyer"));
        ship.get(2).add(ShipFactory.makeShip("Battleship","Harrow-class Star Destroyer"));
        ship.get(2).add(ShipFactory.makeShip("Battleship","Shree-class Battle Cruiser"));
        ship.get(2).add(ShipFactory.makeShip("Battleship","Victory-class Star Destroyer"));
        ship.get(2).add(ShipFactory.makeShip("Battleship","Bothan Assault Cruiser")); 
        ship.get(3).add(ShipFactory.makeShip("Heavy Cruiser","Munificent-class Star Frigate"));
        ship.get(3).add(ShipFactory.makeShip("Heavy Cruiser","Reborn Sith Heavy Cruiser"));
        ship.get(3).add(ShipFactory.makeShip("Heavy Cruiser","Banking Clan Cruiser"));
        ship.get(4).add(ShipFactory.makeShip("Light Cruiser","Republic Assault Ship"));
        ship.get(1).add(ShipFactory.makeShip("Carrier","Defender-class Assault Carrier"));
        ship.get(3).add(ShipFactory.makeShip("Heavy Cruiser","Shunan Assault Destroyer"));
        ship.get(3).add(ShipFactory.makeShip("Heavy Cruiser","Assault Frigate")); 
        ship.get(3).add(ShipFactory.makeShip("Heavy Cruiser","Majestic-class Heavy Cruiser"));
        ship.get(3).add(ShipFactory.makeShip("Heavy Cruiser","Dragon-class Heavy Cruiser"));
        ship.get(3).add(ShipFactory.makeShip("Heavy Cruiser","Dreadnought-class Heavy Cruiser"));
        ship.get(3).add(ShipFactory.makeShip("Heavy Cruiser","Vindicator-class Heavy Cruiser"));
        ship.get(4).add(ShipFactory.makeShip("Light Cruiser","Tartan-class Patrol Cruiser"));
        ship.get(4).add(ShipFactory.makeShip("Light Cruiser","Enforcer-class Patrol Cruiser")); 
        ship.get(4).add(ShipFactory.makeShip("Light Cruiser","Immobilizer 418 Cruiser"));
        ship.get(4).add(ShipFactory.makeShip("Light Cruiser","Interdictor-class Cruiser"));
        ship.get(4).add(ShipFactory.makeShip("Light Cruiser","Commerce Guild Destroyer"));
        ship.get(4).add(ShipFactory.makeShip("Light Cruiser","MC40a Light Cruiser"));
        ship.get(5).add(ShipFactory.makeShip("Frigate","Hammerhead-class Heavy Cruiser"));
        ship.get(5).add(ShipFactory.makeShip("Frigate","Gladiator-class Star Destroyer")); 
        ship.get(1).add(ShipFactory.makeShip("Carrier","Escort Carrier"));
        ship.get(3).add(ShipFactory.makeShip("Heavy Cruiser","Republic Heavy Destroyer"));
        ship.get(3).add(ShipFactory.makeShip("Heavy Cruiser","Hapan Battle Dragon"));
        ship.get(4).add(ShipFactory.makeShip("Light Cruiser","Strike Cruiser"));
        ship.get(5).add(ShipFactory.makeShip("Frigate","Alliance Assault Frigate"));
        ship.get(4).add(ShipFactory.makeShip("Light Cruiser","Reborn Sith Light Cruiser"));
        ship.get(4).add(ShipFactory.makeShip("Light Cruiser","Hapes Nova-class Battle Cruiser")); 
        ship.get(4).add(ShipFactory.makeShip("Light Cruiser","Belarus-class Medium Cruiser"));
        ship.get(5).add(ShipFactory.makeShip("Frigate","Galactic Defense Frigate"));
        ship.get(5).add(ShipFactory.makeShip("Frigate","Ardent-class Frigate"));
        ship.get(5).add(ShipFactory.makeShip("Frigate","Sacheen-class Light Escort"));
        ship.get(5).add(ShipFactory.makeShip("Frigate","Republic Battle Frigate"));
        ship.get(5).add(ShipFactory.makeShip("Frigate","Imperial Battle Frigate")); 
        ship.get(4).add(ShipFactory.makeShip("Light Cruiser","Carrack-class Light Cruiser"));
        ship.get(5).add(ShipFactory.makeShip("Frigate","Dogan Support Frigate"));
        ship.get(5).add(ShipFactory.makeShip("Frigate","Kaloth-class Battle Cruiser"));
        ship.get(5).add(ShipFactory.makeShip("Frigate","Class 1000 Cruiser"));
        ship.get(5).add(ShipFactory.makeShip("Frigate","Star Galleon-class Frigate"));
        ship.get(5).add(ShipFactory.makeShip("Frigate","Nebulon-B Frigate")); 
        ship.get(5).add(ShipFactory.makeShip("Frigate","Corona-class Frigate"));
        ship.get(5).add(ShipFactory.makeShip("Frigate","Nebulon-B2 Frigate"));
        ship.get(5).add(ShipFactory.makeShip("Frigate","Lancer-class Frigate"));
        ship.get(5).add(ShipFactory.makeShip("Frigate","Armadia-class Thrustship"));
        ship.get(5).add(ShipFactory.makeShip("Frigate","Bayonet-class Light Cruiser"));
        ship.get(6).add(ShipFactory.makeShip("Gunship","Reborn Sith Gunship"));
        ship.get(6).add(ShipFactory.makeShip("Gunship","Federation Assault Gunship")); 
        ship.get(6).add(ShipFactory.makeShip("Gunship","Marauder Corvette"));
        ship.get(6).add(ShipFactory.makeShip("Gunship","Warrior-class Gunship"));
        ship.get(6).add(ShipFactory.makeShip("Gunship","Agave-class Picket Ship"));
        ship.get(6).add(ShipFactory.makeShip("Gunship","Shunan Gunship"));
        ship.get(6).add(ShipFactory.makeShip("Gunship","Corellian Corvette"));
        ship.get(6).add(ShipFactory.makeShip("Gunship","Imperial Assault Gunship")); 
        ship.get(6).add(ShipFactory.makeShip("Gunship","Assassin-class Corvette"));
        ship.get(6).add(ShipFactory.makeShip("Gunship","Corellian Gunship"));
        ship.get(6).add(ShipFactory.makeShip("Gunship","Old Republic Light Cruiser"));
        ship.get(6).add(ShipFactory.makeShip("Gunship","Braha'tok-class Gunship"));
        ship.get(6).add(ShipFactory.makeShip("Gunship","Fw'sen-class Picket Ship"));
        ship.get(7).add(ShipFactory.makeShip("Heavy Fighter","X-Wing")); 
        ship.get(10).add(ShipFactory.makeShip("Bomber","Y-Wing"));
        ship.get(9).add(ShipFactory.makeShip("Interceptor","A-Wing"));
        ship.get(7).add(ShipFactory.makeShip("Heavy Fighter","B-Wing"));
        ship.get(8).add(ShipFactory.makeShip("Light Fighter","E-Wing"));
        ship.get(10).add(ShipFactory.makeShip("Bomber","K-Wing"));
        ship.get(7).add(ShipFactory.makeShip("Heavy Fighter","ARC-170")); 
        ship.get(8).add(ShipFactory.makeShip("Light Fighter","UG Fighter"));
        ship.get(9).add(ShipFactory.makeShip("Interceptor","UG Interceptor"));
        ship.get(10).add(ShipFactory.makeShip("Bomber","UG Bomber"));
        ship.get(8).add(ShipFactory.makeShip("Light Fighter","TIE Fighter"));
        ship.get(9).add(ShipFactory.makeShip("Interceptor","TIE Interceptor"));
        ship.get(10).add(ShipFactory.makeShip("Bomber","TIE Bomber")); 
        ship.get(7).add(ShipFactory.makeShip("Heavy Fighter","TIE Defender"));
        ship.get(8).add(ShipFactory.makeShip("Light Fighter","TIE Raptor"));
        ship.get(8).add(ShipFactory.makeShip("Light Fighter","TIE Phantom"));
        ship.get(7).add(ShipFactory.makeShip("Heavy Fighter","Reborn Sith Heavy Fighter"));
        ship.get(8).add(ShipFactory.makeShip("Light Fighter","Reborn Sith Light Fighter"));
        ship.get(9).add(ShipFactory.makeShip("Interceptor","Reborn Sith Interceptor"));
        ship.get(10).add(ShipFactory.makeShip("Bomber","Reborn Sith Bomber"));
        ship.get(2).add(ShipFactory.makeShip("Battleship","Victory II-class Star Destroyer"));
        ship.get(1).add(ShipFactory.makeShip("Carrier","Secutor-class Star Destroyer"));
        ship.get(5).add(ShipFactory.makeShip("Frigate","Arquitens-class Light Cruiser"));
        ship.get(7).add(ShipFactory.makeShip("Heavy Fighter","Bes'uliik"));
        ship.get(7).add(ShipFactory.makeShip("Heavy Fighter","Aleph-class Starfighter"));
        ship.get(9).add(ShipFactory.makeShip("Interceptor","Eta-2 Actis-class Interceptor"));
        ship.get(9).add(ShipFactory.makeShip("Interceptor","Alpha-3 Nimbus-class V-wing Starfighter"));
        ship.get(9).add(ShipFactory.makeShip("Interceptor","Delta-7 Aethersprite-class Light Interceptor"));
        ship.get(9).add(ShipFactory.makeShip("Interceptor","A-9 Vigilance Interceptor"));
        ship.get(8).add(ShipFactory.makeShip("Light Fighter","Belbullab-22 Starfighter"));
        ship.get(8).add(ShipFactory.makeShip("Light Fighter","Droid Tri-Fighter"));
        ship.get(8).add(ShipFactory.makeShip("Light Fighter","Z-95 Headhunter"));
        ship.get(8).add(ShipFactory.makeShip("Light Fighter","N-1 Starfighter"));
        ship.get(8).add(ShipFactory.makeShip("Light Fighter","Vulture-class Droid Starfighter"));
        ship.get(8).add(ShipFactory.makeShip("Light Fighter","Miy'til Starfighter"));
        ship.get(8).add(ShipFactory.makeShip("Light Fighter","Nssis-class Clawcraft"));
        ship.get(10).add(ShipFactory.makeShip("Bomber","Hyena-class Bomber"));

        int creditLimit = setup.getCreditLimit();
        int roundLimit = setup.getRoundLimit();

        Fleet fleet1 = new Fleet(creditLimit, shipTypeExample);
        Fleet fleet2 = new Fleet(creditLimit, shipTypeExample);

        FleetCreation f1 = new FleetCreation("Fleet 1", fleet1, ship);
        endfleetCreate(f1);
        fleet1.countInitial();
        FleetCreation f2 = new FleetCreation("Fleet 2", fleet2, ship);
        endfleetCreate(f2);
        fleet2.countInitial();

        //CombatSimulation     
        int counter = 0;
        long startTime = System.currentTimeMillis();
        do{
            counter++;
            //  System.out.println("Round " + counter + " Stats:");
            fleet1.combat(fleet2.getFleet().get(0), counter);
            //   System.out.println("");
            fleet2.combat(fleet1.getFleet().get(0), counter);
            //   System.out.println("");
            //   System.out.println("");
            fleet1.repair();
            //   System.out.println("");
            fleet2.repair();
            //   System.out.println("");
            fleet1.collectFleetStats();
            fleet2.collectFleetStats();
            //   System.out.println("Fleet 1 Status:");
            //   fleet1.printOutFleetStats();
            //   System.out.println("");
            //   System.out.println("Fleet 2 Status:");
            //   fleet2.printOutFleetStats();
            //   System.out.println("");
            //   System.out.println("");
            //   System.out.println(""); 
            reports.newReport(counter,fleet1.getholdCount(),fleet1.getShipType(),fleet1.getDamageCount(),fleet1.getMessages(),fleet2.getholdCount(),fleet2.getShipType(),fleet2.getDamageCount(),fleet2.getMessages());
        }while(fleet1.getFleet().get(0).isEmpty() == false && fleet2.getFleet().get(0).isEmpty() == false && counter < roundLimit);
        //Declare Winner          
         long endTime   = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        if(counter == roundLimit){
           // System.out.println("Tie after " + counter + " rounds");
            Winner winner = new Winner(0, counter,totalTime);
        }else if(fleet1.getFleet().get(0).isEmpty() == true && fleet2.getFleet().get(0).isEmpty() == false){
            Winner winner = new Winner(2, counter,totalTime);
          //  System.out.println("Fleet 2 wins after " + counter + " rounds!!!");
        }else if(fleet1.getFleet().get(0).isEmpty() == false && fleet2.getFleet().get(0).isEmpty() == true){
            Winner winner = new Winner(1, counter,totalTime);
          //  System.out.println("Fleet 1 wins after " + counter + " rounds!!!");
        }else if(fleet1.getFleet().get(0).isEmpty() == true && fleet2.getFleet().get(0).isEmpty() == true){
            Winner winner = new Winner(0, counter,totalTime);
           // System.out.println("Tie after " + counter + " rounds");
        }
        //Show Fleet Statistics
     //   fleet1.collectFleetStats();
     //   fleet2.collectFleetStats();

      //  System.out.println("Fleet 1 Status:");
     //   fleet1.printOutFleetStats();
     //   System.out.println("");
      //  System.out.println("Fleet 2 Status:");
     //   fleet2.printOutFleetStats();
       
      //  System.out.println("");
      //  System.out.println("This simulation took " + (totalTime / 1000.0) + " seconds to run");
        reports.lastVisible();
        reports.setFinal(counter - 1);
    }

    public static void endSetup(SimSetup setup){
        while(!setup.getEnd()){
            try{
                Thread.sleep(1);
            }catch(Exception e){
                System.out.print(e);
            }
        }
    }

    public static void endfleetCreate(FleetCreation fleetCreate){
        while(!fleetCreate.getEnd()){
            try{
                Thread.sleep(1);
            }catch(Exception e){
                System.out.print(e);
            }
        }
    }
}

