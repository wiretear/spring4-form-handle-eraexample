package com.mkyong.form.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;


import com.mkyong.form.model.User;

@Repository
public class UserDaoImpl implements UserDao {

	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) throws DataAccessException {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	@Override
	public User findById(Integer id) {

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);

		String sql = "SELECT * FROM users WHERE id=:id";

		User result = null;
		try {
			result = namedParameterJdbcTemplate.queryForObject(sql, params, new UserMapper());
		} catch (EmptyResultDataAccessException e) {
			// do nothing, return null
		}

		/*
		 * User result = namedParameterJdbcTemplate.queryForObject( sql, params,
		 * new BeanPropertyRowMapper<User>());
		 */
		return result;

	}

	@Override
	public List<User> findAll() {
		String sql = "SELECT * FROM USERS";
		List<User> result = namedParameterJdbcTemplate.query(sql, new UserMapper());

		return result;

	}
	@Override
	public void save(User user) {

		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		String sql = "INSERT INTO USERS(NAME, EMAIL, ADDRESS, PASSWORD, FRAMEWORK, SEX, COUNTRY, SKILL,PADT, OS,EDUCATION, DESIGNATION, DATABASES ,LT ,TC ,TD) "
				+ "VALUES (:name, :email, :address, :password,:framework, :sex, :country, :skill, :padt, :os,:education,:designation, :databases,:ltt, :tc, :td)";

		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(user), keyHolder,new String[] {"ID"});
		Number generatedId = keyHolder.getKey();
		user.setId(generatedId.intValue());
		
	}

	@Override
	public void update(User user) {

		String sql = "UPDATE USERS SET NAME=:name, EMAIL=:email, ADDRESS=:address, " + "PASSWORD=:password, FRAMEWORK=:framework, "
				+ "SEX=:sex, COUNTRY=:country, SKILL=:skill, PADT=:padt, Databases=:databases, OS=:os, TC=:tc, TD=:td,LT=:ltt, EDUCATION=:education, DESIGNATION=:designation WHERE id=:id";

		namedParameterJdbcTemplate.update(sql,getSqlParameterByModel(user));

	}

	@Override
	public void delete(Integer id) {
 
		String sql = "DELETE FROM USERS WHERE id= :id";
		namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource("id", id));

	}

	private SqlParameterSource getSqlParameterByModel(User user) {

		// Unable to handle List<String> or Array
		// BeanPropertySqlParameterSource

		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("id", user.getId());
		paramSource.addValue("name", user.getName());
		paramSource.addValue("email", user.getEmail());
		paramSource.addValue("address", user.getAddress());
		paramSource.addValue("password", user.getPassword());
		paramSource.addValue("padt", user.getPadt());
		paramSource.addValue("databases",user.getDatabases());
		paramSource.addValue("os",user.getOs());
		paramSource.addValue("ltt",user.getLt());
		paramSource.addValue("tc",user.getTc());
		paramSource.addValue("td",user.getTd());
		paramSource.addValue("education",user.getEducation());
		paramSource.addValue("designation", user.getDesignation());
		// join String
		paramSource.addValue("framework", convertListToDelimitedString(user.getFramework()));
		paramSource.addValue("sex", user.getSex());
	
		paramSource.addValue("country", user.getCountry());
		paramSource.addValue("skill", convertListToDelimitedString(user.getSkill()));

		return paramSource;
	}

	private static final class UserMapper implements RowMapper<User> {

		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User user = new User();
			user.setId(rs.getInt("id"));
			user.setName(rs.getString("name"));
			user.setEmail(rs.getString("email"));
			user.setFramework(convertDelimitedStringToList(rs.getString("framework")));
			user.setAddress(rs.getString("address"));
			user.setCountry(rs.getString("country"));
		    user.setDatabases(rs.getString("databases"));
		    user.setLt(rs.getString("lt"));
		    user.setOs(rs.getString("os"));
		    user.setPadt(rs.getString("padt"));
		    user.setTc(rs.getString("tc"));
		    user.setTd(rs.getString("td"));
			user.setPassword(rs.getString("password"));
			user.setSex(rs.getString("sex"));
			user.setSkill(convertDelimitedStringToList(rs.getString("skill")));
			user.setDesignation(rs.getString("designation"));
			user.setEducation(rs.getString("education"));
			
			return user;
		}
	}

	private static List<String> convertDelimitedStringToList(String delimitedString) {

		List<String> result = new ArrayList<String>();

		if (!StringUtils.isEmpty(delimitedString)) {
			result = Arrays.asList(StringUtils.delimitedListToStringArray(delimitedString, ","));
		}
		return result;
	}
	private String convertListToDelimitedString(List<String> list) {
		String result = "";
		if (list != null) {
			result = StringUtils.arrayToCommaDelimitedString(list.toArray());
		}
		return result;
	}


	   public User validateUser(User login) {

		    String sql = "select * from users where name='" + login.getName() + "' and password='" + login.getPassword()

		    + "'";
		    List<User> users = namedParameterJdbcTemplate.query(sql, new UserMapper());

		    return users.size() > 0 ? users.get(0) : null;

		    }
	
		  
	

}