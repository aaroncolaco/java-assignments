package com.psl.util;

//Override all the methods of the DataManager Interface

import com.psl.beans.Address;
import com.psl.beans.Student;
import com.psl.exceptions.InsufficientDataException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StudentDataManager implements DataManager {

    @Override
    public List<Student> populateData(String fileName) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        List <Student> studentList = new ArrayList<>();
        BufferedReader br;
        String line;
        String[] studentStrings;
        Student student;
        Address address;
        int studentRollNoInt = 0, studentAgeInt = 0;
        
        try {
            br = new BufferedReader(new FileReader(fileName));
            
            while ( (line = br.readLine()) != null ) {                
                studentStrings = line.split(",");
                
                if (studentStrings.length > 1) {    // check to see that not blank line
                    student = new Student();
                    address = new Address();
                    
                    // if empty, set string values to null
                    if (studentStrings[1].equals("")) {
                        studentStrings[1] = null;
                    }
                    for (int i = 3 ; i < 5; i++) {
                        if (studentStrings[i].equals("")) {
                            studentStrings[i] = null;
                        }
                    }
                    // if int locations are null set to 0, else to the integer
                    if (studentStrings[0].equals("")) {
                            studentRollNoInt = 0;
                    } else {
                        studentRollNoInt = Integer.parseInt(studentStrings[0]);
                    }
                    if (studentStrings[2].equals("")) {
                        studentAgeInt = 0;
                    } else {
                        studentAgeInt = Integer.parseInt(studentStrings[2]);
                    }
                    
                    address.setStreetName(studentStrings[3]);
                    address.setCity(studentStrings[4]);
                    address.setZipCode(studentStrings[5]);
                    
                    student.setStudentName(studentStrings[1]);
                    student.setRollno(studentRollNoInt);
                    student.setAge(studentAgeInt);
                    student.setAddress(address);
                    
                    studentList.add(student);
                }
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(StudentDataManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(StudentDataManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return studentList;
    }

    @Override
    public void validateData(List<Student> studentList) throws InsufficientDataException {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        boolean insufficientData = false;
        Address studentAddress;

        for (Student student : studentList) {   
            
            // checking overall student details
            if ((student.getAge() == 0) || (student.getRollno() == 0)) {
                insufficientData = true;
            }
            
            if ((student.getStudentName()== null) || (student.getAddress()== null)) {
                insufficientData = true;
            }
            
            // checking address part now
            studentAddress = student.getAddress();
            
            if ((studentAddress.getCity() == null) || (studentAddress.getStreetName() == null) || (studentAddress.getZipCode() == null)) {
                insufficientData = true;
            }
        }
        
        if (insufficientData) {
            throw new InsufficientDataException();
        }
    }

    @Override
    public void sortData(List<Student> studentList) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

	
}
