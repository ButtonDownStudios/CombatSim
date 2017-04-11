import javax.swing.*;
import java.util.*;

public class Listener extends JLabel implements Observer{
    public Listener(){
        super();
    }

    public void update(Observable o, Object data){
        display(data);
    }

    public void display(Object data){
        if(data instanceof Integer){
            setText("<html>"+ Integer.toString((Integer) data) + "</html>");
        }else if(data instanceof Double){
            setText("<html>" + Double.toString((Double) data) + "</html>");
        }else if(data instanceof String){
            setText("<html>" + (String) data + "</html>");
        }
    }
}
