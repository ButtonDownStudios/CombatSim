import java.util.*;
import javax.swing.*;

public class TroopUpdater extends JLabel{
    private int remaining;
    public TroopUpdater(Integer left){
        super();
        remaining = left;
    }

    public void update(Object data){
        if(data instanceof Integer){
            remaining = (Integer) data;
        }
        display();
    }

    public void display(){
        setText("You have " + remaining + " troops.");
    }

    public int getRemaining(){
        return remaining;
    }
}