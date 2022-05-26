package com.qa.ims.controller;

import java.util.List;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.qa.ims.persistence.dao.OrdersDAO;
import com.qa.ims.persistence.domain.Orders;
import com.qa.ims.utils.Utils;

public class OrdersController implements CrudController<Orders> {
	
	public static final Logger LOGGER = LogManager.getLogger();
	private OrdersDAO ordersDAO;
	private Utils utils;

	public OrdersController(OrdersDAO ordersDAO, Utils utils) {
		super();
		this.ordersDAO = ordersDAO;
		this.utils = utils;
	}

	@Override
	public List<Orders> readAll() {
			List<Orders> Orderss = ordersDAO.readAll();
			for (Orders Orders : Orderss) {
				LOGGER.info(Orders);
			}
			return Orderss;
		}
	

	@Override
	public Orders create() {
		LOGGER.info("Please enter a CustomerID");
		Long customerID = utils.getLong();
		LOGGER.info("Please enter a ItemID");
		Long itemID= utils.getLong();
		Orders Orders = ordersDAO.create(new Orders(customerID, itemID));
		LOGGER.info("Orders created");
		return Orders;
	}

	

	@Override
	public Orders update() {
		LOGGER.info("Please enter the id of the Orders you would like to update");
		Long id = utils.getLong();
		LOGGER.info("Please enter a CustomerID");
		Long customerID = utils.getLong();
		LOGGER.info("Please enter a ItemID");
		Long itemID = utils.getLong();
		Orders Orders = ordersDAO.update(new Orders(id, customerID, itemID));
		LOGGER.info("Orders Updated");
		return Orders;
	}

	@Override
	public int delete() {
		LOGGER.info("Please enter the id of the Orders you would like to delete");
		Long id = utils.getLong();
		return ordersDAO.delete(id);
	}
	
	//public Double GetOrderValue() {
		//LOGGER.info("Please enter the primary id of the item you want the price for");
		//Long id=utils.getLong();
		//return ordersDAO.calculateItemPrice(id);



	@Override
	public Orders readbyID() {
		LOGGER.info("Please enter the id of your Order");
		Long id=utils.getLong();
		OrdersDAO ordersDAO=new OrdersDAO();
		LOGGER.info("Would you like to know the value of your Order");
		String answer=utils.getString();
		if(answer.equals("yes")) {
			LOGGER.info("Please enter the primary id of the item you want the price for");
			Long id2=utils.getLong();
			return ordersDAO.calculateItemPrice(id2);
		}
		
			return ordersDAO.read(id);	
		}
		
		
}

