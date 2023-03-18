
package Regex;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Exp_Date {
    public boolean validate(String M,String Y) {
        Date d=new Date();
        System.out.println("d.getYear():: "+d.getYear());
        System.out.println("d.getMonth():: "+d.getMonth());
        System.out.println("Y::"+Integer.parseInt(Y));
        System.out.println("M:: "+Integer.parseInt(M));
        if( d.getYear()<=Integer.parseInt(Y) && d.getMonth()<Integer.parseInt(M)){
            return true;
        }else{
            return false;
        }
    }
}
