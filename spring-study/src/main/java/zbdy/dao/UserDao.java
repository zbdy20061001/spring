package zbdy.dao;

import java.sql.SQLException;

import zbdy.model.User;

public interface UserDao {
	
	public void insertUser(User user) throws SQLException;
	
}
