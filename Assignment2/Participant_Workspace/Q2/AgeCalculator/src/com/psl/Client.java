package com.psl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client {

    public int findAge(String birthDate) throws InvalidDateFormatException {
        //Write a code here to calculate the age using the birthdate
        int age = 0;
        
        // Custom date format
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");

        Date currentDate = null, passedDate = null;
        
        try {
            // assign to date objects according to format
            passedDate = simpleDateFormat.parse(birthDate);
            currentDate = new Date();
            
            //check passed date format
            if (!birthDate.equals(simpleDateFormat.format(passedDate))) {
                throw new InvalidDateFormatException();
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // if future date is passed
        if (passedDate.after(currentDate)) {
            return age;
        }
        
        // difference in days
        age = (int) ((currentDate.getTime() - passedDate.getTime()) / (1000 * 60 * 60 * 24));
        
        // to get number of years
        age = age / 365;

        return age;

    }

    public static void main(String[] args) {
		// You can test your code by calling findAge() method from here

        int age;
        String[] dates = {"22-11-1993", "02-02-2019", "15-02-1996", "1998-02-22"};  // last one should throw exception since future date
        try {
            for (String date : dates) {
                age = new Client().findAge(date);
                System.out.println(date + " --> " + age);
            }
        } catch (InvalidDateFormatException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
