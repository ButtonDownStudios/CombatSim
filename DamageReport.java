import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.ActionListener.*;
import java.util.ArrayList;
import java.util.Iterator;

public class DamageReport{

    private int f1holdCount;
    private String[] f1Ships;
    private ArrayList<int[]> f1Count;
    private ArrayList<Message> f1Report;
    private int f2holdCount;
    private String[] f2Ships;
    private ArrayList<int[]> f2Count;
    private ArrayList<Message> f2Report;
    private int round;
    private JFrame frame;
    private Container contentPane;
    private JTextField input;
    private ReportHolder report;

    public DamageReport(ReportHolder report,int round,int f1holdCount,String[] f1Ships, ArrayList<int[]> f1Count, ArrayList<Message> f1Report,int f2holdCount, String[] f2Ships, ArrayList<int[]> f2Count, ArrayList<Message> f2Report){
        this.report = report;
        this.round = round;
        this.f1Ships = f1Ships;
        this.f1Count = f1Count;
        this.f1Report = f1Report;
        this.f2Ships = f2Ships;
        this.f2Count = f2Count;
        this.f2Report = f2Report;
        this.f1holdCount = f1holdCount;
        this.f2holdCount = f2holdCount;
        makeFrame();
    }

    private void makeFrame(){
        frame = new JFrame("Round " + round);
        contentPane = (JPanel) frame.getContentPane();
        contentPane.setLayout(new BorderLayout(6,6));
        fillContent();
        frame.pack();
        makeVisible();
    }

    private void fillContent(){
        JPanel top = new JPanel();
        top.setLayout(new GridLayout(1,3));

        input = new JTextField();
        JButton back = new JButton("<");
        back.addActionListener((event) -> {
                decrease();
            });

        input.addActionListener((event) -> {
                input(Integer.parseInt(input.getText()));
            });

        JButton forward = new JButton(">");
        forward.addActionListener((event) -> {
                increase();
            });

        top.add(back);
        top.add(input);
        top.add(forward);
        contentPane.add(top, BorderLayout.NORTH);

        JPanel center = new JPanel();
        center.setLayout(new GridLayout(2,1));

        JPanel fleetReport = new JPanel();
        fleetReport.setLayout(new GridLayout(1,2));

        JPanel fleet1 = new JPanel();
        fleet1.setLayout(new BorderLayout());
        fleet1.add(new JLabel("Fleet 1 Report"), BorderLayout.NORTH);

        JPanel f1Stats = new JPanel();
        f1Stats.setLayout(new GridLayout(f1holdCount + 1,6));
        f1Stats.add(new JPanel());
        f1Stats.add(new JLabel("In Battle"));
        f1Stats.add(new JLabel("Damaged"));
        f1Stats.add(new JLabel("Heavily Damaged"));
        f1Stats.add(new JLabel("Critically Damaged"));
        f1Stats.add(new JLabel("Destroyed"));

        for(int i = 0; i < f1Ships.length; i++){
            f1Stats.add(new JLabel(f1Ships[i]));
            for(int j = 0; j < 5; j++){
                f1Stats.add(new JLabel(Integer.toString(f1Count.get(i)[j])));
            }
        }

        JPanel fleet2 = new JPanel();
        fleet2.setLayout(new BorderLayout());
        fleet2.add(new JLabel("Fleet 2 Report"), BorderLayout.NORTH);

        JPanel f2Stats = new JPanel();
        f2Stats.setLayout(new GridLayout(f2holdCount + 1,6));
        f2Stats.add(new JPanel());
        f2Stats.add(new JLabel("In Battle"));
        f2Stats.add(new JLabel("Damaged"));
        f2Stats.add(new JLabel("Heavily Damaged"));
        f2Stats.add(new JLabel("Critically Damaged"));
        f2Stats.add(new JLabel("Destroyed"));

        for(int i = 0; i < f2Ships.length; i++){
            f2Stats.add(new JLabel(f2Ships[i]));
            for(int j = 0; j < 5; j++){
                f2Stats.add(new JLabel(Integer.toString(f2Count.get(i)[j])));
            }
        }

        fleet1.add(f1Stats,BorderLayout.CENTER);
        fleet2.add(f2Stats,BorderLayout.CENTER);

        fleetReport.add(fleet1);
        fleetReport.add(fleet2);

        center.add(fleetReport);

        JPanel damages = new JPanel();

        damages.setLayout(new GridLayout(f1Report.size() + f2Report.size() + 3,1));
        damages.add(new JLabel("Fleet 1 Messages:"));	
        for(Message m : f1Report){
            String s = "";
            if(m.getCode() == 1){
                s = " was damaged by " + m.getAttacker().getShipClass();
            }else if(m.getCode() == 2){
                s = " was heavily damaged by " + m.getAttacker().getShipClass();
            }else if(m.getCode() == 3){
                s = " was critically damaged by " + m.getAttacker().getShipClass();
            }else if(m.getCode() == 4){
                s = " was destroyed by " + m.getAttacker().getShipClass();
            }else{
                s = " rejoins the battle";
            }
            damages.add(new JLabel(m.getDefender().getShipClass() + s));
        }

        damages.add(new JLabel("Fleet 2 Messages:"));	
        for(Message m : f2Report){
            String s = "";
            if(m.getCode() == 1){
                s = " was damaged by " + m.getAttacker().getShipClass();
            }else if(m.getCode() == 2){
                s = " was heavily damaged by " + m.getAttacker().getShipClass();
            }else if(m.getCode() == 3){
                s = " was critically damaged by " + m.getAttacker().getShipClass();
            }else if(m.getCode() == 4){
                s = " was destroyed by " + m.getAttacker().getShipClass();
            }else{
                s = " rejoins the battle";
            }
            damages.add(new JLabel(m.getDefender().getShipClass() + s));
        }
        JScrollPane scroll = new JScrollPane(damages);
        scroll.createVerticalScrollBar();
        center.add(scroll);
        contentPane.add(center, BorderLayout.CENTER);
    }

    public void makeVisible(){
        frame.setVisible(true);
    }

    public void makeInvisible(){
        frame.setVisible(false);
    }

    private void decrease(){
        report.newVisible(round - 1);
    }

    private void increase(){
        report.newVisible(round + 1);
    }

    private void input(int j){
        report.newVisible(j);
    }

    public void setInput(int i){
        input.setText(Integer.toString(i));
    }
}