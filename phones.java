import java.util.Scanner;
class Phone{
    private int phoneId;
    private String os;
    private String brand;
    private int price;
    
    public Phone(int id, String os, String brand , int price){
        this.phoneId = id;
        this.os = os;
        this.brand = brand ;
        this.price = price;
    }
    
    public int getPhoneId(){
        return this.phoneId;
    }
    public String getBrand(){
        return this.brand;
    }
    public int getPrice(){
        return this.price;
    }
    public String getOs(){
        return this.os;
    }
    
}
public class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Phone[] phones = new Phone[4];
        for(int i = 0;i<4;i++){
            int id = sc.nextInt(); sc.nextLine();
            String os = sc.nextLine();
            String brand = sc.nextLine();
            int price = sc.nextInt(); sc.nextLine();
            phones[i]= new Phone(id,os,brand,price);
        }
        String brand = sc.nextLine();
        String os = sc.nextLine();
        
        int res1 = findPriceForGivenBrand(phones,brand);
        if(res1>0) System.out.println(res1);
        else System.out.println("The given brand is not available.");
        
        Phone res2 = getPhoneIdBasedOnOs(phones,os);
        if(res2 != null) System.out.println(res2.getPhoneId());
        else System.out.println("No phones are available with specified os and price range.");
        
        Phone res3 = sortPhonesWrtPriceDsc(phones);
        System.out.println(res3.getPrice()+"\n ");
        
        Phone[] res4 = sortPhonesWrtPriceAsc(phones);
        for(Phone ph : res4) System.out.println(ph.getPrice());
        
        
    }
    public static int findPriceForGivenBrand(Phone[] phones, String brand){
        int sum = 0;
        for(Phone ph :phones){
            if(brand.equalsIgnoreCase(ph.getBrand())) sum = sum + ph.getPrice();
        }
        return sum;
    }
    public static Phone getPhoneIdBasedOnOs(Phone[] phones, String os){
        for(Phone ph : phones ){
            if(os.equalsIgnoreCase(ph.getOs()) && ph.getPrice()>=50000) return ph;
        }
        return null;
    }
    public static Phone sortPhonesWrtPriceDsc(Phone[] phones){
        for(int i = 0;i<phones.length-1;i++){
            for(int j= i+1;j<phones.length;j++){
                if(phones[i].getPrice() < phones[j].getPrice() ){
                    Phone temp = phones[i];
                    phones[i] = phones[j];
                    phones[j]= temp;
                }
            }
        }
        return phones[1];
    }
    public static Phone[] sortPhonesWrtPriceAsc(Phone[] phones){
        for(int i = 0;i<phones.length-1;i++){
            for(int j = i+1;j<phones.length;j++){
                if(phones[i].getPrice() > phones[j].getPrice()){
                    Phone temp = phones[i];
                    phones[i]= phones[j];
                    phones[j]= temp;
                }
            }
        }
        return phones;
    }
}
