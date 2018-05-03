package zbdy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import zbdy.dao.UserRepository;
import zbdy.model.User;

@RestController
@RequestMapping("/")
public class UserRestController {
	
	private User user = new User("zbdy", "1111");
	
	@Autowired
	//自动从spring容器中加载userRepository
    private UserRepository userRepository;
	
	
	@GetMapping("user")
    public User getUser() {
		System.out.println("------------restful----------");
		userRepository.save(user);
        return this.user;
    }
	
}
