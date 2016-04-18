package com.sample;

class Item
{
    private String id;
    private String description;

	public Item(String string, String description) {
		this.id = string;
		this.description = description;
	}

	public String getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public String toString() {
		return description;
	}
}
