package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Team;

/**
 * teamsテーブル操作するリポジトリ.
 * 
 * @author keita.horikawa
 *
 */
@Repository
public class TeamRepository {
	/** Teamオブジェクトを生成するRowMapper */
	private static final RowMapper<Team> TEAM_ROW_MAPPER = (rs,i) -> {
		Team team = new Team();
		team.setId(rs.getInt("id"));
		team.setTeamName(rs.getString("team_name"));
		team.setHeadquarters(rs.getString("headquarters"));
		team.setInauguration(rs.getString("inauguration"));
		team.setHistory(rs.getString("history"));
		return team;
	};

	/** テンプレート */
	@Autowired
	private NamedParameterJdbcTemplate template;

	/** 使用するチーム情報が入ったテーブル名 */
	private final String TABLE = "teams";

	/**
	 * 全チームを発足日順で検索するメソッド.
	 * 
	 * @return 検索してきたリスト
	 */
	public List<Team> findAll() {
		String sql = "select id,team_name,headquarters,inauguration,history from " + TABLE
				+ " order by inauguration;";
		List<Team> teamList = template.query(sql, TEAM_ROW_MAPPER);
		return teamList;
	}

	/**
	 * 主キーのidが一致するチームを検索してくるメソッド.
	 * 
	 * @param id 検索したいチームのID
	 * @return 検索されたチーム
	 */
	public Team load(Integer id) {
		String sql = "select id,team_name,headquarters,inauguration,history from " + TABLE + " where id=:id;";
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
		Team team = template.queryForObject(sql, param, TEAM_ROW_MAPPER);

		return team;
	}
}
