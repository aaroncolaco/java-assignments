package com.psl;

public class Client {

    public boolean isLeapYear(int year) {

        // Write your code here to test if the year passed as a parameter is a Leap Year or not.
        if (year <1) {
            return false;
        }
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    return true;
                }
                return false;
            }
            return true;
        }

            return false;
    }

    public static void main(String[] args) {

        int a = 0;
                
        Client Foo = new Client();
        
        if(Foo.isLeapYear(a)) {
            System.out.println("Leap Year");
            return;
        }
        
        System.out.println("Not leap year");
    }
}
