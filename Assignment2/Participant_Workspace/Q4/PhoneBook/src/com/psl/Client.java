package com.psl;

import com.psl.exception.NoDataFoundException;
import com.psl.util.PhoneBookContacts;
import com.psl.util.PhoneBookContactsImpl;
import java.util.ArrayList;
import java.util.List;

public class Client {

    public static void main(String[] args) throws NoDataFoundException {

        //test your code by calling methods of the PhoneBookContacts from here
        PhoneBookContacts contacts = new PhoneBookContactsImpl();
        List<String> contactDetailsList = new ArrayList<>();

        // Contact names
        String[] contactNameStrings = {"John Doe", "Behati Prinsloo", "Candice Swanepoel"};

        // Contact details in list 
        contactDetailsList.add("Goa");
        contactDetailsList.add("Loutolim");
        contactDetailsList.add("Margao");
        contactDetailsList.add("USA");

        // add contacts (populate map)
        for (String contactName : contactNameStrings) {
            contacts.addContact(contactName, contactDetailsList);
        }

        // search for each contact and print returned list
        for (String contactName : contactNameStrings) {
            contactDetailsList = contacts.searchContact(contactName);
            System.out.println(contactName + "--> " + contactDetailsList);
        }

    }
}
