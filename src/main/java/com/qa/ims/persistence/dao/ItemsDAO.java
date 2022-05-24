package com.qa.ims.persistence.dao;

import java.sql.Connection;
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

	@Override
	public List<Items> readAll() {
	  try (Connection connection=DBUtils.getInstance().getConnection(); 
			Statement statement=connection.createStatement();
			String query="SELECT * FROM customers;";
				ResultSet resultSet = statement.executeQuery(query);) {
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
	}
				

		
		
	

	@Override
	public Items read(Long id) {
		
		return null;
	}

	@Override
	public Items create(Items t) {
		
		return null;
	}

	@Override
	public Items update(Items t) {
		
		return null;
	}

	@Override
	public int delete(long id) {
		
		return 0;
	}

	@Override
	public Items modelFromResultSet(ResultSet resultSet) throws SQLException {
		
		return null;
	}

}
