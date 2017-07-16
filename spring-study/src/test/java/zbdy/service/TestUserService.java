package zbdy.service;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import zbdy.domain.User;

@Configuration
@ComponentScan(basePackages = "zbdy")
public class TestUserService {
	
	
	@Test
	public void testCreateUser() {
		ApplicationContext context = new AnnotationConfigApplicationContext(TestUserService.class);
		UserService userService = context.getBean(UserService.class);
		userService.createUser(new User());
	}

}
