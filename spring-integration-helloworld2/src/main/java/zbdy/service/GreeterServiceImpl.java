package zbdy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GreeterServiceImpl implements GreeterService
{
	@Autowired
    private HelloService helloWorldGateway;
 
    @Override
    public void greet(String name)
    {
    	System.out.println( helloWorldGateway.getHelloMessage( name ) );
    }
}