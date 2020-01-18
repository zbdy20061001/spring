import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.PollableChannel;
import org.springframework.messaging.support.GenericMessage;

@SpringBootApplication(scanBasePackages = "zbdy")
@ImportResource("classpath:/context.xml")
public class Application {

	public static void main(String[] args) throws InterruptedException {

		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		MessageChannel inputChannel = context.getBean("inputChannel", MessageChannel.class);
		PollableChannel outputChannel = context.getBean("outputChannel", PollableChannel.class);
		for (int i = 0; i < 10; i++) {
			inputChannel.send(new GenericMessage<String>("World" + i));
			
		}
		
		System.out.println("==> HelloWorldDemo: " + outputChannel.receive(0).getPayload());
	}
}