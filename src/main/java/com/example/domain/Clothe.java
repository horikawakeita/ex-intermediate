package com.example.domain;

/**
 * 衣類を表すドメイン.
 * 
 * @author keita.horikawa
 *
 */
public class Clothe {

	/** ID */
	private Integer id;

	/** ジャンル */
	private String genre;

	/** サイズ */
	private String size;

	/** 価格 */
	private Integer price;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Clothe [id=" + id + ", genre=" + genre + ", size=" + size + ", price=" + price + "]";
	}

}
