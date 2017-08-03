package zbdy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zbdy.dao.UserDao;
import zbdy.dao.impl.UserDaoImpl;
import zbdy.domain.User;

@Service
public class UserService {
	
	//Autowired can be used directly in private property without set method
	//e.g. @Autowired private UserDao userDao;
	
	private UserDao userDao;
	
	
	//the method is not necessary to be setXXX(), can be aaa()
	//Autowired can be used in any injected method
	//e.g. @Autowired public aaa(UserDao userDao)
	
	@Autowired 
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public void createUser(User user){
		System.out.println("-----------Implemented by UserServcie createUser()-------------");
		this.userDao.addUser(user);
	}
}
