package com.util;

import com.exception.CityNotFoundException;
import com.exception.InvalidStateException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;


// Override and implement the methods of Interface DataManager here 
public class DataManagerImpl implements DataManager {

    @Override
    public Map<String, List<String>> populateCityDataMap(String fileName) throws FileNotFoundException {
        
        Map<String, List<String>> dataMap = new HashMap<>();    // have to define string and list only one side. 
        List <String> valuesList;
        String line = "";
        String[] cityStateStrings;

        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            
            while ( (line = br.readLine()) != null ) { // read until empty
                cityStateStrings = line.split("-"); // [0]-state(key) & [1]-city(value)
                
                if (cityStateStrings.length > 1) {  // check if enough args: State & City
                    
                    valuesList = dataMap.get(cityStateStrings[0]); // get list from map using current key(state)
                    
                    if (valuesList == null) {   // if no map entry for current key(state), list will be null
                        valuesList = new ArrayList<>();   // allocate mem for new list
                    }
                    
                    if (! valuesList.contains(cityStateStrings[1])) {   // check that city not already entered for this state
                        valuesList.add(cityStateStrings[1]); // add city to the list
                    }
                    
                    dataMap.put(cityStateStrings[0], valuesList); // put new/updated list in map
                }
            }
//            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        } catch (IOException ex) {
            Logger.getLogger(DataManagerImpl.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
//        To view dataMap value sets
//        for (String string : dataMap.keySet()) {
//            System.out.println(dataMap.get(string));
//        }
        return dataMap;
    }

    @Override
    public List<String> getCities(Map<String, List<String>> stateCityMap, String state) throws InvalidStateException {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
        List <String> citiesList; // don't have to allocate mem/define because it will be initialized in next step
        
        citiesList = stateCityMap.get(state);   // get the citylist based on the key(state)
        
        if (citiesList == null) {   // if state doesn't exist, list will be null
            throw new InvalidStateException();
        }
        
        return citiesList;
    }

    @Override
    public String getState(Map<String, List<String>> stateCityMap, String city) throws CityNotFoundException {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
        List <String> citiesList;
        
        
        for (String state : stateCityMap.keySet()) {
            citiesList = stateCityMap.get(state);
            if (citiesList.contains(city)) {
                return state;
            }
        }
        throw new CityNotFoundException();
    }

}
