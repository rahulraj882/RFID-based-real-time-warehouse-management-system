
package Database;

public class Rfidinformation {
    
    String rfidUid,itemPrice,itemName;
    
    public Rfidinformation(String a,String b,String c){
        rfidUid=a;
        itemName=b;
        itemPrice=c;
    }
    
    public String[] getRfidInfo(){
        String[] rfid=new String[3];
        rfid[0]=rfidUid;
        rfid[1]=itemName;
        rfid[2]=itemPrice;
        return rfid;
    }
    
}
