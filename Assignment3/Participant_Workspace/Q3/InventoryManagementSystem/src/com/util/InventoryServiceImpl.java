package com.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bean.Item;
import com.exception.NoDataFoundException;

// Override and implement all the methods of DBConnectionUtil Interface in this class
public class InventoryServiceImpl implements InventoryService {

	@Override
	public List<Item> readAllItemsFromDb() {
		Item item = new Item();
		List<Item> itemsList = new ArrayList<>();
		
		DatabaseConnectionManager databaseConnectionManager = new DatabaseConnectionManager();
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		
		
		try {
			connection = databaseConnectionManager.getConnection();
			//databaseConnectionManager.closeConnection();
			
			statement = connection.createStatement();
			resultSet = statement.executeQuery("Select * from cheese_tbl, milk_tbl, wheat_tbl");
			
			while (resultSet.next()) {
				item.setDescription(resultSet.getString("Description"));
				
				
				itemsList.add(item);
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return itemsList;
	}

	@Override
	public void calculateExpiryDate(List<Item> items) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeExpiredItems(List<Item> items) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sortItems(List<Item> items) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void applyDiscount(List<Item> items) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Item> searchItem(String ItemType, List<Item> list) throws NoDataFoundException {
		// TODO Auto-generated method stub
		return null;
	}
		
}
