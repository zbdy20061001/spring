import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

import zbdy.service.PublishService;

@SpringBootApplication(scanBasePackages="zbdy")
@ImportResource("classpath:/context.xml")
public class Application {

    public static void main(String[] args) {
    	
    	ConfigurableApplicationContext applicationContext = SpringApplication.run(Application.class, args);
        
    	PublishService publishService = applicationContext.getBean(PublishService.class);
 
    	publishService.send( "Spring Integration!" );
    }

}