package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Hotel;
import com.example.repository.HotelRepository;

@Service
@Transactional
/**
 * ホテルの業務処理を行うサービス.
 * 
 * @author keita.horikawa
 *
 */
public class HotelService {

	/** リポジトリ */
	@Autowired
	private HotelRepository repository;
	
	/**
	 * 入力された価格以下のホテルの検索を行うメソッド.
	 * 空欄の場合は全件検索を行う
	 * 
	 * @param price 価格
	 * @return 検索されたホテルのリスト
	 */
	public List<Hotel> searchByLessThanPrice(String price){
		if(price.equals("")) {
			return repository.findAll();
		}else {
			return repository.findByLessThanPrice(Integer.parseInt(price));
		}
	}
}
