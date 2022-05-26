package com.qa.ims.persistence.dao;
import static org.junit.Assert.assertEquals;


import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;


import com.qa.ims.persistence.domain.Items;
import com.qa.ims.utils.DBUtils;

public class ItemsDAOTest {
	private final ItemsDAO itemsDAO=new ItemsDAO();
	
	
	@Before
	public void setup() {
		DBUtils.connect();
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
	}
	
	@Test
	public void testCreate() {
		final Items created = new Items( "tf2", 1.50);
		assertEquals(created, itemsDAO.create(created));
	}

	
	

}
