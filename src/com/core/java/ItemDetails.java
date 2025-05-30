package com.core.java;

public class ItemDetails {
	private int itemId;
	public ItemDetails(int itemId) {
		this.itemId = itemId;
	}
	public int getItemId() {
		return itemId;
	}
	
	@Override
	public String toString() {
		return "ItemDetails{item=" + itemId + "}";
	}
}
