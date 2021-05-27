package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Clothe;


/**
 * clothesテーブルを操作するリポジトリ.
 * 
 * @author keita.horikawa
 *
 */
@Repository
public class ClotheRepository {

	/** clotheオブジェクトを生成するRowMapper */
	private static final RowMapper<Clothe> CLOTHE_ROW_MAPPER = (rs, i) -> {
		Clothe clothe = new Clothe();
		clothe.setId(rs.getInt("id"));
		clothe.setGenre(rs.getString("genre"));
		clothe.setSize(rs.getString("size"));
		clothe.setPrice(rs.getInt("price"));
		return clothe;
	};

	/** テンプレート */
	@Autowired
	private NamedParameterJdbcTemplate template;

	/** 衣類情報が入ったテーブル名 */
	private final String TABLE = "clothes";
	
	/**
	 * 選択された性別と色から衣類を検索するメソッド.
	 * 
	 * @param gender 性別
	 * @param color カラー
	 * @return 検索された衣類のリスト
	 */
	public List<Clothe> findByColorAndGender(String gender, String color){
		String sql = "select id,genre,size,price from " + TABLE + " where gender=:gender and color=:color;";
		SqlParameterSource param = new MapSqlParameterSource().addValue("gender", Integer.parseInt(gender)).addValue("color", color);
		return template.query(sql, param, CLOTHE_ROW_MAPPER);
	}

}
