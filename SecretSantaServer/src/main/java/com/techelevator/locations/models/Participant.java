package com.techelevator.locations.models;

public class Participant {
	private int id;
	private String name;
	private String address;
	private String wishlist;

	public Participant(String name, String wishlist, String address) {
		this.name = name;
		this.address = address;
		this.wishlist = wishlist;
	}

	
	public Participant(int id, String name, String wishlist, String address) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.wishlist = wishlist;
	}

	
	public Participant() {
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getWishlist() {
		return wishlist;
	}
	public void setWishlist(String wishlist) {
		this.wishlist = wishlist;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

}
