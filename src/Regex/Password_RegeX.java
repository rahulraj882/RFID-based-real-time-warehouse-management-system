
package Regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Password_RegeX {

    public boolean validate(String pass) {
        Pattern pattern=Pattern.compile("((?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@]).{6,20})");
        Matcher matcher=pattern.matcher(pass);
        if(matcher.matches()){
            return true;
        }
        else{
            return false;
        }
    }
    
}
