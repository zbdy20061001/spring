package zbdy.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import zbdy.model.User;

@RestController
@RequestMapping("/rest")
public class UserRestController {
	
	private User user = new User("zbdy", "1111");
	
	@GetMapping
    public User getUser() {
		System.out.println("------------restful----------");
        return this.user;
    }
	
}
