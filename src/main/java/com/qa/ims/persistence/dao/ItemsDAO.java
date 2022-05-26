package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.persistence.domain.Items;
import com.qa.ims.utils.DBUtils;

public class ItemsDAO implements Dao<Items>{
	
	public static final Logger LOGGER = LogManager.getLogger();

	public String query1="SELECT * FROM items;";
	@Override
	public List<Items> readAll() {
	  try (Connection connection=DBUtils.getInstance().getConnection(); 
			Statement statement=connection.createStatement();
			//String query="SELECT * FROM items;";
				ResultSet resultSet = statement.executeQuery(query1);) {
					List<Items> items = new ArrayList<>();
					while (resultSet.next()) {
						items.add(modelFromResultSet(resultSet));
					}
					return items;
				} catch (SQLException e) {
					LOGGER.debug(e);
					LOGGER.error(e.getMessage());
				}
				return new ArrayList<>();
			}
	
	public Items ReadLatest() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM items ORDER BY id DESC LIMIT 1");) {
			resultSet.next();
			return modelFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}			

		
	@Override
	public Items read(Long id) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("SELECT * FROM items WHERE id = ?");) {
			statement.setLong(1, id);
			try (ResultSet resultSet = statement.executeQuery();) {
				resultSet.next();
				return modelFromResultSet(resultSet);
			}
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
			return null;
		}
		
	}
	

		
	

		
	
	

	@Override
	public Items create(Items items) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("INSERT INTO items(name, value) VALUES (?, ?)");) {
			statement.setString(1, items.getName());
			statement.setDouble(2, items.getValue());
			statement.executeUpdate();
			return ReadLatest();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
		
		}

	@Override
	public Items update(Items items) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("UPDATE items SET name = ?, value = ? WHERE id= ?");) {
			statement.setString(1, items.getName());
			statement.setDouble(2, items.getValue());
			statement.setLong(3, items.getId());
			statement.executeUpdate();
			return read(items.getId());
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}	
		
		
	

	@Override
	public int delete(long id) {
		try (Connection connection = DBUtils.getInstance().getConnection();
					PreparedStatement statement = connection.prepareStatement("DELETE FROM items WHERE id = ?");) {
				statement.setLong(1, id);
				return statement.executeUpdate();
			} catch (Exception e) {
				LOGGER.debug(e);
				LOGGER.error(e.getMessage());
			}
			return 0;
		}
		
		
	

	@Override
	public Items modelFromResultSet(ResultSet resultSet) throws SQLException {
		Long id = resultSet.getLong("id");
		String Name = resultSet.getString("name");
		double value = resultSet.getDouble("value");
		return new Items(id, Name, value);
		
		
	}

}
