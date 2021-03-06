package zbdy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import zbdy.dao.UserDao;
import zbdy.model.User;
import zbdy.service.UserService;


@Service
public class UserServiceImpl implements UserService{
	
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
	//when using JDBC to get connection, @Transactional will not effect
	public void createUser(User user) {
		System.out.println("-----------Implemented by UserServcie createUser()-------------");
			
			this.userDao.insertUser(user);
			//throw new RuntimeException("事务回滚测试"); 
	}
}
