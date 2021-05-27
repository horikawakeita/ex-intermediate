package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Hotel;

/**
 * hotelsテーブルを操作するリポジトリ.
 * 
 * @author keita.horikawa
 *
 */
@Repository
public class HotelRepository {

	/** hotelオブジェクトを生成するRowMapper */
	private static final RowMapper<Hotel> HOTEL_ROW_MAPPER = (rs, i) -> {
		Hotel hotel = new Hotel();
		hotel.setId(rs.getInt("id"));
		hotel.setHotelName(rs.getString("hotel_name"));
		hotel.setNearestStation(rs.getString("nearest_station"));
		hotel.setPrice(rs.getInt("price"));
		return hotel;
	};

	/** テンプレート */
	@Autowired
	private NamedParameterJdbcTemplate template;

	/** ホテル情報が入ったテーブル名 */
	private final String TABLE = "hotels";

	/**
	 * ホテル情報を全件検索するメソッド.
	 * 
	 * @return 全ホテルのリスト(価格の降順)
	 */
	public List<Hotel> findAll() {
		String sql = "select id,hotel_name,nearest_station,price from " + TABLE + " order by price desc;";
		List<Hotel> hotelList = template.query(sql, HOTEL_ROW_MAPPER);
		return hotelList;
	}

	/**
	 * 入力された値段以下のホテルを検索するメソッド.
	 * 
	 * @param price 価格
	 * @return 検索されたホテルのリスト(価格の降順)
	 */
	public List<Hotel> findByLessThanPrice(Integer price) {
		String sql = "select id,hotel_name,nearest_station,price from " + TABLE
				+ " where price <= :price order by price desc;";
		SqlParameterSource param = new MapSqlParameterSource().addValue("price", price);
		List<Hotel> hotelList = template.query(sql, param, HOTEL_ROW_MAPPER);
		return hotelList;
	}

}
