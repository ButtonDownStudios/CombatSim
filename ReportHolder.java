import java.util.ArrayList;

public class ReportHolder{

    private static ArrayList<DamageReport> reports;
    private static int current;
    private static int last;

    public ReportHolder(){
        reports = new ArrayList<>();
    }

    public void newReport(int round,int f1holdCount,String[] f1Ships, ArrayList<int[]> f1Count, ArrayList<Message> f1Report,int f2holdCount, String[] f2Ships, ArrayList<int[]> f2Count, ArrayList<Message> f2Report){
        reports.add(new DamageReport(round, f1holdCount,f1Ships, f1Count, f1Report, f2holdCount, f2Ships, f2Count, f2Report));
    }

    public void lastVisible(){
        current = reports.size();
        reports.get(current - 1).makeVisible();
        reports.get(current - 1).setInput(current);
    }

    public static void newVisible(int knew){
        if(!(knew <= 0) && !(knew > last + 1)){
            reports.get(current - 1).makeInvisible();
            current = knew;
            reports.get(current - 1).makeVisible();
        }
        reports.get(current - 1).setInput(current);
    }

    public void setFinal(int last){
        this.last = last;
    }

    public static int getCurrent(){
        return current;
    }
}
