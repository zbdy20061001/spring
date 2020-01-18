import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication(scanBasePackages = "zbdy")
@ImportResource("classpath:/delay.xml")
public class Application2 {

	public static void main(String[] args) throws InterruptedException {

		SpringApplication.run(Application2.class, args);

	}
}