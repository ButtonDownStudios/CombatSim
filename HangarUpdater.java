import java.util.*;
import javax.swing.*;

public class HangarUpdater extends JLabel{
    private int remaining;
    public HangarUpdater(Integer left){
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
        setText("You have " + remaining + " hangar spots left available.");
    }

    public int getRemaining(){
        return remaining;
    }
}