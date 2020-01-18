import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

import zbdy.service.GreeterService;

@SpringBootApplication(scanBasePackages="zbdy")
@ImportResource("classpath:/context.xml")
public class Application {

    public static void main(String[] args) {
    	
    	ConfigurableApplicationContext applicationContext = SpringApplication.run(Application.class, args);
        
        GreeterService greeterService = applicationContext.getBean(GreeterService.class);
 
        greeterService.greet( "Spring Integration!" );
    }

}