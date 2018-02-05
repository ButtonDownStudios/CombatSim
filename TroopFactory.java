import java.io.*;

public class TroopFactory{
    
    public static TroopWeapon makeWeapon(String type){
        return new TroopWeapon(weaponStat(type));
    }
    
    public static String[] weaponStat(String type){
        BufferedReader weapon;
        try{
            weapon = new BufferedReader(new FileReader("C:\\Users\\Mole\\IdeaProjects\\Combat Sim\\rec\\TroopWeapons.txt"));
            try{
                String fileRead = weapon.readLine();
                // loop until all lines are read
                while (fileRead != null){
                    // use string.split to load a string array with the values from each line of
                    // the file, using a comma as the delimiter
                    String[] tokenize = fileRead.split(",");
                    // assume file is made correctly
                    String tempRace = tokenize[0];
                    if(tempRace.equals(type)){
                        weapon.close();
                        return tokenize;
                    }
                    fileRead = weapon.readLine();
                }
                // close file stream
                weapon.close();
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
    
    public static TroopArmor makeArmor(String type){
        return new TroopArmor(armorStat(type));
    }
    
    public static String[] armorStat(String type){
        BufferedReader armor;
        try{
            armor = new BufferedReader(new FileReader("C:\\Users\\Mole\\IdeaProjects\\Combat Sim\\rec\\TroopArmor.txt"));
            try{
                String fileRead = armor.readLine();
                // loop until all lines are read
                while (fileRead != null){
                    // use string.split to load a string array with the values from each line of
                    // the file, using a comma as the delimiter
                    String[] tokenize = fileRead.split(",");
                    // assume file is made correctly
                    String tempRace = tokenize[0];
                    if(tempRace.equals(type)){
                        armor.close();
                        return tokenize;
                    }
                    fileRead = armor.readLine();
                }
                // close file stream
                armor.close();
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
