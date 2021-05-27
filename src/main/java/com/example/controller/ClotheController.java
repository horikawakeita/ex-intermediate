package com.example.controller;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.form.ClotheForm;
import com.example.service.ClotheService;

/**
 * 衣類関連機能の処理の制御を行うコントローラ.
 * 
 * @author keita.horikawa
 *
 */
@Controller
@RequestMapping("/exam03")
public class ClotheController {
	
	/** サービス */
	@Autowired
	private ClotheService service;

	/**
	 * フォームオブジェクトをrequestスコープに格納
	 * 
	 * @return フォームオブジェクト
	 */
	@ModelAttribute
	public ClotheForm setUpClotheForm() {
		return new ClotheForm();
	}
	
	/**
	 * 衣類検索画面を表示するメソッド.
	 * 
	 * @param model requestスコープに格納するためのオブジェクト
	 * @return 衣類検索画面
	 */
	@RequestMapping("/search")
	public String search(Model model) {
		List<String> colorList = new ArrayList<>();
		colorList.add("赤");
		colorList.add("青");
		colorList.add("白");
		colorList.add("黄");
		model.addAttribute("colorList", colorList);
		return "clothe-search";
	}
	
	/**
	 * 衣類を検索し表示するメソッド.
	 * 
	 * @param form 入力された値が入ったフォーム
	 * @param model requestスコープに格納するためのオブジェクト
	 * @return 検索画面
	 */
	@RequestMapping("/show-clothe")
	public String showClothe(ClotheForm form, Model model) {
		model.addAttribute("clotheList",service.searchByColorAndGender(form.getGender(), form.getColor()));
		return search(model);
	}
	
	
}
