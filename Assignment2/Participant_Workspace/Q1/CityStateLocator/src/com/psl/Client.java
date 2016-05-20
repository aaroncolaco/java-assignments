package com.psl;

import com.util.DataManagerImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Client {
	
	public static void main(String[] args) throws Exception{
		//Call your methods from here  to test the code implemented
            
            Map<String, List<String>> dataMap = new HashMap<String, List<String>>();
            
            DataManagerImpl dataManagerImpl = new DataManagerImpl();
            
            dataMap = dataManagerImpl.populateCityDataMap("StateCityDetails.txt");
            
            //To view dataMap value sets
            System.out.println("Check the hashmap after reading file:");
            for (String string : dataMap.keySet()) {
                System.out.println( string + "--> " + dataMap.get(string));
            }
	}
}