package zbdy.service;

import org.springframework.stereotype.Service;

@Service
public class MessageListenerImpl
{
 
    public void processMessage( String message )
    {
        System.out.println( "MessageListener::::::Received message: " + message );
    }
    
//    public void processMessage( Message message )
//    {
//        System.out.println( "MessageListener::::::Received message: " + message );
//    }
}