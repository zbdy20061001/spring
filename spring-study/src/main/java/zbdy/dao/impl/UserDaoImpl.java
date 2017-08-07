package zbdy.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import zbdy.dao.UserDao;
import zbdy.model.User;

@Repository
public class UserDaoImpl implements UserDao {
	
	private DataSource dataSource;
	
	@Autowired
	@Required
	public void setDatasource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public void insertUser(User user)  {
		System.out.println("-------Implemented by UserDaoImp insertUser()----------");
		
		Connection conn;
		try {
			conn = this.dataSource.getConnection();
			System.out.println(conn);
			PreparedStatement ps = conn.prepareStatement("INSERT INTO APP.ACCOUNT VALUES(?, ?)"); 
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		System.out.println("-----username:" + user.getUsername() + "------");
	}

}
