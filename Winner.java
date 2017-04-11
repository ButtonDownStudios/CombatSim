import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Winner{

    private JFrame frame;
    private Container contentPane;
    private int code;
    private int rounds;
    private long time;

    public Winner(int code, int rounds, long time){
        this.code = code;
        this.rounds = rounds;
        this.time = time;
        makeFrame();
    }

    public void makeFrame(){
        frame = new JFrame("Battle Results");
        contentPane = (JPanel) frame.getContentPane();
        fillContent();
        frame.pack();
        frame.setVisible(true);
    }

    public void fillContent(){
        contentPane.setLayout(new GridLayout(2,1));
        String s = "";
        if(code == 1){
            s = "Fleet 1 won the battle!!!";
        }else if(code == 2){
            s = "Fleet 2 won the battle!!!";
        }else{
            s = "the fleets fought to a stalemate.";
        }
        JLabel results = new JLabel("After " + Integer.toString(rounds) + " rounds of combat, " + s);
        contentPane.add(results);
        JLabel timeTook = new JLabel("This simulation took " + Double.toString(time / 1000.0) + " seconds to run");
        contentPane.add(timeTook);
    }
}
