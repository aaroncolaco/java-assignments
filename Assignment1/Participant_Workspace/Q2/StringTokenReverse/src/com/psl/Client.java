package com.psl;

import java.util.Arrays;

public class Client {

    public String[] getTokens(String data) {
        //Write a code here to tokenize the words in the given String and return an array of words
        return data.split(" ");
    }

    public String reverseAndAppend(String[] data) {
        //Write a code here to reverse and append the words in the passed array
        StringBuilder stringBuilder = new StringBuilder();
        String returnString = "";
        
        for (String string : data) {
            stringBuilder.append(string);
            returnString += stringBuilder.reverse() + " ";
            stringBuilder.replace(0, string.length(), ""); // To overwrite first position in each iteration. 
        }
        
        returnString = returnString + "\b"; // Remove last whitespace
        
        return returnString;
    }

    public static void main(String[] args) {
        //Check your code by calling methods from here
        Client client = new Client();
        String[] tokens = client.getTokens("Hello World");
        String answerString = client.reverseAndAppend(tokens);
        
        System.out.println(answerString);
    }

}
