package zbdy.springjms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class QueueSender {
	
	@Autowired
	private JmsTemplate jmsQueueTemplate;
	
	@Autowired
	private JmsTemplate jmsTopicTemplate;
	
	public void sendMsgToDefaultDestination(Object message){
		jmsQueueTemplate.convertAndSend(message);
	}
	
	public void sendMessage(Object message){
		jmsQueueTemplate.convertAndSend("test.queue", message);
	}
	
	public void sendTopicMessage(Object message){
		jmsTopicTemplate.convertAndSend("test.queue", message);
	} 
}
