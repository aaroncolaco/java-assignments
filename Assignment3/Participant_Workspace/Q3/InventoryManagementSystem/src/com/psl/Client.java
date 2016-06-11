package com.psl;

import java.util.ArrayList;
import java.util.List;

import com.bean.Item;
import com.util.InventoryServiceImpl;

public class Client {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		// Call all the functionalities from here to test your code.
		List <Item> itemsList = new ArrayList<>();
		
		InventoryServiceImpl inventoryServiceImpl = new InventoryServiceImpl();
		
		itemsList = inventoryServiceImpl.readAllItemsFromDb();
		
		for (Item item : itemsList) {
			System.out.println(item.getDescription());
		}
	}
		
}
