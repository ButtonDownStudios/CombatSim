import java.util.ArrayList;

public class ReportHolder{

    private static ArrayList<Report> reports;
    private static int current;
    private static int last;
    private DamageReport display;

    public ReportHolder(){
        reports = new ArrayList<>();
    }

    public void newReport(int round,int[] f1Troops, int[] f2Troops, int f1holdCount,String[] f1Ships, ArrayList<int[]> f1Count, ArrayList<Message> f1Report,int f2holdCount, String[] f2Ships, ArrayList<int[]> f2Count, ArrayList<Message> f2Report){
        reports.add(new Report(round, f1Troops, f2Troops, f1holdCount,f1Ships, f1Count, f1Report, f2holdCount, f2Ships, f2Count, f2Report));
    }

    public void lastVisible(){
        current = reports.size();
        display = new DamageReport(this,reports.get(current - 1).getround(),reports.get(current - 1).getf1Troops(),reports.get(current - 1).getf2Troops(),reports.get(current - 1).getf1holdCount(),reports.get(current - 1).getf1Ships(),reports.get(current - 1).getf1Count(),reports.get(current - 1).getf1Report(),reports.get(current - 1).getf2holdCount(),reports.get(current - 1).getf2Ships(),reports.get(current - 1).getf2Count(),reports.get(current - 1).getf2Report());
        display.setInput(current);
    }

    public void newVisible(int knew){
        if(!(knew <= 0) && !(knew > last + 1)){
            display.makeInvisible();
            current = knew;
            display = new DamageReport(this,reports.get(current - 1).getround(),reports.get(current - 1).getf1Troops(),reports.get(current - 1).getf2Troops(),reports.get(current - 1).getf1holdCount(),reports.get(current - 1).getf1Ships(),reports.get(current - 1).getf1Count(),reports.get(current - 1).getf1Report(),reports.get(current - 1).getf2holdCount(),reports.get(current - 1).getf2Ships(),reports.get(current - 1).getf2Count(),reports.get(current - 1).getf2Report());
        }
        display.setInput(current);
    }

    public void setFinal(int last){
        this.last = last;
    }

    public static int getCurrent(){
        return current;
    }
}
