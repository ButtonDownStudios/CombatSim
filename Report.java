import java.util.ArrayList;
/**
 * Write a description of class Report here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Report
{
    private int f1holdCount;
    private String[] f1Ships;
    private ArrayList<int[]> f1Count;
    private ArrayList<Message> f1Report;
    private int f2holdCount;
    private String[] f2Ships;
    private ArrayList<int[]> f2Count;
    private ArrayList<Message> f2Report;
    private int round;

    public Report(int round,int f1holdCount,String[] f1Ships, ArrayList<int[]> f1Count, ArrayList<Message> f1Report,int f2holdCount, String[] f2Ships, ArrayList<int[]> f2Count, ArrayList<Message> f2Report){
        this.round = round;
        this.f1Ships = f1Ships;
        this.f1Count = f1Count;
        this.f1Report = f1Report;
        this.f2Ships = f2Ships;
        this.f2Count = f2Count;
        this.f2Report = f2Report;
        this.f1holdCount = f1holdCount;
        this.f2holdCount = f2holdCount;
    }

    public int getf1holdCount(){
        return f1holdCount;
    }

    public String[] getf1Ships(){
        return f1Ships;
    }

    public ArrayList<int[]> getf1Count(){
        return f1Count;
    }

    public ArrayList<Message> getf1Report(){
        return f1Report;
    }

    public int getf2holdCount(){
        return f2holdCount;
    }

    public String[] getf2Ships(){
        return f2Ships;
    }

    public ArrayList<int[]> getf2Count(){
        return f2Count;
    }

    public ArrayList<Message> getf2Report(){
        return f2Report;
    }

    public int getround(){
        return round;
    }
}
