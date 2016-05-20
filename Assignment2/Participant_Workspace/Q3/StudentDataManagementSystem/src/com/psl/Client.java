package com.psl;

import com.psl.beans.Student;
import com.psl.exceptions.InsufficientDataException;
import com.psl.util.StudentDataManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client {
	
	public static void main(String[] args) {
		//Create instance of StudentDataManager Class here and  test your functionality from here
	
            String fileNameString = "/home/aaron/Downloads/PSL/Assignment2/Participant_Workspace/Q3/StudentDataManagementSystem/StudentDetails.txt";
            List <Student> studentList = new ArrayList<>();
            
            StudentDataManager studentDataManager = new StudentDataManager();
            
            // call populate data method
            studentList = studentDataManager.populateData(fileNameString);
            
            //call validate data method (Throws Exception)
            try {
                studentDataManager.validateData(studentList);
            } catch (InsufficientDataException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            // call sort func
            Collections.sort(studentList);
	}
}
