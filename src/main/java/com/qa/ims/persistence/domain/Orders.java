package com.qa.ims.persistence.domain;

public class Orders {

int id;
int customerID;
int itemID;
public Orders(int customerID, int itemID) {
	super();
	this.customerID = customerID;
	this.itemID = itemID;
}
public Orders(int id, int customerID, int itemID) {
	super();
	this.id = id;
	this.customerID = customerID;
	this.itemID = itemID;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getCustomerID() {
	return customerID;
}
public void setCustomerID(int customerID) {
	this.customerID = customerID;
}
public int getItemID() {
	return itemID;
}
public void setItemID(int itemID) {
	this.itemID = itemID;
}
@Override
public String toString() {
	return "Orders [id=" + id + ", customerID=" + customerID + ", itemID=" + itemID + "]";
}




}
