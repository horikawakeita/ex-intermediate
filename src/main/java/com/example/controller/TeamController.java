package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Team;
import com.example.service.TeamService;

/**
 * チーム関連機能の処理の制御を行うコントローラ.
 * 
 * @author keita.horikawa
 *
 */
@Controller
@RequestMapping("/exam01")
public class TeamController {

	/** サービス */
	@Autowired
	private TeamService service;

	/**
	 * チーム一覧を表示するメソッド.
	 * 
	 * @param model requestスコープに格納するためのオブジェクト
	 * @return チーム一覧
	 */
	@RequestMapping("/list")
	public String showList(Model model) {
		List<Team> teamList = service.findAll();
		model.addAttribute("teamList", teamList);
		return "list";
	}
	
	/**
	 * チーム詳細情報を表示するメソッド.
	 * 
	 * @param id 表示するチームのID
	 * @param model requestスコープに格納するためのオブジェクト
	 * @return チーム詳細情報
	 */
	@RequestMapping("/show-detail")
	public String showDetail(Integer id, Model model) {
		Team team = service.load(id);
		model.addAttribute("team", team);
		return "detail";
	}
}
