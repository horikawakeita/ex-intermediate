package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.form.HotelForm;
import com.example.service.HotelService;

/**
 * ホテル関連機能の処理の制御を行うコントローラ.
 * 
 * @author keita.horikawa
 *
 */
@Controller
@RequestMapping("/exam02")
public class HotelController {

	/** サービス */
	@Autowired
	private HotelService service;

	/**
	 * フォームオブジェクトをrequestスコープに格納
	 * 
	 * @return フォームオブジェクト
	 */
	@ModelAttribute
	public HotelForm setUpHotelForm() {
		return new HotelForm();
	}

	/**
	 * ホテル検索画面を表示するメソッド.
	 * 
	 * @return 検索画面
	 */
	@RequestMapping("/search")
	public String search() {
		return "search";
	}

	/**
	 * ホテルを検索して表示するメソッド.
	 * 
	 * @param form 入力された値の入ったフォーム
	 * @param model requestスコープに格納するためのオブジェクト
	 * @return 検索画面
	 */
	@RequestMapping("/show-hotel")
	public String showHotel(HotelForm form, Model model) {
		model.addAttribute("hotelList", service.searchByLessThanPrice(form.getPrice()));
		return "search";
	}
}
