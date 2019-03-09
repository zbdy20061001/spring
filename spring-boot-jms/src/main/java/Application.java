import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;

import zbdy.springjms.QueueSender;


@SpringBootApplication(scanBasePackages="zbdy")
@ImportResource("classpath:/beans.xml")
public class Application {

    public static void main(String[] args) {
    	ApplicationContext context = SpringApplication.run(Application.class, args);
        QueueSender sender = context.getBean(QueueSender.class);
        sender.sendMessage("hello");        
    }
}