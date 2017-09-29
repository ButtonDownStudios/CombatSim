import java.io.*;

public class ShipFactory {

    public static Ship makeShip(ShipType shipType, String shipClass){
        switch(shipType){
            case DREADNOUGHT:
            return new CapitalShip(shipType, dreadnoughtStat(shipClass), dreadnoughtWeapons(shipClass));
            case CARRIER:
            return new CapitalShip(shipType, carrierStat(shipClass), carrierWeapons(shipClass));
            case BATTLESHIP:
            return new CapitalShip(shipType, battleshipStat(shipClass), battleshipWeapons(shipClass));
            case HEAVYCRUISER:
            return new CapitalShip(shipType, heavycruiserStat(shipClass), heavycruiserWeapons(shipClass));
            case LIGHTCRUISER:
            return new CapitalShip(shipType, lightcruiserStat(shipClass), lightcruiserWeapons(shipClass));
            case FRIGATE:
            return new CapitalShip(shipType, frigateStat(shipClass), frigateWeapons(shipClass));
            case GUNSHIP:
            return new CapitalShip(shipType, gunshipStat(shipClass), gunshipWeapons(shipClass));
            case FREIGHTER:
            return new CapitalShip(shipType, freighterStat(shipClass), freighterWeapons(shipClass));
            case PATROL:
            return new CapitalShip(shipType, patrolStat(shipClass), patrolWeapons(shipClass));
            case TRANSPORT:
            return new CapitalShip(shipType, transportStat(shipClass), transportWeapons(shipClass));
            case HEAVYFIGHTER:
            return new StarFighter(shipType, heavyfighterStat(shipClass), heavyfighterWeapons(shipClass));
            case LIGHTFIGHTER:
            return new StarFighter(shipType, lightfighterStat(shipClass), lightfighterWeapons(shipClass));
            case INTERCEPTOR:
            return new StarFighter(shipType, interceptorStat(shipClass), interceptorWeapons(shipClass));
            case BOMBER:
            return new StarFighter(shipType, bomberStat(shipClass), bomberWeapons(shipClass));
            case SHUTTLE:
            return new StarFighter(shipType, shuttleStat(shipClass), shuttleWeapons(shipClass));
        }
        return null;
    }

    public static String[] dreadnoughtStat(String shipClass){
        BufferedReader dreadnought;
        try{
            dreadnought = new BufferedReader(new FileReader("DreadnoughtStats.txt"));
            try{
                String fileRead = dreadnought.readLine();
                // loop until all lines are read
                while (fileRead != null){
                    // use string.split to load a string array with the values from each line of
                    // the file, using a comma as the delimiter
                    String[] tokenize = fileRead.split(",");
                    // assume file is made correctly
                    String tempRace = tokenize[0];
                    if(tempRace.equals(shipClass)){
                        dreadnought.close();
                        return tokenize;
                    }
                    fileRead = dreadnought.readLine();
                }
                // close file stream
                dreadnought.close();
                return null;
            }
            catch (IOException ioe)
            {
                ioe.printStackTrace();
                return null;
            }
        }
        catch (FileNotFoundException fnfe)
        {
            System.out.println("file not found");
            return null;
        }
    }

    public static String[] dreadnoughtWeapons(String shipClass){
        BufferedReader dreadnought;
        try{
            dreadnought = new BufferedReader(new FileReader("DreadnoughtWeapons.txt"));
            try{
                String fileRead = dreadnought.readLine();
                // loop until all lines are read
                while (fileRead != null){
                    // use string.split to load a string array with the values from each line of
                    // the file, using a comma as the delimiter
                    String[] tokenize = fileRead.split(",");
                    // assume file is made correctly
                    String tempRace = tokenize[0];
                    if(tempRace.equals(shipClass)){
                        dreadnought.close();
                        return tokenize;
                    }
                    fileRead = dreadnought.readLine();
                }
                // close file stream
                dreadnought.close();
                return null;
            }
            catch (IOException ioe)
            {
                ioe.printStackTrace();
                return null;
            }
        }
        catch (FileNotFoundException fnfe)
        {
            System.out.println("file not found");
            return null;
        }
    }

    public static String[] carrierStat(String shipClass){
        BufferedReader carrier;
        try{
            carrier = new BufferedReader(new FileReader("CarrierStats.txt"));
            try{
                String fileRead = carrier.readLine();
                // loop until all lines are read
                while (fileRead != null){
                    // use string.split to load a string array with the values from each line of
                    // the file, using a comma as the delimiter
                    String[] tokenize = fileRead.split(",");
                    // assume file is made correctly
                    String tempRace = tokenize[0];
                    if(tempRace.equals(shipClass)){
                        carrier.close();
                        return tokenize;
                    }
                    fileRead = carrier.readLine();
                }
                // close file stream
                carrier.close();
                return null;
            }
            catch (IOException ioe)
            {
                ioe.printStackTrace();
                return null;
            }
        }
        catch (FileNotFoundException fnfe)
        {
            System.out.println("file not found");
            return null;
        }
    }

    public static String[] carrierWeapons(String shipClass){
        BufferedReader carrier;
        try{
            carrier = new BufferedReader(new FileReader("CarrierWeapons.txt"));
            try{
                String fileRead = carrier.readLine();
                // loop until all lines are read
                while (fileRead != null){
                    // use string.split to load a string array with the values from each line of
                    // the file, using a comma as the delimiter
                    String[] tokenize = fileRead.split(",");
                    // assume file is made correctly
                    String tempRace = tokenize[0];
                    if(tempRace.equals(shipClass)){
                        carrier.close();
                        return tokenize;
                    }
                    fileRead = carrier.readLine();
                }
                // close file stream
                carrier.close();
                return null;
            }
            catch (IOException ioe)
            {
                ioe.printStackTrace();
                return null;
            }
        }
        catch (FileNotFoundException fnfe)
        {
            System.out.println("file not found");
            return null;
        }
    }

    public static String[] battleshipStat(String shipClass){
        BufferedReader battleship;
        try{
            battleship = new BufferedReader(new FileReader("BattleShipStats.txt"));
            try{
                String fileRead = battleship.readLine();
                // loop until all lines are read
                while (fileRead != null){
                    // use string.split to load a string array with the values from each line of
                    // the file, using a comma as the delimiter
                    String[] tokenize = fileRead.split(",");
                    // assume file is made correctly
                    String tempRace = tokenize[0];
                    if(tempRace.equals(shipClass)){
                        battleship.close();
                        return tokenize;
                    }
                    fileRead = battleship.readLine();
                }
                // close file stream
                battleship.close();
                return null;
            }
            catch (IOException ioe)
            {
                ioe.printStackTrace();
                return null;
            }
        }
        catch (FileNotFoundException fnfe)
        {
            System.out.println("file not found");
            return null;
        }
    }

    public static String[] battleshipWeapons(String shipClass){
        BufferedReader battleship;
        try{
            battleship = new BufferedReader(new FileReader("BattleShipWeapons.txt"));
            try{
                String fileRead = battleship.readLine();
                // loop until all lines are read
                while (fileRead != null){
                    // use string.split to load a string array with the values from each line of
                    // the file, using a comma as the delimiter
                    String[] tokenize = fileRead.split(",");
                    // assume file is made correctly
                    String tempRace = tokenize[0];
                    if(tempRace.equals(shipClass)){
                        battleship.close();
                        return tokenize;
                    }
                    fileRead = battleship.readLine();
                }
                // close file stream
                battleship.close();
                return null;
            }
            catch (IOException ioe)
            {
                ioe.printStackTrace();
                return null;
            }
        }
        catch (FileNotFoundException fnfe)
        {
            System.out.println("file not found");
            return null;
        }
    }

    public static String[] heavycruiserStat(String shipClass){
        BufferedReader heavycruiser;
        try{
            heavycruiser = new BufferedReader(new FileReader("HeavyCruiserStats.txt"));
            try{
                String fileRead = heavycruiser.readLine();
                // loop until all lines are read
                while (fileRead != null){
                    // use string.split to load a string array with the values from each line of
                    // the file, using a comma as the delimiter
                    String[] tokenize = fileRead.split(",");
                    // assume file is made correctly
                    String tempRace = tokenize[0];
                    if(tempRace.equals(shipClass)){
                        heavycruiser.close();
                        return tokenize;
                    }
                    fileRead = heavycruiser.readLine();
                }
                // close file stream
                heavycruiser.close();
                return null;
            }
            catch (IOException ioe)
            {
                ioe.printStackTrace();
                return null;
            }
        }
        catch (FileNotFoundException fnfe)
        {
            System.out.println("file not found");
            return null;
        }
    }

    public static String[] heavycruiserWeapons(String shipClass){
        BufferedReader heavycruiser;
        try{
            heavycruiser = new BufferedReader(new FileReader("HeavyCruiserWeapons.txt"));
            try{
                String fileRead = heavycruiser.readLine();
                // loop until all lines are read
                while (fileRead != null){
                    // use string.split to load a string array with the values from each line of
                    // the file, using a comma as the delimiter
                    String[] tokenize = fileRead.split(",");
                    // assume file is made correctly
                    String tempRace = tokenize[0];
                    if(tempRace.equals(shipClass)){
                        heavycruiser.close();
                        return tokenize;
                    }
                    fileRead = heavycruiser.readLine();
                }
                // close file stream
                heavycruiser.close();
                return null;
            }
            catch (IOException ioe)
            {
                ioe.printStackTrace();
                return null;
            }
        }
        catch (FileNotFoundException fnfe)
        {
            System.out.println("file not found");
            return null;
        }
    }

    public static String[] lightcruiserStat(String shipClass){
        BufferedReader lightcruiser;
        try{
            lightcruiser = new BufferedReader(new FileReader("LightCruiserStats.txt"));
            try{
                String fileRead = lightcruiser.readLine();
                // loop until all lines are read
                while (fileRead != null){
                    // use string.split to load a string array with the values from each line of
                    // the file, using a comma as the delimiter
                    String[] tokenize = fileRead.split(",");
                    // assume file is made correctly
                    String tempRace = tokenize[0];
                    if(tempRace.equals(shipClass)){
                        lightcruiser.close();
                        return tokenize;
                    }
                    fileRead = lightcruiser.readLine();
                }
                // close file stream
                lightcruiser.close();
                return null;
            }
            catch (IOException ioe)
            {
                ioe.printStackTrace();
                return null;
            }
        }
        catch (FileNotFoundException fnfe)
        {
            System.out.println("file not found");
            return null;
        }
    }

    public static String[] lightcruiserWeapons(String shipClass){
        BufferedReader lightcruiser;
        try{
            lightcruiser = new BufferedReader(new FileReader("LightCruiserWeapons.txt"));
            try{
                String fileRead = lightcruiser.readLine();
                // loop until all lines are read
                while (fileRead != null){
                    // use string.split to load a string array with the values from each line of
                    // the file, using a comma as the delimiter
                    String[] tokenize = fileRead.split(",");
                    // assume file is made correctly
                    String tempRace = tokenize[0];
                    if(tempRace.equals(shipClass)){
                        lightcruiser.close();
                        return tokenize;
                    }
                    fileRead = lightcruiser.readLine();
                }
                // close file stream
                lightcruiser.close();
                return null;
            }
            catch (IOException ioe)
            {
                ioe.printStackTrace();
                return null;
            }
        }
        catch (FileNotFoundException fnfe)
        {
            System.out.println("file not found");
            return null;
        }
    }

    public static String[] frigateStat(String shipClass){
        BufferedReader frigate;
        try{
            frigate = new BufferedReader(new FileReader("FrigateStats.txt"));
            try{
                String fileRead = frigate.readLine();
                // loop until all lines are read
                while (fileRead != null){
                    // use string.split to load a string array with the values from each line of
                    // the file, using a comma as the delimiter
                    String[] tokenize = fileRead.split(",");
                    // assume file is made correctly
                    String tempRace = tokenize[0];
                    if(tempRace.equals(shipClass)){
                        frigate.close();
                        return tokenize;
                    }
                    fileRead = frigate.readLine();
                }
                // close file stream
                frigate.close();
                return null;
            }
            catch (IOException ioe)
            {
                ioe.printStackTrace();
                return null;
            }
        }
        catch (FileNotFoundException fnfe)
        {
            System.out.println("file not found");
            return null;
        }
    }

    public static String[] frigateWeapons(String shipClass){
        BufferedReader frigate;
        try{
            frigate = new BufferedReader(new FileReader("FrigateWeapons.txt"));
            try{
                String fileRead = frigate.readLine();
                // loop until all lines are read
                while (fileRead != null){
                    // use string.split to load a string array with the values from each line of
                    // the file, using a comma as the delimiter
                    String[] tokenize = fileRead.split(",");
                    // assume file is made correctly
                    String tempRace = tokenize[0];
                    if(tempRace.equals(shipClass)){
                        frigate.close();
                        return tokenize;
                    }
                    fileRead = frigate.readLine();
                }
                // close file stream
                frigate.close();
                return null;
            }
            catch (IOException ioe)
            {
                ioe.printStackTrace();
                return null;
            }
        }
        catch (FileNotFoundException fnfe)
        {
            System.out.println("file not found");
            return null;
        }
    }

    public static String[] gunshipStat(String shipClass){
        BufferedReader gunship;
        try{
            gunship = new BufferedReader(new FileReader("GunShipStats.txt"));
            try{
                String fileRead = gunship.readLine();
                // loop until all lines are read
                while (fileRead != null){
                    // use string.split to load a string array with the values from each line of
                    // the file, using a comma as the delimiter
                    String[] tokenize = fileRead.split(",");
                    // assume file is made correctly
                    String tempRace = tokenize[0];
                    if(tempRace.equals(shipClass)){
                        gunship.close();
                        return tokenize;
                    }
                    fileRead = gunship.readLine();
                }
                // close file stream
                gunship.close();
                return null;
            }
            catch (IOException ioe)
            {
                ioe.printStackTrace();
                return null;
            }
        }
        catch (FileNotFoundException fnfe)
        {
            System.out.println("file not found");
            return null;
        }
    }

    public static String[] gunshipWeapons(String shipClass){
        BufferedReader gunship;
        try{
            gunship = new BufferedReader(new FileReader("GunShipWeapons.txt"));
            try{
                String fileRead = gunship.readLine();
                // loop until all lines are read
                while (fileRead != null){
                    // use string.split to load a string array with the values from each line of
                    // the file, using a comma as the delimiter
                    String[] tokenize = fileRead.split(",");
                    // assume file is made correctly
                    String tempRace = tokenize[0];
                    if(tempRace.equals(shipClass)){
                        gunship.close();
                        return tokenize;
                    }
                    fileRead = gunship.readLine();
                }
                // close file stream
                gunship.close();
                return null;
            }
            catch (IOException ioe)
            {
                ioe.printStackTrace();
                return null;
            }
        }
        catch (FileNotFoundException fnfe)
        {
            System.out.println("file not found");
            return null;
        }
    }

    public static String[] freighterStat(String shipClass){
        BufferedReader freighter;
        try{
            freighter = new BufferedReader(new FileReader("FreighterStats.txt"));
            try{
                String fileRead = freighter.readLine();
                // loop until all lines are read
                while (fileRead != null){
                    // use string.split to load a string array with the values from each line of
                    // the file, using a comma as the delimiter
                    String[] tokenize = fileRead.split(",");
                    // assume file is made correctly
                    String tempRace = tokenize[0];
                    if(tempRace.equals(shipClass)){
                        freighter.close();
                        return tokenize;
                    }
                    fileRead = freighter.readLine();
                }
                // close file stream
                freighter.close();
                return null;
            }
            catch (IOException ioe)
            {
                ioe.printStackTrace();
                return null;
            }
        }
        catch (FileNotFoundException fnfe)
        {
            System.out.println("file not found");
            return null;
        }
    }

    public static String[] freighterWeapons(String shipClass){
        BufferedReader freighter;
        try{
            freighter = new BufferedReader(new FileReader("FreighterWeapons.txt"));
            try{
                String fileRead = freighter.readLine();
                // loop until all lines are read
                while (fileRead != null){
                    // use string.split to load a string array with the values from each line of
                    // the file, using a comma as the delimiter
                    String[] tokenize = fileRead.split(",");
                    // assume file is made correctly
                    String tempRace = tokenize[0];
                    if(tempRace.equals(shipClass)){
                        freighter.close();
                        return tokenize;
                    }
                    fileRead = freighter.readLine();
                }
                // close file stream
                freighter.close();
                return null;
            }
            catch (IOException ioe)
            {
                ioe.printStackTrace();
                return null;
            }
        }
        catch (FileNotFoundException fnfe)
        {
            System.out.println("file not found");
            return null;
        }
    }

    public static String[] patrolStat(String shipClass){
        BufferedReader patrol;
        try{
            patrol = new BufferedReader(new FileReader("PatrolStats.txt"));
            try{
                String fileRead = patrol.readLine();
                // loop until all lines are read
                while (fileRead != null){
                    // use string.split to load a string array with the values from each line of
                    // the file, using a comma as the delimiter
                    String[] tokenize = fileRead.split(",");
                    // assume file is made correctly
                    String tempRace = tokenize[0];
                    if(tempRace.equals(shipClass)){
                        patrol.close();
                        return tokenize;
                    }
                    fileRead = patrol.readLine();
                }
                // close file stream
                patrol.close();
                return null;
            }
            catch (IOException ioe)
            {
                ioe.printStackTrace();
                return null;
            }
        }
        catch (FileNotFoundException fnfe)
        {
            System.out.println("file not found");
            return null;
        }
    }

    public static String[] patrolWeapons(String shipClass){
        BufferedReader patrol;
        try{
            patrol = new BufferedReader(new FileReader("PatrolWeapons.txt"));
            try{
                String fileRead = patrol.readLine();
                // loop until all lines are read
                while (fileRead != null){
                    // use string.split to load a string array with the values from each line of
                    // the file, using a comma as the delimiter
                    String[] tokenize = fileRead.split(",");
                    // assume file is made correctly
                    String tempRace = tokenize[0];
                    if(tempRace.equals(shipClass)){
                        patrol.close();
                        return tokenize;
                    }
                    fileRead = patrol.readLine();
                }
                // close file stream
                patrol.close();
                return null;
            }
            catch (IOException ioe)
            {
                ioe.printStackTrace();
                return null;
            }
        }
        catch (FileNotFoundException fnfe)
        {
            System.out.println("file not found");
            return null;
        }
    }
    
     public static String[] transportStat(String shipClass){
        BufferedReader transport;
        try{
            transport = new BufferedReader(new FileReader("TransportStats.txt"));
            try{
                String fileRead = transport.readLine();
                // loop until all lines are read
                while (fileRead != null){
                    // use string.split to load a string array with the values from each line of
                    // the file, using a comma as the delimiter
                    String[] tokenize = fileRead.split(",");
                    // assume file is made correctly
                    String tempRace = tokenize[0];
                    if(tempRace.equals(shipClass)){
                        transport.close();
                        return tokenize;
                    }
                    fileRead = transport.readLine();
                }
                // close file stream
                transport.close();
                return null;
            }
            catch (IOException ioe)
            {
                ioe.printStackTrace();
                return null;
            }
        }
        catch (FileNotFoundException fnfe)
        {
            System.out.println("file not found");
            return null;
        }
    }

    public static String[] transportWeapons(String shipClass){
        BufferedReader transport;
        try{
            transport = new BufferedReader(new FileReader("TransportWeapons.txt"));
            try{
                String fileRead = transport.readLine();
                // loop until all lines are read
                while (fileRead != null){
                    // use string.split to load a string array with the values from each line of
                    // the file, using a comma as the delimiter
                    String[] tokenize = fileRead.split(",");
                    // assume file is made correctly
                    String tempRace = tokenize[0];
                    if(tempRace.equals(shipClass)){
                        transport.close();
                        return tokenize;
                    }
                    fileRead = transport.readLine();
                }
                // close file stream
                transport.close();
                return null;
            }
            catch (IOException ioe)
            {
                ioe.printStackTrace();
                return null;
            }
        }
        catch (FileNotFoundException fnfe)
        {
            System.out.println("file not found");
            return null;
        }
    }

    public static String[] heavyfighterStat(String shipClass){
        BufferedReader heavyfighter;
        try{
            heavyfighter = new BufferedReader(new FileReader("HeavyFighterStats.txt"));
            try{
                String fileRead = heavyfighter.readLine();
                // loop until all lines are read
                while (fileRead != null){
                    // use string.split to load a string array with the values from each line of
                    // the file, using a comma as the delimiter
                    String[] tokenize = fileRead.split(",");
                    // assume file is made correctly
                    String tempRace = tokenize[0];
                    if(tempRace.equals(shipClass)){
                        heavyfighter.close();
                        return tokenize;
                    }
                    fileRead = heavyfighter.readLine();
                }
                // close file stream
                heavyfighter.close();
                return null;
            }
            catch (IOException ioe)
            {
                ioe.printStackTrace();
                return null;
            }
        }
        catch (FileNotFoundException fnfe)
        {
            System.out.println("file not found");
            return null;
        }
    }

    public static String[] heavyfighterWeapons(String shipClass){
        BufferedReader heavyfighter;
        try{
            heavyfighter = new BufferedReader(new FileReader("HeavyFighterWeapons.txt"));
            try{
                String fileRead = heavyfighter.readLine();
                // loop until all lines are read
                while (fileRead != null){
                    // use string.split to load a string array with the values from each line of
                    // the file, using a comma as the delimiter
                    String[] tokenize = fileRead.split(",");
                    // assume file is made correctly
                    String tempRace = tokenize[0];
                    if(tempRace.equals(shipClass)){
                        heavyfighter.close();
                        return tokenize;
                    }
                    fileRead = heavyfighter.readLine();
                }
                // close file stream
                heavyfighter.close();
                return null;
            }
            catch (IOException ioe)
            {
                ioe.printStackTrace();
                return null;
            }
        }
        catch (FileNotFoundException fnfe)
        {
            System.out.println("file not found");
            return null;
        }
    }

    public static String[] lightfighterStat(String shipClass){
        BufferedReader lightfighter;
        try{
            lightfighter = new BufferedReader(new FileReader("LightFighterStats.txt"));
            try{
                String fileRead = lightfighter.readLine();
                // loop until all lines are read
                while (fileRead != null){
                    // use string.split to load a string array with the values from each line of
                    // the file, using a comma as the delimiter
                    String[] tokenize = fileRead.split(",");
                    // assume file is made correctly
                    String tempRace = tokenize[0];
                    if(tempRace.equals(shipClass)){
                        lightfighter.close();
                        return tokenize;
                    }
                    fileRead = lightfighter.readLine();
                }
                // close file stream
                lightfighter.close();
                return null;
            }
            catch (IOException ioe)
            {
                ioe.printStackTrace();
                return null;
            }
        }
        catch (FileNotFoundException fnfe)
        {
            System.out.println("file not found");
            return null;
        }
    }

    public static String[] lightfighterWeapons(String shipClass){
        BufferedReader lightfighter;
        try{
            lightfighter = new BufferedReader(new FileReader("LightFighterWeapons.txt"));
            try{
                String fileRead = lightfighter.readLine();
                // loop until all lines are read
                while (fileRead != null){
                    // use string.split to load a string array with the values from each line of
                    // the file, using a comma as the delimiter
                    String[] tokenize = fileRead.split(",");
                    // assume file is made correctly
                    String tempRace = tokenize[0];
                    if(tempRace.equals(shipClass)){
                        lightfighter.close();
                        return tokenize;
                    }
                    fileRead = lightfighter.readLine();
                }
                // close file stream
                lightfighter.close();
                return null;
            }
            catch (IOException ioe)
            {
                ioe.printStackTrace();
                return null;
            }
        }
        catch (FileNotFoundException fnfe)
        {
            System.out.println("file not found");
            return null;
        }
    }

    public static String[] interceptorStat(String shipClass){
        BufferedReader interceptor;
        try{
            interceptor = new BufferedReader(new FileReader("InterceptorStats.txt"));
            try{
                String fileRead = interceptor.readLine();
                // loop until all lines are read
                while (fileRead != null){
                    // use string.split to load a string array with the values from each line of
                    // the file, using a comma as the delimiter
                    String[] tokenize = fileRead.split(",");
                    // assume file is made correctly
                    String tempRace = tokenize[0];
                    if(tempRace.equals(shipClass)){
                        interceptor.close();
                        return tokenize;
                    }
                    fileRead = interceptor.readLine();
                }
                // close file stream
                interceptor.close();
                return null;
            }
            catch (IOException ioe)
            {
                ioe.printStackTrace();
                return null;
            }
        }
        catch (FileNotFoundException fnfe)
        {
            System.out.println("file not found");
            return null;
        }
    }

    public static String[] interceptorWeapons(String shipClass){
        BufferedReader interceptor;
        try{
            interceptor = new BufferedReader(new FileReader("InterceptorWeapons.txt"));
            try{
                String fileRead = interceptor.readLine();
                // loop until all lines are read
                while (fileRead != null){
                    // use string.split to load a string array with the values from each line of
                    // the file, using a comma as the delimiter
                    String[] tokenize = fileRead.split(",");
                    // assume file is made correctly
                    String tempRace = tokenize[0];
                    if(tempRace.equals(shipClass)){
                        interceptor.close();
                        return tokenize;
                    }
                    fileRead = interceptor.readLine();
                }
                // close file stream
                interceptor.close();
                return null;
            }
            catch (IOException ioe)
            {
                ioe.printStackTrace();
                return null;
            }
        }
        catch (FileNotFoundException fnfe)
        {
            System.out.println("file not found");
            return null;
        }
    }

    public static String[] bomberStat(String shipClass){
        BufferedReader bomber;
        try{
            bomber = new BufferedReader(new FileReader("BomberStats.txt"));
            try{
                String fileRead = bomber.readLine();
                // loop until all lines are read
                while (fileRead != null){
                    // use string.split to load a string array with the values from each line of
                    // the file, using a comma as the delimiter
                    String[] tokenize = fileRead.split(",");
                    // assume file is made correctly
                    String tempRace = tokenize[0];
                    if(tempRace.equals(shipClass)){
                        bomber.close();
                        return tokenize;
                    }
                    fileRead = bomber.readLine();
                }
                // close file stream
                bomber.close();
                return null;
            }
            catch (IOException ioe)
            {
                ioe.printStackTrace();
                return null;
            }
        }
        catch (FileNotFoundException fnfe)
        {
            System.out.println("file not found");
            return null;
        }
    }

    public static String[] bomberWeapons(String shipClass){
        BufferedReader bomber;
        try{
            bomber = new BufferedReader(new FileReader("BomberWeapons.txt"));
            try{
                String fileRead = bomber.readLine();
                // loop until all lines are read
                while (fileRead != null){
                    // use string.split to load a string array with the values from each line of
                    // the file, using a comma as the delimiter
                    String[] tokenize = fileRead.split(",");
                    // assume file is made correctly
                    String tempRace = tokenize[0];
                    if(tempRace.equals(shipClass)){
                        bomber.close();
                        return tokenize;
                    }
                    fileRead = bomber.readLine();
                }
                // close file stream
                bomber.close();
                return null;
            }
            catch (IOException ioe)
            {
                ioe.printStackTrace();
                return null;
            }
        }
        catch (FileNotFoundException fnfe)
        {
            System.out.println("file not found");
            return null;
        }
    }
    
    public static String[] shuttleStat(String shipClass){
        BufferedReader shuttle;
        try{
            shuttle = new BufferedReader(new FileReader("ShuttleStats.txt"));
            try{
                String fileRead = shuttle.readLine();
                // loop until all lines are read
                while (fileRead != null){
                    // use string.split to load a string array with the values from each line of
                    // the file, using a comma as the delimiter
                    String[] tokenize = fileRead.split(",");
                    // assume file is made correctly
                    String tempRace = tokenize[0];
                    if(tempRace.equals(shipClass)){
                        shuttle.close();
                        return tokenize;
                    }
                    fileRead = shuttle.readLine();
                }
                // close file stream
                shuttle.close();
                return null;
            }
            catch (IOException ioe)
            {
                ioe.printStackTrace();
                return null;
            }
        }
        catch (FileNotFoundException fnfe)
        {
            System.out.println("file not found");
            return null;
        }
    }

    public static String[] shuttleWeapons(String shipClass){
        BufferedReader shuttle;
        try{
            shuttle = new BufferedReader(new FileReader("ShuttleWeapons.txt"));
            try{
                String fileRead = shuttle.readLine();
                // loop until all lines are read
                while (fileRead != null){
                    // use string.split to load a string array with the values from each line of
                    // the file, using a comma as the delimiter
                    String[] tokenize = fileRead.split(",");
                    // assume file is made correctly
                    String tempRace = tokenize[0];
                    if(tempRace.equals(shipClass)){
                        shuttle.close();
                        return tokenize;
                    }
                    fileRead = shuttle.readLine();
                }
                // close file stream
                shuttle.close();
                return null;
            }
            catch (IOException ioe)
            {
                ioe.printStackTrace();
                return null;
            }
        }
        catch (FileNotFoundException fnfe)
        {
            System.out.println("file not found");
            return null;
        }
    }
}