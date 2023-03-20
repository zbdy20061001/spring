package zbdy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
//@EnableScheduling
//@EnableEurekaClient
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	// Since RestTemplate instances often need to be customized before being used,
	// Spring Boot does not provide any single auto-configured RestTemplate bean. It
	// does, however, auto-configure a RestTemplateBuilder, which can be used to
	// create RestTemplate instances when needed.
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

}
