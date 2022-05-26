package com.qa.ims.controller;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.ItemsDAO;

import com.qa.ims.persistence.dao.OrdersDAO;
import com.qa.ims.persistence.domain.Items;

import com.qa.ims.utils.Utils;

public class ItemsController implements CrudController<Items>{
	
	public static final Logger LOGGER = LogManager.getLogger();

	private ItemsDAO itemsDAO;
	private Utils utils;

	public ItemsController(ItemsDAO itemsDAO, Utils utils) {
		super();
		this.itemsDAO = itemsDAO;
		this.utils = utils;
	}

	@Override
	public List<Items> readAll() {
		List<Items> Itemss = itemsDAO.readAll();
		for (Items Items : Itemss) {
			LOGGER.info(Items);
		}
		return Itemss;
	}

	@Override
	public Items create() {
		LOGGER.info("Please enter a name");
		String Name = utils.getString();
		LOGGER.info("Please enter a value");
	    Double value = utils.getDouble();
		Items Items = itemsDAO.create(new Items(Name, value));
		LOGGER.info("Items created");
		return Items;
	}

	

	@Override
	public Items update() {
		LOGGER.info("Please enter the id of the Items you would like to update");
		Long id = utils.getLong();
		LOGGER.info("Please enter a name");
		String Name = utils.getString();
		LOGGER.info("Please enter a value");
		Double value = utils.getDouble();
		Items Items = itemsDAO.update(new Items(id, Name, value));
		LOGGER.info("Items Updated");
		return Items;
	}

	@Override
	public int delete() {
		LOGGER.info("Please enter the id of the Items you would like to delete");
		Long id = utils.getLong();
		return itemsDAO.delete(id);
	}

	@Override
	public Items readbyID() {
		LOGGER.info("Please enter the id of your Order");
		Long id=utils.getLong();
		ItemsDAO itemsDAO=new ItemsDAO();
		LOGGER.info(itemsDAO.read(id));
		return itemsDAO.read(id);
		
	}

}
