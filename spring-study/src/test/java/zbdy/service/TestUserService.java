package zbdy.service;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import zbdy.model.User;

public class TestUserService {
	
	private ApplicationContext context = new ClassPathXmlApplicationContext("datasource-config-xml-way.xml");
	private UserService userService = context.getBean(UserService.class);

	@Test
	public void testCreateUser() {
		
		userService.createUser(new User("8989", "abcd"));
	}
	
}
