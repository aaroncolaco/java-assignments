package com.psl;

import java.util.ArrayList;
import java.util.List;

import com.bean.Item;
import com.exception.NoDataFoundException;
import com.util.InventoryServiceImpl;

public class Client {

	/**
	 * @param args
	 * @throws NoDataFoundException 
	 */
	
	public static void main(String[] args) throws NoDataFoundException {
		// Call all the functionalities from here to test your code.
		List <Item> itemsList = new ArrayList<>();
		
		InventoryServiceImpl inventoryServiceImpl = new InventoryServiceImpl();
		
		itemsList = inventoryServiceImpl.readAllItemsFromDb();
		
		inventoryServiceImpl.calculateExpiryDate(itemsList);
		
		inventoryServiceImpl.removeExpiredItems(itemsList);
		
		itemsList = inventoryServiceImpl.searchItem("Wheat", itemsList);
		
	}
		
}
