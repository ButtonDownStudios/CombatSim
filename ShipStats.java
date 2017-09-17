import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.ActionListener.*;
import java.util.HashMap;
import java.util.HashSet;
public class ShipStats{
    private Ship s;
    private JPanel stat;
    private JPanel content;
    private HashMap<String, Integer> count;
    public ShipStats(Ship s, HashMap<String, Integer> count){
        this.s = s;
        this.count = count;
        stat = new JPanel();
        fillStat();
    }

    private void fillStat(){
        stat.setLayout(new BorderLayout());

        JPanel number = new JPanel();
        number.setLayout(new GridLayout(1,4));

        number.add(new JLabel(s.getShipClass()));

        JButton decrease = new JButton("<");
        JTextField input = new JTextField();
        JButton increase = new JButton(">");
        decrease.addActionListener((event) -> {
                decrease();
                input.setText(Integer.toString(count.get(s.getShipClass())));
            });

        input.setText(Integer.toString(count.get(s.getShipClass())));
        input.addActionListener((event) -> {
                input(Integer.parseInt(input.getText()));
                input.setText(Integer.toString(count.get(s.getShipClass())));
            });

        increase.addActionListener((event) -> {
                increase();
                input.setText(Integer.toString(count.get(s.getShipClass())));
            });

        number.add(decrease);
        number.add(input);
        number.add(increase);

        stat.add(number, BorderLayout.NORTH);

        content = new JPanel();
        content.setLayout(new GridLayout(1,2));
        fillLeft();
        fillRight();        

        stat.add(content, BorderLayout.CENTER);
    }

    private void fillLeft(){
        JPanel left = new JPanel();

        if(s instanceof CapitalShip){
            left.setLayout(new GridLayout(4,1));
        }else{
            left.setLayout(new GridLayout(3,1));
        }

        left.add(new JLabel("Hull Strength: " + s.getHull()));
        left.add(new JLabel("Shield Strength: " + s.getShields()));
        if(s instanceof CapitalShip){
            left.add(new JLabel("Hangar: " + s.getHangar()));
        }
        left.add(new JLabel("Price: " + s.getPrice()));

        content.add(left);
    }

    private void fillRight(){
        JPanel right = new JPanel();

        HashSet<String> weaponTypes = new HashSet<>();
        for(Weapon w : s.getWeapons()){
            weaponTypes.add(w.getType());
        }
        HashMap<String, Integer> weaponCount = new HashMap<>();
        for(String w : weaponTypes){
            weaponCount.put(w, 0);
        }
        for(Weapon w : s.getWeapons()){
            int i = weaponCount.get(w.getType());
            int j = i;
            j++;
            weaponCount.replace(w.getType(), i, j);
        }

        right.setLayout(new GridLayout(weaponTypes.size(),1));

        for(String w : weaponTypes){
            right.add(new JLabel(weaponCount.get(w) + " " + w));
        }

        content.add(right);
    }

    private void increase(){
        int i = count.get(s.getShipClass());
        int j = i;
        j++;
        if(j < 0){
            j = 0;
        }
        count.replace(s.getShipClass(), i, j);
        if(s instanceof CapitalShip){
            FleetCreation.setFighters(0, s.getHangar(), i, j);
        }else{
            FleetCreation.setFighters(1, 0, i, j);
        }
        FleetCreation.setCredits(i, j, s.getPrice());
    }

    private void decrease(){
        int i = count.get(s.getShipClass());
        int j = i;
        j--;
        if(j < 0){
            j = 0;
        }
        count.replace(s.getShipClass(), i, j);
        if(s instanceof CapitalShip){
            FleetCreation.setFighters(0, s.getHangar(), i, j);
        }else{
            FleetCreation.setFighters(1, 0, i, j);
        }
        FleetCreation.setCredits(i, j, s.getPrice());
    }

    private void input(int j){
        if(j < 0){
            j = 0;
        }
        int i = 0;
        if(j >= 0){
            i = count.get(s.getShipClass());
            count.replace(s.getShipClass(), i, j);
        }
        if(s instanceof CapitalShip){
            FleetCreation.setFighters(0, s.getHangar(), i, j);
        }else{
            FleetCreation.setFighters(1, 0, i, j);
        }
        FleetCreation.setCredits(i, j, s.getPrice());
    }

    public JPanel getStats(){
        return stat;
    }
}