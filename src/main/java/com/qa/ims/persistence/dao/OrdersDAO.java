package com.qa.ims.persistence.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.domain.Orders;
import com.qa.ims.persistence.domain.Items;
import com.qa.ims.utils.DBUtils;

public class OrdersDAO implements Dao<Orders> {
	
	public static final Logger LOGGER = LogManager.getLogger();
	public String query1="SELECT * FROM Orders;";
	

	@Override
	public List<Orders> readAll() {
		try (Connection connection=DBUtils.getInstance().getConnection(); 
				Statement statement=connection.createStatement();
				//String query="SELECT * FROM items;";
					ResultSet resultSet = statement.executeQuery(query1);) {
						List<Orders> Orders = new ArrayList<>();
						while (resultSet.next()) {
							Orders.add(modelFromResultSet(resultSet));
						}
						return Orders;
					} catch (SQLException e) {
						LOGGER.debug(e);
						LOGGER.error(e.getMessage());
					}
					return new ArrayList<>();
				
	}
		

	@Override
	public Orders read(Long id) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("SELECT * FROM Orders WHERE id = ?");) {
			statement.setLong(1, id);
			try (ResultSet resultSet = statement.executeQuery();) {
				resultSet.next();
				return modelFromResultSet(resultSet);
			}
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	
		
		
		
		
	
	
	
	public Orders readLatest() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM Orders ORDER BY id DESC LIMIT 1");) {
			resultSet.next();
			return modelFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	
	
		

	@Override
	public Orders create(Orders Orders) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("INSERT INTO Orders(customerID, ItemID) VALUES (?, ?)");) {
			statement.setLong(1, Orders.getCustomerID());
			statement.setLong(2, Orders.getItemID());
			statement.executeUpdate();
			return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}
		

	@Override
	public Orders update(Orders Orders) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("UPDATE Orders SET customerID = ?, itemID = ? WHERE id = ?");) {
			statement.setLong(1, Orders.getCustomerID());
			statement.setLong(2, Orders.getItemID());
			statement.setLong(3, Orders.getId());
			statement.executeUpdate();
			return read(Orders.getId());
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}
		

	@Override
	public int delete(long id) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("DELETE FROM Orders WHERE id = ?");) {
			statement.setLong(1, id);
			return statement.executeUpdate();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return 0;
	}
		

	@Override
	public Orders modelFromResultSet(ResultSet resultSet) throws SQLException {
		Long id = resultSet.getLong("id");
		Long customerID = resultSet.getLong("customerID");
		Long itemID = resultSet.getLong("itemId");
		return new Orders(id, customerID, itemID);
	}

	public Double calculateItemPrice(Long id) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("SELECT value FROM items WHERE id = ?;");){
			statement.setLong(1, id);
		ResultSet resultSet=statement.executeQuery();
		resultSet.next();
		Double price=resultSet.getDouble(1);
		return price;
		
		
		
	}catch(Exception e) {
		LOGGER.debug(e);
		LOGGER.error(e.getMessage());
	}
		return null;}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


}
