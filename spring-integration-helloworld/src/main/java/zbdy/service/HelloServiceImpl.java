package zbdy.service;

import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService
{
    @Override
    public void hello(String name)
    {
        System.out.println( "Hello, " + name );
    }
}