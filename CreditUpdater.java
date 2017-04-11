import java.util.*;
import javax.swing.*;

public class CreditUpdater extends JLabel{
    private int remaining;
    public CreditUpdater(Integer left){
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
        setText("You have " + remaining + " credits remaining.");
    }

    public int getRemaining(){
        return remaining;
    }
}