
package Regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Name_RegeX {
    public boolean validate(String name) {
        
        Pattern pattern=Pattern.compile("[A-Za-z\\s]{1,26}");
        Matcher matcher=pattern.matcher(name);
        if(matcher.matches()){
            return true;
        }
        else{
            return false;
        }
    }
    
}
