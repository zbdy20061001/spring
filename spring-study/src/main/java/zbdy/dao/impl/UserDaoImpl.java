package zbdy.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import zbdy.dao.UserDao;
import zbdy.model.User;

@Repository
public class UserDaoImpl implements UserDao {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	@Required
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void insertUser(User user)  {
		System.out.println("-------Implemented by UserDaoImp insertUser()----------");
		String sql = "INSERT INTO APP.ACCOUNT VALUES(?, ?)";
		this.jdbcTemplate.update(sql, user.getUsername(), user.getPassword());
		System.out.println("-----username:" + user.getUsername() + "------");
	}

}
