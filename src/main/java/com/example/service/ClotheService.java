package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Clothe;
import com.example.repository.ClotheRepository;

/**
 * 衣類に関する業務処理を行うサービス.
 * 
 * @author keita.horikawa
 *
 */
@Service
@Transactional
public class ClotheService {

	/** リポジトリ */
	@Autowired
	private ClotheRepository repository;
	
	/**
	 * 色と性別から衣類を検索するメソッド.
	 * 
	 * @param gender 性別
	 * @param color カラー
	 * @return 検索された衣類のリスト
	 */
	public List<Clothe> searchByColorAndGender(String gender, String color){
		return repository.findByColorAndGender(gender, color);
	}
}
