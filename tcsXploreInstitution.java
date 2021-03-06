import java.util.Scanner;
class Institution{
    private int insId;
    private String insName;
    private int stuPlaced;
    private int stuCleared;
    private String location;
    private String grade;
    
    public String getInsName(){
        return this.insName;
    }
    public int getStuPlaced(){
        return this.stuPlaced;
    }
    public int getStuCleared(){
        return this.stuCleared;
    }
    public String getLocation(){
        return this.location;
    }
    public String getGrade(){
        return this.grade;
    }
    public void setGrade(String grade){
        this.grade = grade;
    }
    
    
    public Institution(int insId, String insName, int placed,int cleared ,String location){
        this.insId = insId;
        this.insName = insName;
        this.stuPlaced = placed;
        this.stuCleared = cleared;
        this.location = location;
    }
}
public class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Institution[] ins = new Institution[4];
        for(int i = 0;i<4;i++){
            int id = sc.nextInt(); sc.nextLine();
            String name = sc.nextLine();
            int placed = sc.nextInt(); sc.nextLine();
            int cleared = sc.nextInt(); sc.nextLine();
            String loc = sc.nextLine();
            ins[i]= new Institution(id,name,placed,cleared,loc);
        }
        String location = sc.nextLine();
        String name = sc.nextLine();
        
        int res1 = findNumClearancedByLoc(ins, location);
        if(res1>0) System.out.println(res1);
        else System.out.println("There are no cleared students in this particular location.");
        Institution res2 = updateInstitutionGrade(ins, name);
        if(res2 == null) System.out.println("No Institute is available with the specified name.");
        else System.out.println(res2.getInsName()+"::"+res2.getGrade());
        
    }
    public static int findNumClearancedByLoc(Institution[] ins, String location){
        int sum = 0;
        for(Institution in: ins){
            if(in.getLocation().equalsIgnoreCase(location)){
                sum = sum + in.getStuCleared();
            }
        }
        return sum;
        
    }
    public static Institution updateInstitutionGrade(Institution[] ins, String insName){
        for(Institution in : ins){
            if(in.getInsName().equalsIgnoreCase(insName)){
                int rating = (in.getStuPlaced() * 100)/(in.getStuCleared());
                if(rating>=80) in.setGrade("A");
                else in.setGrade("B");
                return in;
            }
        }
        return null;
        
    }
}
