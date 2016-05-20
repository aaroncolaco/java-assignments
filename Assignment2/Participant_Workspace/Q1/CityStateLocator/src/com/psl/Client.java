package com.psl;

import com.util.DataManagerImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Client {
	
	public static void main(String[] args) throws Exception{
		//Call your methods from here  to test the code implemented
            
            Map<String, List<String>> dataMap = new HashMap<>();    // okay even if not initialized because assigned later to the returned value from the function call. But have to allocate mem like this if we will store value ourselves.
            List <String> citiesList;
            String stateString;
            String fileNameString = "/home/aaron/Downloads/PSL/Assignment2/Participant_Workspace/Q1/CityStateLocator/StateCityDetails.txt";
            
            DataManagerImpl dataManagerImpl = new DataManagerImpl();
            
            // TEST -populate the map
            dataMap = dataManagerImpl.populateCityDataMap(fileNameString);
            
            //To view dataMap value sets
            System.out.println("Check the hashmap after reading file:");
            for (String string : dataMap.keySet()) {
                System.out.println( string + "--> " + dataMap.get(string));
            }
            
            
            // TEST - get cities from a state
            citiesList = dataManagerImpl.getCities(dataMap, "Goa");
            
            System.out.println(citiesList);
            
            
            // TEST - get state a city belongs to
            stateString = dataManagerImpl.getState(dataMap, "Margao");
            
            System.out.println(stateString);
	}
}