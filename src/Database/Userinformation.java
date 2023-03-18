
package Database;

public class Userinformation {
    
    String Name,Email,Uname,Password,DOB,Address,City,CreditCardNo,BankName,MICRNo;
    
    public Userinformation(String Name,String Email,String Uname,String Password,String DOB,String Address,String City,String CreditCardNo,String BankName,String MICRNo){
        this.Name=Name;
        this.Address=Address;
        this.BankName=BankName;
        this.DOB=DOB;
        this.City=City;
        this.CreditCardNo=CreditCardNo;
        this.Email=Email;
        this.Uname=Uname;
        this.Password=Password;
        this.MICRNo=MICRNo;
        
    }
    
    public String[] getUserInfo(){
        String[] user=new String[10];
        user[0]=Name;
        user[1]=Email;
        user[2]=Uname;
        user[3]=Password;
        user[4]=DOB;
        user[5]=Address;
        user[6]=City;
        user[7]=CreditCardNo;
        user[8]=BankName;
        user[9]=MICRNo;
        return user;
    }
    
    
}
