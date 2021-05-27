package com.example.form;

/**
 * ホテル検索時に使用するフォーム.
 * 
 * @author keita.horikawa
 *
 */
public class HotelForm {
	/** 価格 */
	private String price;

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "HotelForm [price=" + price + "]";
	}

}
