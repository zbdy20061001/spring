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
public class TestUserServiceAnnotation {
	

	@Test
	public void testCreateUser() throws SQLException {
		@SuppressWarnings("resource")
		ApplicationContext context = new AnnotationConfigApplicationContext(TestUserServiceAnnotation.class);
		UserService userService = context.getBean(UserService.class);
		userService.createUser(new User("4567", "abcd"));
	}
	
    public static void main( String[] args )
    {
		@SuppressWarnings("resource")
		ApplicationContext context = new AnnotationConfigApplicationContext(TestUserServiceAnnotation.class);
		UserService userService = context.getBean(UserService.class);
		userService.createUser(new User("6767", "abcd"));
    }

}
