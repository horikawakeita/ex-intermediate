package com.example.form;

/**
 * 衣類検索の際に使用するフォーム.
 * 
 * @author keita.horikawa
 *
 */
public class ClotheForm {

	/** 性別 */
	private String gender;

	/** カラー */
	private String color;

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "ClotheForm [gender=" + gender + ", color=" + color + "]";
	}

}
