package zbdy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import zbdy.dao.impl.DataSource;
import zbdy.domain.User;
import zbdy.service.UserService;

/**
 * Hello world!
 *
 */
@Configuration
@ComponentScan
@EnableAspectJAutoProxy	//equivalent to <aop:aspectj-autoproxy/>
public class App 
{
//	@Bean
//	DataSource produceDataSource(){
//		return new DataSource();
//	}
	
    public static void main( String[] args )
    {
    	@SuppressWarnings("resource")
		ApplicationContext context = new AnnotationConfigApplicationContext(App.class);
    	    	
    	UserService userService = context.getBean(UserService.class);
    	userService.createUser(new User("abcd", "111"));
    	

    }
}
