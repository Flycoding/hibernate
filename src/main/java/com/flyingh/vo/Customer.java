package com.flyingh.vo;

import java.util.Arrays;

public class Customer {
	private int id;
	private String name;
	private String[] addresses;

	public Customer() {
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

	public String[] getAddresses() {
		return addresses;
	}

	public void setAddresses(String[] addresses) {
		this.addresses = addresses;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", addresses=" + Arrays.toString(addresses) + "]";
	}

}
