import java.util.*;
public class Speaker extends Observable{

    Speaker(){	
        super();
    }

    void changeData(Object data){
        setChanged();
        notifyObservers(data);
    }
    
}
