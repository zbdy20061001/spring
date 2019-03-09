package zbdy.springjms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import zbdy.model.Email;

@Component
public class Receiver {

    @JmsListener(destination = "test.queue", containerFactory = "myFactory")
    public void receiveMessage(Email email) {
        System.out.println("Received <" + email + ">");
    }

}