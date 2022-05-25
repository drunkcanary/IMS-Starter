package com.qa.ims.persistence.domain;

public class Items {
private Long id;
private String name;
private Double value;
public Items(String name, Double value) {
	super();
	this.name = name;
	this.value = value;
}
public Items(Long id, String name, Double value) {
	super();
	this.id = id;
	this.name = name;
	this.value = value;
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Double getValue() {
	return value;
}
public void setValue(Double value) {
	this.value = value;
}
@Override
public String toString() {
	return "Items [id=" + id + ", name=" + name + ", value=" + value + "]";
}







}
