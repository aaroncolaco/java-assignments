package com.util;

//Override and implement all the methods of DataManger Interface in this class
import com.bean.Show;
import com.exception.InvalidSeatNumberException;
import com.exception.SeatsNotAvailableException;
import com.exception.UnknownShowException;
import java.io.BufferedReader;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataManagerImpl implements DataManager {

    @Override
    public List<Show> populateDataFromFile(String fileName) {

        Show show = null;
        List<Show> showList = new ArrayList<>();
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;
        
        try {
            fileInputStream = new FileInputStream(fileName);
            objectInputStream = new ObjectInputStream(fileInputStream);
            
            while ((show = (Show) objectInputStream.readObject()) != null) {                

                showList.add(show);
            }
            
        } catch (EOFException ex) {
            // so that nothing happens when we reach end of file during deserialization
        } catch (Exception ex) {
            Logger.getLogger(DataManagerImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fileInputStream.close();
                objectInputStream.close();
            } catch (IOException ex) {
                Logger.getLogger(DataManagerImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
        return showList;
    }

    @Override
    public void bookShow(List<Show> showList, String showName, String show_time, int noOfSeats) throws SeatsNotAvailableException, UnknownShowException, InvalidSeatNumberException {
        
        // check if negative no. passed
        if (noOfSeats < 1) {
            throw new InvalidSeatNumberException();
        }
        
        for (Show show : showList) {
            // check if show exists
            if (show.getShowName().equals(showName)) {
                // check no. of seats
                if (show.getSeatsAvailable() < noOfSeats) {
                    throw new SeatsNotAvailableException();
                }
                // if seats available are okay, return
                return;
            }
        }
        // if reaches here => show name not found
        throw new UnknownShowException();
    }
}
