package zbdy.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import zbdy.dao.UserDao;
import zbdy.dao.impl.UserDaoImpl;
import zbdy.model.User;


@Service
public class UserService {
	
	//Autowired can be used directly in private property without set method
	//e.g. @Autowired private UserDao userDao;
	
	private UserDao userDao;
	
	
	//the method is not necessary to be setXXX(), can be aaa()
	//Autowired can be used in any injected method
	//e.g. @Autowired public aaa(UserDao userDao)
	
	@Autowired 
	@Required
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Transactional
	public void createUser(User user) throws SQLException {
		System.out.println("-----------Implemented by UserServcie createUser()-------------");
			this.userDao.insertUser(user);
	}
}
