package zbdy.service;


import java.sql.SQLException;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;

import zbdy.model.User;

@Configuration
@ImportResource("classpath:/datasource-config.xml")
@EnableAspectJAutoProxy	//equivalent to <aop:aspectj-autoproxy/>
@ComponentScan(basePackages = "zbdy")
public class TestUserService {
	

	@Test
	public void testCreateUser() throws SQLException {
		ApplicationContext context = new AnnotationConfigApplicationContext(TestUserService.class);
		UserService userService = context.getBean(UserService.class);
		userService.createUser(new User("4567", "abcd"));
	}
	
    public static void main( String[] args )
    {
		ApplicationContext context = new AnnotationConfigApplicationContext(TestUserService.class);
		UserService userService = context.getBean(UserService.class);
			userService.createUser(new User("1113", "abcd"));
    }

}
