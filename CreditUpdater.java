import javax.swing.*;

public class CreditUpdater extends JLabel{
    private long remaining;
    public CreditUpdater(Long left){
        super();
        remaining = left;
    }

    public void update(Object data){
        if(data instanceof Long){
            remaining = (Long) data;
        }
        display();
    }

    public void display(){
        setText("You have " + remaining + " credits remaining.");
    }

    public long getRemaining(){
        return remaining;
    }
}