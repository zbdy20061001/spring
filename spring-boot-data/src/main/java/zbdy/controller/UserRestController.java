package zbdy.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
        return this.user;
    }
	@GetMapping("user/id/{id}") //use URL path
	public Optional<User> getUserById(@PathVariable int id) {
		System.out.println("------------restful----------");
		return userRepository.findById(id);
	}
	@GetMapping("users")
    public List<User> getUsers() {
		System.out.println("------------restful----------");
        return (List<User>) userRepository.findAll();
    }
	@GetMapping("users/username/{username}")
    public List<User> getUsersByUsername(@PathVariable String username) {
		System.out.println("------------restful----------");
        return (List<User>) userRepository.findByUsername(username);
    }
	@GetMapping("user/update/id/{id}")
	public Optional<User> updateUserById(@PathVariable int id) {
		System.out.println("------------restful----------");
		User user = new User("zbdy","abcd");
		user.setId(id);
		userRepository.save(user);
		return userRepository.findById(id); 
	}
	
	//paging
	@GetMapping("users/page/{start}/{end}")
    public List<User> getUsersOnPaging(@PathVariable int start, @PathVariable int end) {
		System.out.println("------------restful----------");
        return userRepository.findAll(new PageRequest(start, end)).getContent();
    }
	
	@GetMapping("users/count/{username}")
	public long countUserByUsername(@PathVariable String username){
		return userRepository.countByUsername(username);
	}
}
