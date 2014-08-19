package com.flyingh.vo;

import java.util.List;

public class Customer {
	private int id;
	private String name;
	private List<String> addresses;

	public Customer() {
	}

	public Customer(int id, String name, List<String> addresses) {
		this.id = id;
		this.name = name;
		this.addresses = addresses;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<String> addresses) {
		this.addresses = addresses;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", addresses=" + addresses + "]";
	}

}
