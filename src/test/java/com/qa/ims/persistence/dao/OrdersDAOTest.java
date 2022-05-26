package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.qa.ims.persistence.domain.Orders;
import com.qa.ims.utils.DBUtils;

public class OrdersDAOTest {
	
	
	
	
	private final OrdersDAO ordersDAO=new OrdersDAO();
	
	
	@Before
	public  void setup() {
		DBUtils.connect();
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
	}
	
	@Test
	public void testCreate() {
		final Orders created = new Orders(2L, 1L, 1L);
		final Orders product=new Orders(1L,1L);
		assertEquals(created, ordersDAO.create(product));
	}
	@Test
	public void testReadAll() {
		List<Orders> expected = new ArrayList<>();
		expected.add(new Orders(1L, 1L, 1L));
		assertEquals(expected, ordersDAO.readAll());
	}

	@Test
	public void testReadLatest() {
		assertEquals(new Orders(1L, 1L, 1L), ordersDAO.readLatest());
	}

	@Test
	public void testRead() {
		final long ID = 1L;
		assertEquals(new Orders(ID, 1L, 1L), ordersDAO.read(ID));
	}

	@Test
	public void testUpdate() {
		final Orders updated = new Orders(1L, 1L, 1L);
		assertEquals(updated, ordersDAO.update(updated));

	}

	@Test
	public void testDelete() {
		assertEquals(1L, ordersDAO.delete(1L));}
	
	@Test
	public void readIDTest() {
		Long id=1L;
		Orders expected=new Orders(1L,1L,1L);
		//DAO.create(expected);
		assertEquals( expected,ordersDAO.read(id));
	}

}
