package zbdy.service;

import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService
{

	@Override
	public String getHelloMessage(String name) {
		return "Hello, " + name ;
	}
}