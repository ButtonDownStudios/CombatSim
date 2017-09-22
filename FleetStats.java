import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.ActionListener.*;
import java.util.*;
public class FleetStats{
    private HashMap<String, Integer> count;
    private JFrame frame;
    public FleetStats(ArrayList<HashMap<String, Integer>> shipCount){
        count = new HashMap<>();
        for(int i = 0; i < 12; i++){
            for(Map.Entry<String, Integer> entry : shipCount.get(i).entrySet()) {
                String type = entry.getKey();
                Integer number = entry.getValue();
                if(number > 0){
                    count.put(type, number);
                }
            }
        }
        makeFrame();
    }

    public void makeFrame(){
        frame = new JFrame();
        fillContent();
        frame.pack();
        frame.setVisible(true);
    }

    public void fillContent(){
        JPanel contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout());

        JButton finished = new JButton("Okay");
        finished.addActionListener((event) -> {
            finished();
        });

        contentPane.add(finished, BorderLayout.SOUTH);

        JPanel stat = new JPanel();
        stat.setLayout(new GridLayout(10, (count.size() % 10) + 1));
        for(Map.Entry<String, Integer> entry : count.entrySet()) {
            String type = entry.getKey();
            Integer number = entry.getValue();
            stat.add(new JLabel(number + " " + type));
        }
        contentPane.add(stat, BorderLayout.CENTER);
        frame.add(contentPane);
    }

    private void finished(){
        frame.setVisible(false);
    }
}
