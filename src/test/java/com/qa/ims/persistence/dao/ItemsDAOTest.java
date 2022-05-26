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
	public  void setup() {
		DBUtils.connect();
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
	}
	
	@Test
	public void testCreate() {
		final Items created = new Items(2L, "tf2", 1.5);
		final Items product=new Items("tf2",1.5);
		assertEquals(created, itemsDAO.create(product));
	}
	@Test
	public void testReadAll() {
		List<Items> expected = new ArrayList<>();
		expected.add(new Items(1L, "tf2", 1.50));
		assertEquals(expected, itemsDAO.readAll());
	}

	@Test
	public void testReadLatest() {
		assertEquals(new Items(1L, "tf2", 1.5), itemsDAO.ReadLatest());
	}

	@Test
	public void testRead() {
		final long ID = 1L;
		assertEquals(new Items(ID, "tf2", 1.50), itemsDAO.read(ID));
	}

	@Test
	public void testUpdate() {
		final Items updated = new Items(1L, "tf2", 1.50);
		assertEquals(updated, itemsDAO.update(updated));

	}

	@Test
	public void testDelete() {
		assertEquals(1, itemsDAO.delete(1));}
	
	@Test
	public void readIDTest() {
		Long id=1l;
		Items expected=new Items(1l,"tf2",1.5);
		//DAO.create(expected);
		assertEquals( expected,itemsDAO.read(id));
	}

	
	

}
