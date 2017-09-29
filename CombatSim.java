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

        for(int i = 0; i < 15; i++){
            ship.add(new ArrayList<Ship>());
        }

        shipTypeExample.add(ShipFactory.makeShip(ShipType.DREADNOUGHT,"Emperor-class Star Dreadnought"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.DREADNOUGHT,"Imperial Dreadnought Cruiser"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.DREADNOUGHT,"Executor-class Star Dreadnought"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.DREADNOUGHT,"Eclipse-class Star Dreadnought"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.DREADNOUGHT,"Viscount-class Star Defender"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.DREADNOUGHT,"Sovereign-class Super Star Destroyer"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.DREADNOUGHT,"Super Star Destroyer")); 
        shipTypeExample.add(ShipFactory.makeShip(ShipType.CARRIER,"Trade Federation Battleship"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.CARRIER,"Reborn Sith Battle Carrier"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.CARRIER,"Revenge-class Heavy Carrier"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.BATTLESHIP,"Mediator-class Battle Cruiser"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.CARRIER,"Festrian Super Carrier"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.BATTLESHIP,"Allegiance-class Star Destroyer"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.BATTLESHIP,"Invincible-class Dreadnought")); 
        shipTypeExample.add(ShipFactory.makeShip(ShipType.BATTLESHIP,"Republic Class Cruiser"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.BATTLESHIP,"Reborn Sith Battle Cruiser"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.BATTLESHIP,"Galaforian Battle Cruiser"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.BATTLESHIP,"United Galatic Battle Cruiser"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.BATTLESHIP,"Pellaeon-class Star Destroyer"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.BATTLESHIP,"Imperial-class Star Destroyer Mk1"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.BATTLESHIP,"Imperial-class Star Destroyer Mk2")); 
        shipTypeExample.add(ShipFactory.makeShip(ShipType.BATTLESHIP,"Quantum Cruiser"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.HEAVYCRUISER,"Viceroy-class Star Destroyer"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.HEAVYCRUISER,"Legacy-class Star Destroyer"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.BATTLESHIP,"Raptorian-class Star Destroyer"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.BATTLESHIP,"MC90 Star Cruiser"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.BATTLESHIP,"Republic-class Star Destroyer")); 
        shipTypeExample.add(ShipFactory.makeShip(ShipType.BATTLESHIP,"MC80a Star Cruiser"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.BATTLESHIP,"Imperial Bulk Cruiser"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.CARRIER,"Venator-class Star Destroyer"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.BATTLESHIP,"Trade Federation Cruiser"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.BATTLESHIP,"Nebula-class Star Destroyer"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.CARRIER,"Endurance-class Fleet Carrier")); 
        shipTypeExample.add(ShipFactory.makeShip(ShipType.BATTLESHIP,"Scythe-class Battle Cruiser"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.BATTLESHIP,"Galactic Class Destroyer"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.BATTLESHIP,"Harrow-class Star Destroyer"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.BATTLESHIP,"Shree-class Battle Cruiser"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.BATTLESHIP,"Victory-class Star Destroyer"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.BATTLESHIP,"Bothan Assault Cruiser")); 
        shipTypeExample.add(ShipFactory.makeShip(ShipType.HEAVYCRUISER,"Munificent-class Star Frigate"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.HEAVYCRUISER,"Reborn Sith Heavy Cruiser"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.HEAVYCRUISER,"Banking Clan Cruiser"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.TRANSPORT,"Republic Assault Ship"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.CARRIER,"Defender-class Assault Carrier"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.HEAVYCRUISER,"Shunan Assault Destroyer"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.HEAVYCRUISER,"Assault Frigate")); 
        shipTypeExample.add(ShipFactory.makeShip(ShipType.HEAVYCRUISER,"Majestic-class Heavy Cruiser"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.HEAVYCRUISER,"Dragon-class Heavy Cruiser"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.HEAVYCRUISER,"Dreadnought-class Heavy Cruiser"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.HEAVYCRUISER,"Vindicator-class Heavy Cruiser"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.FRIGATE,"Tartan-class Patrol Cruiser"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.LIGHTCRUISER,"Enforcer-class Patrol Cruiser")); 
        shipTypeExample.add(ShipFactory.makeShip(ShipType.LIGHTCRUISER,"Immobilizer 418 Cruiser"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.LIGHTCRUISER,"Interdictor-class Cruiser"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.LIGHTCRUISER,"Commerce Guild Destroyer"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.LIGHTCRUISER,"MC40a Light Cruiser"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.FRIGATE,"Hammerhead-class Heavy Cruiser"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.FRIGATE,"Gladiator-class Star Destroyer")); 
        shipTypeExample.add(ShipFactory.makeShip(ShipType.CARRIER,"Escort Carrier"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.HEAVYCRUISER,"Republic Heavy Destroyer"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.HEAVYCRUISER,"Hapan Battle Dragon"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.LIGHTCRUISER,"Strike Cruiser"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.FRIGATE,"Alliance Assault Frigate"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.LIGHTCRUISER,"Reborn Sith Light Cruiser"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.LIGHTCRUISER,"Hapes Nova-class Battle Cruiser")); 
        shipTypeExample.add(ShipFactory.makeShip(ShipType.LIGHTCRUISER,"Belarus-class Medium Cruiser"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.FRIGATE,"Galactic Defense Frigate"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.FRIGATE,"Ardent-class Frigate"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.FRIGATE,"Sacheen-class Light Escort"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.FRIGATE,"Republic Battle Frigate"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.FRIGATE,"Imperial Battle Frigate")); 
        shipTypeExample.add(ShipFactory.makeShip(ShipType.LIGHTCRUISER,"Carrack-class Light Cruiser"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.FRIGATE,"Dogan Support Frigate"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.FRIGATE,"Kaloth-class Battle Cruiser"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.FRIGATE,"Class 1000 Cruiser"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.FRIGATE,"Star Galleon-class Frigate"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.FRIGATE,"Nebulon-B Frigate")); 
        shipTypeExample.add(ShipFactory.makeShip(ShipType.FRIGATE,"Corona-class Frigate"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.FRIGATE,"Nebulon-B2 Frigate"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.FRIGATE,"Lancer-class Frigate"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.FRIGATE,"Armadia-class Thrustship"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.FRIGATE,"Bayonet-class Light Cruiser"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.GUNSHIP,"Reborn Sith Gunship"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.GUNSHIP,"Federation Assault Gunship")); 
        shipTypeExample.add(ShipFactory.makeShip(ShipType.GUNSHIP,"Marauder Corvette"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.GUNSHIP,"Warrior-class Gunship"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.GUNSHIP,"Agave-class Picket Ship"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.GUNSHIP,"Shunan Gunship"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.GUNSHIP,"Corellian Corvette"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.GUNSHIP,"Imperial Assault Gunship")); 
        shipTypeExample.add(ShipFactory.makeShip(ShipType.GUNSHIP,"Assassin-class Corvette"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.GUNSHIP,"Corellian Gunship"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.GUNSHIP,"Old Republic Light Cruiser"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.GUNSHIP,"Braha'tok-class Gunship"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.PATROL,"Fw'sen-class Picket Ship"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.HEAVYFIGHTER,"X-Wing")); 
        shipTypeExample.add(ShipFactory.makeShip(ShipType.BOMBER,"Y-Wing"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.INTERCEPTOR,"A-Wing"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.HEAVYFIGHTER,"B-Wing"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.LIGHTFIGHTER,"E-Wing"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.BOMBER,"K-Wing"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.HEAVYFIGHTER,"ARC-170")); 
        shipTypeExample.add(ShipFactory.makeShip(ShipType.LIGHTFIGHTER,"UG Fighter"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.INTERCEPTOR,"UG Interceptor"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.BOMBER,"UG Bomber"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.LIGHTFIGHTER,"TIE Fighter"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.INTERCEPTOR,"TIE Interceptor"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.BOMBER,"TIE Bomber")); 
        shipTypeExample.add(ShipFactory.makeShip(ShipType.HEAVYFIGHTER,"TIE Defender"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.LIGHTFIGHTER,"TIE Raptor"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.LIGHTFIGHTER,"TIE Phantom"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.HEAVYFIGHTER,"Reborn Sith Heavy Fighter"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.LIGHTFIGHTER,"Reborn Sith Light Fighter"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.INTERCEPTOR,"Reborn Sith Interceptor"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.BOMBER,"Reborn Sith Bomber"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.BATTLESHIP,"Victory II-class Star Destroyer"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.CARRIER,"Secutor-class Star Destroyer"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.FRIGATE,"Arquitens-class Light Cruiser"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.HEAVYFIGHTER,"Bes'uliik"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.HEAVYFIGHTER,"Aleph-class Starfighter"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.INTERCEPTOR,"Eta-2 Actis-class Interceptor"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.INTERCEPTOR,"Alpha-3 Nimbus-class V-wing Starfighter"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.INTERCEPTOR,"Delta-7 Aethersprite-class Light Interceptor"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.INTERCEPTOR,"A-9 Vigilance Interceptor"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.LIGHTFIGHTER,"Belbullab-22 Starfighter"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.LIGHTFIGHTER,"Droid Tri-Fighter"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.LIGHTFIGHTER,"Z-95 Headhunter"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.LIGHTFIGHTER,"N-1 Starfighter"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.LIGHTFIGHTER,"Vulture-class Droid Starfighter"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.LIGHTFIGHTER,"Miy'til Starfighter"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.LIGHTFIGHTER,"Nssis-class Clawcraft"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.BOMBER,"Hyena-class Bomber"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.HEAVYFIGHTER,"CloakShape Fighter"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.BOMBER,"Miy'til Assault Bomber"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.CARRIER,"Quasar Fire-class Bulk Cruiser"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.LIGHTFIGHTER,"Fang Fighter"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.LIGHTFIGHTER,"Aurek-class Tactical Strikefighter"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.LIGHTFIGHTER,"Rogue-class Starfighter"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.LIGHTFIGHTER,"V-19 Torrent Starfighter"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.HEAVYFIGHTER,"R-41 Starchaser"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.HEAVYFIGHTER,"StarViper-class Attack Platform"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.HEAVYFIGHTER,"Rihkxyrk Assault Fighter"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.HEAVYFIGHTER,"Ixiyen-class Fast Attack Craft"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.BOMBER,"GAT-12 Skipray Blastboat"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.LIGHTFIGHTER,"I-7 Howlrunner"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.FREIGHTER,"VCX-100 Light Freighter"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.FREIGHTER,"YT-2400 Light Freighter"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.FREIGHTER,"YT-2000 Light Freighter"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.FREIGHTER,"YT-1300 Light Freighter"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.FREIGHTER,"YT-1250 Freighter"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.FREIGHTER,"Stathas-class Freighter"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.FREIGHTER,"MC-18 Light Freighter"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.FREIGHTER,"Simiyiar-class Light Freighter"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.PATROL,"SS-54 Assault Ship"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.FREIGHTER,"Stalwart-class Freighter"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.PATROL,"RX4 Patrol Ship"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.PATROL,"Mynock-class Assault Boat"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.PATROL,"Firespray-31-class Attack Craft"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.PATROL,"Pursuer-class Enforcement Ship"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.TRANSPORT,"UT-60D U-wing Starfighter"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.PATROL,"PB-950 Patrol Boat"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.PATROL,"Law-class Light Patrol Craft"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.TRANSPORT,"Beta-class ETR-3 Escort Transport"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.TRANSPORT,"Delta-class DX-9 Stormtrooper Transport"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.TRANSPORT,"Etti Lighter"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.TRANSPORT,"Gamma-class ATR-6 Assault Transport"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.TRANSPORT,"GR-75 Medium Transport"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.TRANSPORT,"ILH-KK Citadel-class Civilian Cruiser"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.TRANSPORT,"Kom'rk-class Transport"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.TRANSPORT,"Loronar Medium Transport"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.TRANSPORT,"Mobquet Medium Transport"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.TRANSPORT,"Seltiss-1 Caravel"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.TRANSPORT,"Shaadlar-type Troopship"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.TRANSPORT,"VT-49 Decimator"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.TRANSPORT,"Wayfarer-class Medium Transport"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.TRANSPORT,"YZ-775 Medium Transport"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.SHUTTLE,"Lambda-class T-4a Shuttle"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.SHUTTLE,"Aegis-class Combat Shuttle"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.SHUTTLE,"Delta-class JV-7 Escort Shuttle"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.SHUTTLE,"Flarestar-class Attack Shuttle"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.SHUTTLE,"Nu-class Attack Shuttle"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.SHUTTLE,"Sentinel-class Landing Craft"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.SHUTTLE,"Upsilon-class Command Shuttle"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.SHUTTLE,"Sheathipede-class Transport Shuttle"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.SHUTTLE,"Sigma-class Shuttle"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.SHUTTLE,"Low Altitude Assault Transport"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.SHUTTLE,"BR-23 Courier"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.SHUTTLE,"Y-4 Raptor-class Transport"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.TRANSPORT,"CR25 Troop Carrier"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.FREIGHTER,"YV-865 Aurore-class Freighter"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.FRIGATE,"Pelta-class Frigate"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.GUNSHIP,"Consular-class Cruiser"));
        shipTypeExample.add(ShipFactory.makeShip(ShipType.SHUTTLE,"Delta-class T-3c Shuttle"));

        ship.get(0).add(ShipFactory.makeShip(ShipType.DREADNOUGHT,"Emperor-class Star Dreadnought"));
        ship.get(0).add(ShipFactory.makeShip(ShipType.DREADNOUGHT,"Imperial Dreadnought Cruiser"));
        ship.get(0).add(ShipFactory.makeShip(ShipType.DREADNOUGHT,"Executor-class Star Dreadnought"));
        ship.get(0).add(ShipFactory.makeShip(ShipType.DREADNOUGHT,"Eclipse-class Star Dreadnought"));
        ship.get(0).add(ShipFactory.makeShip(ShipType.DREADNOUGHT,"Viscount-class Star Defender"));
        ship.get(0).add(ShipFactory.makeShip(ShipType.DREADNOUGHT,"Sovereign-class Super Star Destroyer"));
        ship.get(0).add(ShipFactory.makeShip(ShipType.DREADNOUGHT,"Super Star Destroyer")); 
        ship.get(1).add(ShipFactory.makeShip(ShipType.CARRIER,"Trade Federation Battleship"));
        ship.get(1).add(ShipFactory.makeShip(ShipType.CARRIER,"Reborn Sith Battle Carrier"));
        ship.get(1).add(ShipFactory.makeShip(ShipType.CARRIER,"Revenge-class Heavy Carrier"));
        ship.get(2).add(ShipFactory.makeShip(ShipType.BATTLESHIP,"Mediator-class Battle Cruiser"));
        ship.get(1).add(ShipFactory.makeShip(ShipType.CARRIER,"Festrian Super Carrier"));
        ship.get(2).add(ShipFactory.makeShip(ShipType.BATTLESHIP,"Allegiance-class Star Destroyer"));
        ship.get(2).add(ShipFactory.makeShip(ShipType.BATTLESHIP,"Invincible-class Dreadnought")); 
        ship.get(2).add(ShipFactory.makeShip(ShipType.BATTLESHIP,"Republic Class Cruiser"));
        ship.get(2).add(ShipFactory.makeShip(ShipType.BATTLESHIP,"Reborn Sith Battle Cruiser"));
        ship.get(2).add(ShipFactory.makeShip(ShipType.BATTLESHIP,"Galaforian Battle Cruiser"));
        ship.get(2).add(ShipFactory.makeShip(ShipType.BATTLESHIP,"United Galatic Battle Cruiser"));
        ship.get(2).add(ShipFactory.makeShip(ShipType.BATTLESHIP,"Pellaeon-class Star Destroyer"));
        ship.get(2).add(ShipFactory.makeShip(ShipType.BATTLESHIP,"Imperial-class Star Destroyer Mk1"));
        ship.get(2).add(ShipFactory.makeShip(ShipType.BATTLESHIP,"Imperial-class Star Destroyer Mk2")); 
        ship.get(2).add(ShipFactory.makeShip(ShipType.BATTLESHIP,"Quantum Cruiser"));
        ship.get(3).add(ShipFactory.makeShip(ShipType.HEAVYCRUISER,"Viceroy-class Star Destroyer"));
        ship.get(3).add(ShipFactory.makeShip(ShipType.HEAVYCRUISER,"Legacy-class Star Destroyer"));
        ship.get(2).add(ShipFactory.makeShip(ShipType.BATTLESHIP,"Raptorian-class Star Destroyer"));
        ship.get(2).add(ShipFactory.makeShip(ShipType.BATTLESHIP,"MC90 Star Cruiser"));
        ship.get(2).add(ShipFactory.makeShip(ShipType.BATTLESHIP,"Republic-class Star Destroyer")); 
        ship.get(2).add(ShipFactory.makeShip(ShipType.BATTLESHIP,"MC80a Star Cruiser"));
        ship.get(2).add(ShipFactory.makeShip(ShipType.BATTLESHIP,"Imperial Bulk Cruiser"));
        ship.get(1).add(ShipFactory.makeShip(ShipType.CARRIER,"Venator-class Star Destroyer"));
        ship.get(2).add(ShipFactory.makeShip(ShipType.BATTLESHIP,"Trade Federation Cruiser"));
        ship.get(2).add(ShipFactory.makeShip(ShipType.BATTLESHIP,"Nebula-class Star Destroyer"));
        ship.get(1).add(ShipFactory.makeShip(ShipType.CARRIER,"Endurance-class Fleet Carrier")); 
        ship.get(2).add(ShipFactory.makeShip(ShipType.BATTLESHIP,"Scythe-class Battle Cruiser"));
        ship.get(2).add(ShipFactory.makeShip(ShipType.BATTLESHIP,"Galactic Class Destroyer"));
        ship.get(2).add(ShipFactory.makeShip(ShipType.BATTLESHIP,"Harrow-class Star Destroyer"));
        ship.get(2).add(ShipFactory.makeShip(ShipType.BATTLESHIP,"Shree-class Battle Cruiser"));
        ship.get(2).add(ShipFactory.makeShip(ShipType.BATTLESHIP,"Victory-class Star Destroyer"));
        ship.get(2).add(ShipFactory.makeShip(ShipType.BATTLESHIP,"Bothan Assault Cruiser")); 
        ship.get(3).add(ShipFactory.makeShip(ShipType.HEAVYCRUISER,"Munificent-class Star Frigate"));
        ship.get(3).add(ShipFactory.makeShip(ShipType.HEAVYCRUISER,"Reborn Sith Heavy Cruiser"));
        ship.get(3).add(ShipFactory.makeShip(ShipType.HEAVYCRUISER,"Banking Clan Cruiser"));
        ship.get(13).add(ShipFactory.makeShip(ShipType.TRANSPORT,"Republic Assault Ship"));
        ship.get(1).add(ShipFactory.makeShip(ShipType.CARRIER,"Defender-class Assault Carrier"));
        ship.get(3).add(ShipFactory.makeShip(ShipType.HEAVYCRUISER,"Shunan Assault Destroyer"));
        ship.get(3).add(ShipFactory.makeShip(ShipType.HEAVYCRUISER,"Assault Frigate")); 
        ship.get(3).add(ShipFactory.makeShip(ShipType.HEAVYCRUISER,"Majestic-class Heavy Cruiser"));
        ship.get(3).add(ShipFactory.makeShip(ShipType.HEAVYCRUISER,"Dragon-class Heavy Cruiser"));
        ship.get(3).add(ShipFactory.makeShip(ShipType.HEAVYCRUISER,"Dreadnought-class Heavy Cruiser"));
        ship.get(3).add(ShipFactory.makeShip(ShipType.HEAVYCRUISER,"Vindicator-class Heavy Cruiser"));
        ship.get(5).add(ShipFactory.makeShip(ShipType.FRIGATE,"Tartan-class Patrol Cruiser"));
        ship.get(4).add(ShipFactory.makeShip(ShipType.LIGHTCRUISER,"Enforcer-class Patrol Cruiser")); 
        ship.get(4).add(ShipFactory.makeShip(ShipType.LIGHTCRUISER,"Immobilizer 418 Cruiser"));
        ship.get(4).add(ShipFactory.makeShip(ShipType.LIGHTCRUISER,"Interdictor-class Cruiser"));
        ship.get(4).add(ShipFactory.makeShip(ShipType.LIGHTCRUISER,"Commerce Guild Destroyer"));
        ship.get(4).add(ShipFactory.makeShip(ShipType.LIGHTCRUISER,"MC40a Light Cruiser"));
        ship.get(5).add(ShipFactory.makeShip(ShipType.FRIGATE,"Hammerhead-class Heavy Cruiser"));
        ship.get(5).add(ShipFactory.makeShip(ShipType.FRIGATE,"Gladiator-class Star Destroyer")); 
        ship.get(1).add(ShipFactory.makeShip(ShipType.CARRIER,"Escort Carrier"));
        ship.get(3).add(ShipFactory.makeShip(ShipType.HEAVYCRUISER,"Republic Heavy Destroyer"));
        ship.get(3).add(ShipFactory.makeShip(ShipType.HEAVYCRUISER,"Hapan Battle Dragon"));
        ship.get(4).add(ShipFactory.makeShip(ShipType.LIGHTCRUISER,"Strike Cruiser"));
        ship.get(5).add(ShipFactory.makeShip(ShipType.FRIGATE,"Alliance Assault Frigate"));
        ship.get(4).add(ShipFactory.makeShip(ShipType.LIGHTCRUISER,"Reborn Sith Light Cruiser"));
        ship.get(4).add(ShipFactory.makeShip(ShipType.LIGHTCRUISER,"Hapes Nova-class Battle Cruiser")); 
        ship.get(4).add(ShipFactory.makeShip(ShipType.LIGHTCRUISER,"Belarus-class Medium Cruiser"));
        ship.get(5).add(ShipFactory.makeShip(ShipType.FRIGATE,"Galactic Defense Frigate"));
        ship.get(5).add(ShipFactory.makeShip(ShipType.FRIGATE,"Ardent-class Frigate"));
        ship.get(5).add(ShipFactory.makeShip(ShipType.FRIGATE,"Sacheen-class Light Escort"));
        ship.get(5).add(ShipFactory.makeShip(ShipType.FRIGATE,"Republic Battle Frigate"));
        ship.get(5).add(ShipFactory.makeShip(ShipType.FRIGATE,"Imperial Battle Frigate")); 
        ship.get(4).add(ShipFactory.makeShip(ShipType.LIGHTCRUISER,"Carrack-class Light Cruiser"));
        ship.get(5).add(ShipFactory.makeShip(ShipType.FRIGATE,"Dogan Support Frigate"));
        ship.get(5).add(ShipFactory.makeShip(ShipType.FRIGATE,"Kaloth-class Battle Cruiser"));
        ship.get(5).add(ShipFactory.makeShip(ShipType.FRIGATE,"Class 1000 Cruiser"));
        ship.get(5).add(ShipFactory.makeShip(ShipType.FRIGATE,"Star Galleon-class Frigate"));
        ship.get(5).add(ShipFactory.makeShip(ShipType.FRIGATE,"Nebulon-B Frigate")); 
        ship.get(5).add(ShipFactory.makeShip(ShipType.FRIGATE,"Corona-class Frigate"));
        ship.get(5).add(ShipFactory.makeShip(ShipType.FRIGATE,"Nebulon-B2 Frigate"));
        ship.get(5).add(ShipFactory.makeShip(ShipType.FRIGATE,"Lancer-class Frigate"));
        ship.get(5).add(ShipFactory.makeShip(ShipType.FRIGATE,"Armadia-class Thrustship"));
        ship.get(5).add(ShipFactory.makeShip(ShipType.FRIGATE,"Bayonet-class Light Cruiser"));
        ship.get(6).add(ShipFactory.makeShip(ShipType.GUNSHIP,"Reborn Sith Gunship"));
        ship.get(6).add(ShipFactory.makeShip(ShipType.GUNSHIP,"Federation Assault Gunship")); 
        ship.get(6).add(ShipFactory.makeShip(ShipType.GUNSHIP,"Marauder Corvette"));
        ship.get(6).add(ShipFactory.makeShip(ShipType.GUNSHIP,"Warrior-class Gunship"));
        ship.get(6).add(ShipFactory.makeShip(ShipType.GUNSHIP,"Agave-class Picket Ship"));
        ship.get(6).add(ShipFactory.makeShip(ShipType.GUNSHIP,"Shunan Gunship"));
        ship.get(6).add(ShipFactory.makeShip(ShipType.GUNSHIP,"Corellian Corvette"));
        ship.get(6).add(ShipFactory.makeShip(ShipType.GUNSHIP,"Imperial Assault Gunship")); 
        ship.get(6).add(ShipFactory.makeShip(ShipType.GUNSHIP,"Assassin-class Corvette"));
        ship.get(6).add(ShipFactory.makeShip(ShipType.GUNSHIP,"Corellian Gunship"));
        ship.get(6).add(ShipFactory.makeShip(ShipType.GUNSHIP,"Old Republic Light Cruiser"));
        ship.get(6).add(ShipFactory.makeShip(ShipType.GUNSHIP,"Braha'tok-class Gunship"));
        ship.get(12).add(ShipFactory.makeShip(ShipType.PATROL,"Fw'sen-class Picket Ship"));
        ship.get(7).add(ShipFactory.makeShip(ShipType.HEAVYFIGHTER,"X-Wing")); 
        ship.get(10).add(ShipFactory.makeShip(ShipType.BOMBER,"Y-Wing"));
        ship.get(9).add(ShipFactory.makeShip(ShipType.INTERCEPTOR,"A-Wing"));
        ship.get(7).add(ShipFactory.makeShip(ShipType.HEAVYFIGHTER,"B-Wing"));
        ship.get(8).add(ShipFactory.makeShip(ShipType.LIGHTFIGHTER,"E-Wing"));
        ship.get(10).add(ShipFactory.makeShip(ShipType.BOMBER,"K-Wing"));
        ship.get(7).add(ShipFactory.makeShip(ShipType.HEAVYFIGHTER,"ARC-170")); 
        ship.get(8).add(ShipFactory.makeShip(ShipType.LIGHTFIGHTER,"UG Fighter"));
        ship.get(9).add(ShipFactory.makeShip(ShipType.INTERCEPTOR,"UG Interceptor"));
        ship.get(10).add(ShipFactory.makeShip(ShipType.BOMBER,"UG Bomber"));
        ship.get(8).add(ShipFactory.makeShip(ShipType.LIGHTFIGHTER,"TIE Fighter"));
        ship.get(9).add(ShipFactory.makeShip(ShipType.INTERCEPTOR,"TIE Interceptor"));
        ship.get(10).add(ShipFactory.makeShip(ShipType.BOMBER,"TIE Bomber")); 
        ship.get(7).add(ShipFactory.makeShip(ShipType.HEAVYFIGHTER,"TIE Defender"));
        ship.get(8).add(ShipFactory.makeShip(ShipType.LIGHTFIGHTER,"TIE Raptor"));
        ship.get(8).add(ShipFactory.makeShip(ShipType.LIGHTFIGHTER,"TIE Phantom"));
        ship.get(7).add(ShipFactory.makeShip(ShipType.HEAVYFIGHTER,"Reborn Sith Heavy Fighter"));
        ship.get(8).add(ShipFactory.makeShip(ShipType.LIGHTFIGHTER,"Reborn Sith Light Fighter"));
        ship.get(9).add(ShipFactory.makeShip(ShipType.INTERCEPTOR,"Reborn Sith Interceptor"));
        ship.get(10).add(ShipFactory.makeShip(ShipType.BOMBER,"Reborn Sith Bomber"));
        ship.get(2).add(ShipFactory.makeShip(ShipType.BATTLESHIP,"Victory II-class Star Destroyer"));
        ship.get(1).add(ShipFactory.makeShip(ShipType.CARRIER,"Secutor-class Star Destroyer"));
        ship.get(5).add(ShipFactory.makeShip(ShipType.FRIGATE,"Arquitens-class Light Cruiser"));
        ship.get(7).add(ShipFactory.makeShip(ShipType.HEAVYFIGHTER,"Bes'uliik"));
        ship.get(7).add(ShipFactory.makeShip(ShipType.HEAVYFIGHTER,"Aleph-class Starfighter"));
        ship.get(9).add(ShipFactory.makeShip(ShipType.INTERCEPTOR,"Eta-2 Actis-class Interceptor"));
        ship.get(9).add(ShipFactory.makeShip(ShipType.INTERCEPTOR,"Alpha-3 Nimbus-class V-wing Starfighter"));
        ship.get(9).add(ShipFactory.makeShip(ShipType.INTERCEPTOR,"Delta-7 Aethersprite-class Light Interceptor"));
        ship.get(9).add(ShipFactory.makeShip(ShipType.INTERCEPTOR,"A-9 Vigilance Interceptor"));
        ship.get(8).add(ShipFactory.makeShip(ShipType.LIGHTFIGHTER,"Belbullab-22 Starfighter"));
        ship.get(8).add(ShipFactory.makeShip(ShipType.LIGHTFIGHTER,"Droid Tri-Fighter"));
        ship.get(8).add(ShipFactory.makeShip(ShipType.LIGHTFIGHTER,"Z-95 Headhunter"));
        ship.get(8).add(ShipFactory.makeShip(ShipType.LIGHTFIGHTER,"N-1 Starfighter"));
        ship.get(8).add(ShipFactory.makeShip(ShipType.LIGHTFIGHTER,"Vulture-class Droid Starfighter"));
        ship.get(8).add(ShipFactory.makeShip(ShipType.LIGHTFIGHTER,"Miy'til Starfighter"));
        ship.get(8).add(ShipFactory.makeShip(ShipType.LIGHTFIGHTER,"Nssis-class Clawcraft"));
        ship.get(10).add(ShipFactory.makeShip(ShipType.BOMBER,"Hyena-class Bomber"));
        ship.get(7).add(ShipFactory.makeShip(ShipType.HEAVYFIGHTER,"CloakShape Fighter"));
        ship.get(10).add(ShipFactory.makeShip(ShipType.BOMBER,"Miy'til Assault Bomber"));
        ship.get(1).add(ShipFactory.makeShip(ShipType.CARRIER,"Quasar Fire-class Bulk Cruiser"));
        ship.get(8).add(ShipFactory.makeShip(ShipType.LIGHTFIGHTER,"Fang Fighter"));
        ship.get(8).add(ShipFactory.makeShip(ShipType.LIGHTFIGHTER,"Aurek-class Tactical Strikefighter"));
        ship.get(8).add(ShipFactory.makeShip(ShipType.LIGHTFIGHTER,"Rogue-class Starfighter"));
        ship.get(8).add(ShipFactory.makeShip(ShipType.LIGHTFIGHTER,"V-19 Torrent Starfighter"));
        ship.get(7).add(ShipFactory.makeShip(ShipType.HEAVYFIGHTER,"R-41 Starchaser"));
        ship.get(7).add(ShipFactory.makeShip(ShipType.HEAVYFIGHTER,"StarViper-class Attack Platform"));
        ship.get(7).add(ShipFactory.makeShip(ShipType.HEAVYFIGHTER,"Rihkxyrk Assault Fighter"));
        ship.get(7).add(ShipFactory.makeShip(ShipType.HEAVYFIGHTER,"Ixiyen-class Fast Attack Craft"));
        ship.get(10).add(ShipFactory.makeShip(ShipType.BOMBER,"GAT-12 Skipray Blastboat"));
        ship.get(8).add(ShipFactory.makeShip(ShipType.LIGHTFIGHTER,"I-7 Howlrunner"));
        ship.get(11).add(ShipFactory.makeShip(ShipType.FREIGHTER,"VCX-100 Light Freighter"));
        ship.get(11).add(ShipFactory.makeShip(ShipType.FREIGHTER,"YT-2400 Light Freighter"));
        ship.get(11).add(ShipFactory.makeShip(ShipType.FREIGHTER,"YT-2000 Light Freighter"));
        ship.get(11).add(ShipFactory.makeShip(ShipType.FREIGHTER,"YT-1300 Light Freighter"));
        ship.get(11).add(ShipFactory.makeShip(ShipType.FREIGHTER,"YT-1250 Freighter"));
        ship.get(11).add(ShipFactory.makeShip(ShipType.FREIGHTER,"Stathas-class Freighter"));
        ship.get(11).add(ShipFactory.makeShip(ShipType.FREIGHTER,"MC-18 Light Freighter"));
        ship.get(11).add(ShipFactory.makeShip(ShipType.FREIGHTER,"Simiyiar-class Light Freighter"));
        ship.get(12).add(ShipFactory.makeShip(ShipType.PATROL,"SS-54 Assault Ship"));
        ship.get(11).add(ShipFactory.makeShip(ShipType.FREIGHTER,"Stalwart-class Freighter"));
        ship.get(12).add(ShipFactory.makeShip(ShipType.PATROL,"RX4 Patrol Ship"));
        ship.get(12).add(ShipFactory.makeShip(ShipType.PATROL,"Mynock-class Assault Boat"));
        ship.get(12).add(ShipFactory.makeShip(ShipType.PATROL,"Firespray-31-class Attack Craft"));
        ship.get(12).add(ShipFactory.makeShip(ShipType.PATROL,"Pursuer-class Enforcement Ship"));
        ship.get(13).add(ShipFactory.makeShip(ShipType.TRANSPORT,"UT-60D U-wing Starfighter"));
        ship.get(12).add(ShipFactory.makeShip(ShipType.PATROL,"PB-950 Patrol Boat"));
        ship.get(12).add(ShipFactory.makeShip(ShipType.PATROL,"Law-class Light Patrol Craft"));
        ship.get(13).add(ShipFactory.makeShip(ShipType.TRANSPORT,"Beta-class ETR-3 Escort Transport"));
        ship.get(13).add(ShipFactory.makeShip(ShipType.TRANSPORT,"Delta-class DX-9 Stormtrooper Transport"));
        ship.get(13).add(ShipFactory.makeShip(ShipType.TRANSPORT,"Etti Lighter"));
        ship.get(13).add(ShipFactory.makeShip(ShipType.TRANSPORT,"Gamma-class ATR-6 Assault Transport"));
        ship.get(13).add(ShipFactory.makeShip(ShipType.TRANSPORT,"GR-75 Medium Transport"));
        ship.get(13).add(ShipFactory.makeShip(ShipType.TRANSPORT,"ILH-KK Citadel-class Civilian Cruiser"));
        ship.get(13).add(ShipFactory.makeShip(ShipType.TRANSPORT,"Kom'rk-class Transport"));
        ship.get(13).add(ShipFactory.makeShip(ShipType.TRANSPORT,"Loronar Medium Transport"));
        ship.get(13).add(ShipFactory.makeShip(ShipType.TRANSPORT,"Mobquet Medium Transport"));
        ship.get(13).add(ShipFactory.makeShip(ShipType.TRANSPORT,"Seltiss-1 Caravel"));
        ship.get(13).add(ShipFactory.makeShip(ShipType.TRANSPORT,"Shaadlar-type Troopship"));
        ship.get(13).add(ShipFactory.makeShip(ShipType.TRANSPORT,"VT-49 Decimator"));
        ship.get(13).add(ShipFactory.makeShip(ShipType.TRANSPORT,"Wayfarer-class Medium Transport"));
        ship.get(13).add(ShipFactory.makeShip(ShipType.TRANSPORT,"YZ-775 Medium Transport"));
        ship.get(14).add(ShipFactory.makeShip(ShipType.SHUTTLE,"Lambda-class T-4a Shuttle"));
        ship.get(14).add(ShipFactory.makeShip(ShipType.SHUTTLE,"Aegis-class Combat Shuttle"));
        ship.get(14).add(ShipFactory.makeShip(ShipType.SHUTTLE,"Delta-class JV-7 Escort Shuttle"));
        ship.get(14).add(ShipFactory.makeShip(ShipType.SHUTTLE,"Flarestar-class Attack Shuttle"));
        ship.get(14).add(ShipFactory.makeShip(ShipType.SHUTTLE,"Nu-class Attack Shuttle"));
        ship.get(14).add(ShipFactory.makeShip(ShipType.SHUTTLE,"Sentinel-class Landing Craft"));
        ship.get(14).add(ShipFactory.makeShip(ShipType.SHUTTLE,"Upsilon-class Command Shuttle"));
        ship.get(14).add(ShipFactory.makeShip(ShipType.SHUTTLE,"Sheathipede-class Transport Shuttle"));
        ship.get(14).add(ShipFactory.makeShip(ShipType.SHUTTLE,"Sigma-class Shuttle"));
        ship.get(14).add(ShipFactory.makeShip(ShipType.SHUTTLE,"Low Altitude Assault Transport"));
        ship.get(14).add(ShipFactory.makeShip(ShipType.SHUTTLE,"BR-23 Courier"));
        ship.get(14).add(ShipFactory.makeShip(ShipType.SHUTTLE,"Y-4 Raptor-class Transport"));
        ship.get(13).add(ShipFactory.makeShip(ShipType.TRANSPORT,"CR25 Troop Carrier"));
        ship.get(11).add(ShipFactory.makeShip(ShipType.FREIGHTER,"YV-865 Aurore-class Freighter"));
        ship.get(5).add(ShipFactory.makeShip(ShipType.FRIGATE,"Pelta-class Frigate"));
        ship.get(6).add(ShipFactory.makeShip(ShipType.GUNSHIP,"Consular-class Cruiser"));
        ship.get(14).add(ShipFactory.makeShip(ShipType.SHUTTLE,"Delta-class T-3c Shuttle"));

        long creditLimit = setup.getCreditLimit();
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
            int g1 = fleet1.groundCombat();
            int g2 = fleet2.groundCombat();
            fleet1.groundDead(g2);
            fleet2.groundDead(g1);
            counter++;
            fleet1.combat(fleet2.getFleet().get(0), counter);
            fleet2.combat(fleet1.getFleet().get(0), counter);
            fleet1.repair();
            fleet2.repair();
            fleet1.collectFleetStats();
            fleet2.collectFleetStats();
            reports.newReport(counter,fleet1.getTotalTroops(),fleet2.getTotalTroops(),fleet1.getholdCount(),fleet1.getShipType(),fleet1.getDamageCount(),fleet1.getMessages(),fleet2.getholdCount(),fleet2.getShipType(),fleet2.getDamageCount(),fleet2.getMessages());
        }while(!fleet1.getFleet().get(0).isEmpty() && !fleet2.getFleet().get(0).isEmpty() && counter < roundLimit);
        //Declare Winner          
        long endTime   = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        if(counter == roundLimit){
            Winner winner = new Winner(0, counter,totalTime);
        }else if(fleet1.getFleet().get(0).isEmpty() && !fleet2.getFleet().get(0).isEmpty()){
            Winner winner = new Winner(2, counter,totalTime);
        }else if(!fleet1.getFleet().get(0).isEmpty() && fleet2.getFleet().get(0).isEmpty()){
            Winner winner = new Winner(1, counter,totalTime);
        }else if(fleet1.getFleet().get(0).isEmpty() && fleet2.getFleet().get(0).isEmpty()){
            Winner winner = new Winner(0, counter,totalTime);
        }
        //Show Fleet Statistics
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