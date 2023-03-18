package Regex;

import java.util.*;
import java.io.*;

@SuppressWarnings("empty-statement")
public class Mod10algo1 {
    String creditNo=new String();
    public String generateNo(){
        String numbers="0123456789";
        Random rand=new Random();
        String num=new String("\0");
        for(int i=0;i<15;i++){
            if(i==0)
                num=""+numbers.charAt(rand.nextInt(numbers.length()));
            else
            num=num+numbers.charAt(rand.nextInt(numbers.length()));
        }
        creditNo=4+num;
        return creditNo;
        //return true;
    }

// Java program to implement
// Luhn algorithm
     
// Returns true if given 
// card number is valid
public static boolean checkLuhn(String cardNo)
{
    int nDigits = 16;
 
    int nSum = 0;
    boolean isSecond = false;
    for (int i = nDigits - 1; i >= 0; i--) 
    {
 
        int d = cardNo.charAt(i) - 'a';
 
        if (isSecond == true)
            d = d * 2;
 
        // We add two digits to handle
        // cases that make two digits 
        // after doubling
        nSum += d / 10;
        nSum += d % 10;
 
        isSecond = !isSecond;
    }
    return (nSum % 10 == 0);
}
 
public void generate(){

    Mod10algo1 algo=new Mod10algo1();
    while(true){          
        if(algo.checkLuhn(algo.generateNo())){
            System.out.println("SAMPLE CORRECT CARD NO:: "+algo.creditNo);
            break;
        }
    }
    
}

   /* public static void main(String[] args) {
        Mod10algo1 algo=new Mod10algo1();
        if(algo.checkLuhn("4844709968183739")){
            System.out.println("TRUE");
        }else{
            System.out.println("FAlSE");
        }
        
    }*/

}
    

