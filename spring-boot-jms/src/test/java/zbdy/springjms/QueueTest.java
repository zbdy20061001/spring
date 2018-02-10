package zbdy.springjms;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jms.core.JmsTemplate;

@Configuration
@ImportResource("classpath:/beans.xml")
@ComponentScan(basePackages = "zbdy")
public class QueueTest {
	

	@Test
	public void testSendMessage() {
		@SuppressWarnings("resource")
		ApplicationContext context = new AnnotationConfigApplicationContext(QueueTest.class);
		JmsTemplate jmsTemplate  = (JmsTemplate)context.getBean("jmsQueueTemplate");
		jmsTemplate.convertAndSend("hello!");
		jmsTemplate.convertAndSend("test.queue", "hello!");

	}
	
	@Test
	public void testReceiveMessage() {
		@SuppressWarnings("resource")
		ApplicationContext context = new AnnotationConfigApplicationContext(QueueTest.class);
		JmsTemplate jmsTemplate  = (JmsTemplate)context.getBean("jmsQueueTemplate");
		System.out.println(jmsTemplate.receiveAndConvert("HelloWorld"));
		
	}

}
