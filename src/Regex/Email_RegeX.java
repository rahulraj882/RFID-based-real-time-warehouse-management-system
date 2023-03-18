
package Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Email_RegeX {
    public boolean validate(String email){
        Pattern pattern=Pattern.compile("^[A-Za-z0-9._%+-]+@+[A-Za-z0-9.-]+\\.+[A-Za-z]{2,4}$");
        Matcher matcher=pattern.matcher(email);
        if(matcher.matches()){
            return true;
        }else{
            return false;
        }
    }
}
