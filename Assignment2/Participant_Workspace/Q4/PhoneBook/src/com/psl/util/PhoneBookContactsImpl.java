package com.psl.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.psl.exception.NoDataFoundException;
import java.util.ArrayList;

//Override all the methods of the PhoneBookContacts Interface
public class PhoneBookContactsImpl implements PhoneBookContacts {

    // use this Map to create the PhoneBook Contacts
    private Map<String, List<String>> contactMap = new HashMap<String, List<String>>();

    @Override
    public void addContact(String name, List<String> list) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        contactMap.put(name, list);
    }

    @Override
    public Map<String, List<String>> getContactMap() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return contactMap;
    }

    @Override
    public List<String> searchContact(String name) throws NoDataFoundException {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        List <String> returnContactList = new ArrayList<>();
        
        if (!contactMap.containsKey(name)) {
            throw new NoDataFoundException();
        }
        
        returnContactList = contactMap.get(name);
        
        return returnContactList;
    }

}
