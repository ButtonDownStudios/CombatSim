import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.HashMap;
import java.util.ArrayList;

public class TroopCreation{

    private JFrame frame;
    private JPanel contentPane;
    private boolean end;
    private HashMap<Troop,Integer> troopCount;
    private ArrayList<TroopPanel> panels;

    public TroopCreation(String army){
        end = false;
        troopCount = new HashMap<Troop,Integer>();
        panels = new ArrayList<>();
        makeFrame(army);
    }

    public void makeFrame(String army){
        frame = new JFrame(army + " Creation");
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
        JLabel types = new JLabel("Troop Types:");
        selection.add(types);

        String[] troopTypes = {"Add New Type"};
        JComboBox<String> troopChoice = new JComboBox<>(troopTypes);
        troopChoice.addActionListener((event) -> {
                chooseTroopType(troopChoice.getSelectedItem());
            });
        selection.add(troopChoice);

        contentPane.add(selection, BorderLayout.NORTH);
        
        NewTroopPanel knew = new NewTroopPanel();
        
        contentPane.add(knew.getContent(), BorderLayout.CENTER);
        
        JPanel totalInfo = new JPanel();
        totalInfo.setLayout(new GridLayout(2,1));
        JPanel info = new JPanel();
        info.setLayout(new GridLayout(1,3));
        info.add(new JLabel("Troop number"));
        JButton check = new JButton("Check");
        info.add(check);
        info.add(new JLabel("Cost"));
        totalInfo.add(info);
        JButton complete = new JButton("Complete");
        complete.addActionListener((event) -> {
                frame.setVisible(false);
            });
        totalInfo.add(complete);
        contentPane.add(totalInfo,BorderLayout.SOUTH);
    }

    private void chooseTroopType(Object o){
        String s = "";
        if(o instanceof String){
            s = (String) o;
        }
    }
}