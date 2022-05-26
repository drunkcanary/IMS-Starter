package com.qa.ims.persistence.domain;

import java.util.Objects;

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
@Override
public int hashCode() {
	return Objects.hash(customerID, id, itemID);
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Orders other = (Orders) obj;
	return Objects.equals(customerID, other.customerID) && Objects.equals(id, other.id)
			&& Objects.equals(itemID, other.itemID);
}



}
