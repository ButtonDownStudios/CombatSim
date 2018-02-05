import javax.swing.*;
import java.awt.*;
public class NewTroopPanel extends TroopPanel{

    public NewTroopPanel(){
        super();
        fill();
    }

    public void fill(){
        String[] armors = new String[8];
        String[] weapons = new String[13];
        JComboBox wSelect = new JComboBox(weapons);
        JComboBox aSelect = new JComboBox(armors);
        armorType.add(aSelect);
        weaponType.add(wSelect);
        JButton newType = new JButton("Add New");
        south.add(newType);
    }
}
