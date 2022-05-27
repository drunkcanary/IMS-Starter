package com.qa.ims.controllers;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.controller.OrdersController;
import com.qa.ims.persistence.dao.OrdersDAO;
import com.qa.ims.persistence.domain.Orders;
import com.qa.ims.utils.Utils;



@RunWith(MockitoJUnitRunner.class)
public class OrdersControllerTest {
            @Mock
			private Utils utils;

			@Mock
			private OrdersDAO dao;

			@InjectMocks
			private OrdersController controller;

			@Test
			public void testCreate() {
				final Long customerID = 1L;
				final Long itemID=1L;
				final Orders created = new Orders(customerID, itemID);

				Mockito.when(utils.getLong()).thenReturn(customerID, itemID);
				Mockito.when(dao.create(created)).thenReturn(created);

				assertEquals(created, controller.create());

			
				Mockito.verify(utils, Mockito.times(2)).getLong();
				Mockito.verify(dao, Mockito.times(1)).create(created);
			}

			@Test
			public void testReadAll() {
				List<Orders> Orders = new ArrayList<>();
				Orders.add(new Orders(1L, 1L, 2L));

				Mockito.when(dao.readAll()).thenReturn(Orders);

				assertEquals(Orders, controller.readAll());

				Mockito.verify(dao, Mockito.times(1)).readAll();
			}

			@Test
			public void testUpdate() {
				Orders updated = new Orders(1L, 1L, 1L);

				Mockito.when(this.utils.getLong()).thenReturn(1L);
				Mockito.when(this.utils.getLong()).thenReturn(updated.getCustomerID(),updated.getItemID());
				
				Mockito.when(this.dao.update(updated)).thenReturn(updated);

				assertEquals(updated, this.controller.update());

				Mockito.verify(this.utils, Mockito.times(3)).getLong();
				Mockito.verify(this.dao, Mockito.times(1)).update(updated);
			}

			@Test
			public void testDelete() {
				final long ID = 1L;

				Mockito.when(utils.getLong()).thenReturn(ID);
				Mockito.when(dao.delete(ID)).thenReturn(1);

				assertEquals(1L, this.controller.delete());

				Mockito.verify(utils, Mockito.times(1)).getLong();
				Mockito.verify(dao, Mockito.times(1)).delete(ID);
			}
			
			@Test
			public void testReadID() {
				final Long customerID = 1L,itemID=1L;
				final long id=1L;
				final Orders created = new Orders(customerID, itemID);

				Mockito.when(utils.getLong()).thenReturn(customerID,itemID);
				Mockito.when(dao.create(created)).thenReturn(created);
				Mockito.when(dao.read(id)).thenReturn(created);
				
				assertEquals(created, dao.read(id));}

}
