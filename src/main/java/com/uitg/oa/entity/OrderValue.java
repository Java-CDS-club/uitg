package com.uitg.oa.entity;

import java.io.Serializable;
import java.util.List;

public class OrderValue implements Serializable {
	private Order order;
	private List<User> users;

	public OrderValue() {
		super();
	}
	
	public OrderValue(List<User> users) {
		super();
		this.users = users;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}
