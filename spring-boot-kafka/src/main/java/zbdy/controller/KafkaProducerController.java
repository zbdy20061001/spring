package zbdy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class KafkaProducerController {

	@Autowired
	KafkaTemplate<String, String> kafka;
	
	@GetMapping("kafka")
	public String send() {
		System.out.println("------------kafka----------");
		kafka.send("test", "msg from springboot");
		return "Kafka sent";
	}

}
