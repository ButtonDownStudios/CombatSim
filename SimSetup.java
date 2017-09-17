import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.ActionListener.*;

public class SimSetup{

    private JFrame frame;
    private JPanel contentPane;
    private long creditLimit;
    private int roundLimit;
    private boolean end;

    public SimSetup(){
        roundLimit = 20000;
        creditLimit = 5000000000L;
        end = false;
        makeFrame();
    }

    private void makeFrame(){
        frame = new JFrame("Simulation Setup");
        contentPane = (JPanel) frame.getContentPane();
        contentPane.setBorder(new EmptyBorder(12,12,12,12));
        contentPane.setLayout(new BorderLayout(6,6));
        fillContent();
        frame.pack();
        frame.setVisible(true);
    }

    public void fillContent(){
        JPanel selection = new JPanel();

        selection.setLayout(new GridLayout(3,2));

        selection.add(new JLabel("Select Size of Battle:"));

        String[] sizeList = {"Giant","Huge","Large","Medium","Small","Skirmish"};
        JComboBox<String> sizeChoice = new JComboBox<>(sizeList);

        Speaker creditSpeak = new Speaker();
        Speaker roundSpeak = new Speaker();
        sizeChoice.addActionListener((event) -> {
                Object[] choices = sizeChoice.getSelectedObjects();
                String choice = "";
                if(choices[0] instanceof String){
                    choice = (String) choices[0];
                }
                 if(choice.equals("Giant")){
                    roundLimit = 20000;
                    creditLimit = 5000000000L;
                }else if(choice.equals("Huge")){
                    roundLimit = 10000;
                    creditLimit = 2000000000;
                }else if(choice.equals("Large")){
                    roundLimit = 5000;
                    creditLimit = 1000000000;
                }else if(choice.equals("Medium")){
                    roundLimit = 2500;
                    creditLimit = 500000000;
                }else if(choice.equals("Small")){
                    roundLimit = 1000;
                    creditLimit = 50000000;
                }else if(choice.equals("Skirmish")){
                    roundLimit = 500;
                    creditLimit = 20000000;
                } 
                creditSpeak.changeData(creditLimit);
                roundSpeak.changeData(roundLimit);
            });

        selection.add(sizeChoice);

        selection.add(new JLabel("Fleet Credits:"));

        Listener credit = new Listener();
        credit.display(creditLimit);
        creditSpeak.addObserver(credit);
        selection.add(credit);

        selection.add(new JLabel("Round Limit:"));

        Listener round = new Listener();
        round.display(roundLimit);
        roundSpeak.addObserver(round);
        selection.add(round);

        contentPane.add(selection, BorderLayout.CENTER);
        JButton complete = new JButton("Complete");
        complete.addActionListener((event) -> {end();frame.setVisible(false);});
        contentPane.add(complete, BorderLayout.SOUTH);
    }

    public int getRoundLimit(){
        return roundLimit;
    }

    public long getCreditLimit(){
        return creditLimit;
    }
    
    private void end(){
        end = true;
    }
    
    public boolean getEnd(){
        return end;
    }
}
