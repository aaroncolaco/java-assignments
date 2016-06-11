package com.util;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
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

			statement = connection.createStatement();
			resultSet = statement.executeQuery("Select * from cheese_tbl");

			while (resultSet.next()) {
				item = new Item();

				item.setId(Integer.parseInt(resultSet.getString("id")));
				item.setDescription(resultSet.getString("description"));
				item.setWeight(Float.parseFloat(resultSet.getString("weight")));
				item.setPrice(Float.parseFloat(resultSet.getString("price")));
				item.setManufacturingDate(Date.valueOf(resultSet.getString("mfg_date")));
				item.setUseBeforeMonths(Integer.parseInt(resultSet.getString("UseBeforeInMonths")));

				itemsList.add(item);
			}
			
			// for milk table
			resultSet = statement.executeQuery("Select * from milk_tbl");

			while (resultSet.next()) {
				item = new Item();

				item.setId(Integer.parseInt(resultSet.getString("id")));
				item.setDescription(resultSet.getString("description"));
				item.setWeight(Float.parseFloat(resultSet.getString("weight")));
				item.setPrice(Float.parseFloat(resultSet.getString("price")));
				item.setManufacturingDate(Date.valueOf(resultSet.getString("mfg_date")));
				item.setUseBeforeMonths(Integer.parseInt(resultSet.getString("UseBeforeInMonths")));

				itemsList.add(item);
			}

			// for wheat table
			resultSet = statement.executeQuery("Select * from wheat_tbl");

			while (resultSet.next()) {
				item = new Item();

				item.setId(Integer.parseInt(resultSet.getString("id")));
				item.setDescription(resultSet.getString("description"));
				item.setWeight(Float.parseFloat(resultSet.getString("weight")));
				item.setPrice(Float.parseFloat(resultSet.getString("price")));
				item.setManufacturingDate(Date.valueOf(resultSet.getString("mfg_date")));
				item.setUseBeforeMonths(Integer.parseInt(resultSet.getString("UseBeforeInMonths")));

				itemsList.add(item);
			}

			databaseConnectionManager.closeConnection();

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
		
		Date date = null;
		Calendar calendar = Calendar.getInstance();
		
		for (Item item : items) {
			
			date = (Date) item.getManufacturingDate();
			
			calendar.setTime(date);
			
			calendar.add(Calendar.MONTH, item.getUseBeforeMonths());
			
			item.setExpiryDate(calendar.getTime());
		}

	}

	@Override
	public void removeExpiredItems(List<Item> items) {
		// TODO Auto-generated method stub
		
		Date date = null;
		Calendar calendar = Calendar.getInstance();
		
		for (Item item : items) {
			
			date = (Date) item.getManufacturingDate();
			
			if (calendar.before(date)) {
				items.remove(item);
			}
			
		}

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
		
		List <Item> itemsList = new ArrayList<>();
		
		for (Item item : list) {
			if (item.getDescription().contains(ItemType)) {
				itemsList.add(item);
			}
		}
		
		if (itemsList.size() < 1) {
			throw new NoDataFoundException();
		}
		
		return itemsList;
	}

}
