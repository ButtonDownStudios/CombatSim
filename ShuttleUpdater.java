import javax.swing.*;

public class ShuttleUpdater extends JLabel{
    private int remaining;
    public ShuttleUpdater(Integer left){
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
        setText("You have " + remaining + " shuttle spots left available.");
    }

    public int getRemaining(){
        return remaining;
    }
}