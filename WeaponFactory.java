import java.io.*;

public class WeaponFactory{
    
    public static Weapon makeWeapon(String type){
        return new Weapon(weaponStat(type));
    }
    
    public static String[] weaponStat(String type){
        BufferedReader weapon;
        try{
            weapon = new BufferedReader(new FileReader("Weapon.txt"));
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
}
