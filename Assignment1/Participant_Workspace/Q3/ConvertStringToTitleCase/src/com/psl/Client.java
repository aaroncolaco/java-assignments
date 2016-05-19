package com.psl;

import java.util.Locale;

public class Client {

    public String convertToTitle(String string) {
        //Write the code here to Convert the String to title case
        
        // Convert to full lower first
        String[] argumentArray = string.toLowerCase().split(" ");
       
        StringBuilder stringBuilder = new StringBuilder();
        String returnString = "";
        
        for (String stringObject : argumentArray) {
            stringBuilder.append(stringObject);
            stringBuilder.setCharAt(0, Character.toUpperCase(stringBuilder.charAt(0)));
            
            returnString += stringBuilder + " ";
            
            stringBuilder.replace(0, stringObject.length(), "");  // to empty at end of every loop 
        }
        
        returnString += "\b";   // Remove last whitespace
        return returnString;

    }

    public static void main(String[] args) {
        // Test your code by calling convertToTitle method from here
        Client client = new Client();
        
        String testString = client.convertToTitle("hello woRld. i AM aaRon");
        
        System.out.println(testString);
    }
}
