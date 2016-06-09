package com.psl;

import com.bean.Show;
import com.exception.InvalidSeatNumberException;
import com.exception.SeatsNotAvailableException;
import com.exception.UnknownShowException;
import com.util.DataManagerImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client {

    public static void main(String[] args) {

        // Call all the functionalities from here to test your code.    
        
        DataManagerImpl dataManagerImpl = new DataManagerImpl();
        
        List<Show> showList = new ArrayList<>();
        
        showList = dataManagerImpl.populateDataFromFile("/home/aaron/Downloads/PSL/Assignment3/Participant_Workspace/Q1/ShowBookingSystem/ShowDetails.ser");
        
        try {
            // negative no passed
            dataManagerImpl.bookShow(showList, showList.get(1).getShowName(), "4:30", -20);
            // invalid show name
            dataManagerImpl.bookShow(showList, "Foo", "4:30", 20);
            // no. of seats > available
            dataManagerImpl.bookShow(showList, showList.get(1).getShowName(), "4:30", 200);
            // proper
            dataManagerImpl.bookShow(showList, showList.get(1).getShowName(), "4:30", 20);
        } catch (Exception ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
