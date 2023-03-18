
package Regex;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Date_RegeX {
    public boolean validate(Date date) {
        Date d=new Date();
        if(d.getYear()>=18+date.getYear()){
            return true;
        }else{
            return false;
        }
    }
}
