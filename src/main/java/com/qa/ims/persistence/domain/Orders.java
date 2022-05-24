package com.qa.ims.persistence.domain;

public class Orders {

Long id;
Long customerID;
Long itemID;
public Orders(Long customerID, Long itemID) {
	super();
	this.customerID = customerID;
	this.itemID = itemID;
}
public Orders(Long id, Long customerID, Long itemID) {
	super();
	this.id = id;
	this.customerID = customerID;
	this.itemID = itemID;
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public Long getCustomerID() {
	return customerID;
}
public void setCustomerID(Long customerID) {
	this.customerID = customerID;
}
public Long getItemID() {
	return itemID;
}
public void setItemID(Long itemID) {
	this.itemID = itemID;
}
@Override
public String toString() {
	return "Orders [id=" + id + ", customerID=" + customerID + ", itemID=" + itemID + "]";
}




}
