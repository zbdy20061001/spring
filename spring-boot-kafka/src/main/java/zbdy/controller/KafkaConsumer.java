package zbdy.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

@Configuration
public class KafkaConsumer {
	@KafkaListener(topics = "test")
	public void consume(String msg) {
		System.out.println("received msg: "+msg);
	}
}
