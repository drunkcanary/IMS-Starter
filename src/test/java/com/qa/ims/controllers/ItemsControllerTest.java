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


import com.qa.ims.controller.ItemsController;
import com.qa.ims.persistence.dao.ItemsDAO;
import com.qa.ims.persistence.domain.Items;
import com.qa.ims.utils.Utils;

@RunWith(MockitoJUnitRunner.class)
public class ItemsControllerTest {
	
	    @Mock
		private Utils utils;

		@Mock
		private ItemsDAO dao;

		@InjectMocks
		private ItemsController controller;

		@Test
		public void testCreate() {
			final String name = "tf2";
			final Double value=1.50;
			final Items created = new Items(name, value);

			Mockito.when(utils.getString()).thenReturn(name);
			Mockito.when(utils.getDouble()).thenReturn(value);
			Mockito.when(dao.create(created)).thenReturn(created);

			assertEquals(created, controller.create());

			Mockito.verify(utils, Mockito.times(1)).getString();
			Mockito.verify(utils, Mockito.times(1)).getDouble();
			Mockito.verify(dao, Mockito.times(1)).create(created);
		}

		@Test
		public void testReadAll() {
			List<Items> Items = new ArrayList<>();
			Items.add(new Items(1L, "drg", 20.00));

			Mockito.when(dao.readAll()).thenReturn(Items);

			assertEquals(Items, controller.readAll());

			Mockito.verify(dao, Mockito.times(1)).readAll();
		}

		@Test
		public void testUpdate() {
			Items updated = new Items(1L, "tf2", 1.50);

			Mockito.when(this.utils.getLong()).thenReturn(1L);
			Mockito.when(this.utils.getString()).thenReturn(updated.getName());
			Mockito.when(this.utils.getDouble()).thenReturn(updated.getValue());
			Mockito.when(this.dao.update(updated)).thenReturn(updated);

			assertEquals(updated, this.controller.update());

			Mockito.verify(this.utils, Mockito.times(1)).getLong();
			Mockito.verify(this.utils, Mockito.times(1)).getString();
			Mockito.verify(this.utils, Mockito.times(1)).getDouble();
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
			final String name = "tf2";
			final Double value=1.50;
			final Long id=1L;
			final Items created = new Items(name, value);

			Mockito.when(utils.getString()).thenReturn(name);
			Mockito.when(utils.getDouble()).thenReturn(value);
			Mockito.when(dao.create(created)).thenReturn(created);
			Mockito.when(dao.read(id)).thenReturn(created);
			
			assertEquals(created, dao.read(id));
			
			
			
		}

}
