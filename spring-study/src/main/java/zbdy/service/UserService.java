package zbdy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zbdy.dao.UserDao;
import zbdy.dao.impl.UserDaoImpl;
import zbdy.domain.User;

@Service
public class UserService {
	
	private UserDao userDao;
	
	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public void createUser(User user){
		System.out.println("-----------Implemented by UserServcie createUser()-------------");
		this.userDao.addUser(user);
	}
}
