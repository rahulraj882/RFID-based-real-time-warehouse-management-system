
package Regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AtmPin_RegeX {
    
    public boolean validate(String pin) {
        Pattern pattern=Pattern.compile("[0-9.]");
        Matcher matcher=pattern.matcher(pin);
        if(matcher.matches()){
            return true;
        }
        else{
            return false;
        }
    }
}
