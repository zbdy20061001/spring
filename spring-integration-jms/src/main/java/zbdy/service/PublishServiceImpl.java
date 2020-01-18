 package zbdy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Service;

@Service
public class PublishServiceImpl implements PublishService
{
    
    @Autowired
    private MessageChannel topicChannel;
 
    @Override
    public void send( String message )
    {
    	System.out.println( "Sending message to message channel: " + message );
        topicChannel.send( MessageBuilder.withPayload( message ).build() );
    }
}