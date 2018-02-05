import javax.swing.*;
import java.awt.*;
/**
 * Created by Mole on 10/14/2017.
 */
public abstract class TroopPanel{

    protected JPanel content;
    protected JPanel weaponType;
    protected JPanel armorType;
    protected JPanel armor;
    protected JPanel damage;
    protected JPanel accAssist;
    protected JPanel accuracy;
    protected JPanel south;

    public TroopPanel() {
        content = new JPanel();
        weaponType = new JPanel();
        armorType = new JPanel();
        armor = new JPanel();
        damage = new JPanel();
        accAssist = new JPanel();
        accuracy = new JPanel();
        south = new JPanel();
        contentLayout();
        fillContent();
    }

    public void contentLayout(){
        content.setLayout(new BorderLayout());
        JPanel stat = new JPanel();
        stat.setLayout(new GridLayout(3,2));
        weaponType.setLayout(new GridLayout(1,2));
        armorType.setLayout(new GridLayout(1,2));
        armor.setLayout(new GridLayout(1,2));
        damage.setLayout(new GridLayout(1,2));
        accAssist.setLayout(new GridLayout(1,2));
        accuracy.setLayout(new GridLayout(1,2));
        stat.add(armorType);
        stat.add(weaponType);
        stat.add(armor);
        stat.add(damage);
        stat.add(accAssist);
        stat.add(accuracy);
        content.add(stat, BorderLayout.CENTER);
        content.add(south, BorderLayout.SOUTH);
    }

    public void fillContent() {
        weaponType.add(new JLabel("Weapon:"));
        armorType.add(new JLabel("Armor:"));
        armor.add(new JLabel("Armor:"));
        damage.add(new JLabel("Damage:"));
        accAssist.add(new JLabel("Accuracy Assist:"));
        accuracy.add(new JLabel("Accuracy:"));
    }

    public JPanel getContent(){
        return content;
    }
}