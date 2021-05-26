package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Team;
import com.example.repository.TeamRepository;

/**
 * チームの業務処理を行うサービス.
 * 
 * @author keita.horikawa
 *
 */
@Service
@Transactional
public class TeamService {

	@Autowired
	private TeamRepository repository;
	
	/**
	 * 主キー検索を行うメソッド.
	 * 
	 * @param id 検索したいチームのID
	 * @return 検索されたチーム
	 */
	public Team load(Integer id) {
		return repository.load(id);
	}
	
	/**
	 * 全件検索を行うメソッド.
	 * 
	 * @return 検索されたリスト
	 */
	public List<Team> findAll(){
		return repository.findAll();
	}
}
