package zbdy.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import zbdy.exception.UserNotfoundException;
import zbdy.model.User;


//https://www.yiibai.com/spring-boot/spring_boot_building_restful_web_services.html
//https://www.yiibai.com/spring_mvc/spring-mvc-4-restful-web-services-crud-example-resttemplate.html

@RestController
@RequestMapping("/users")
public class UserRestController {

	private static Logger logger = LoggerFactory.getLogger(UserRestController.class);

	private static Map<String, User> userRepo = new HashMap<>();
	static {
		User user1 = new User("zbdy", "1111");
		User user2 = new User("abcd", "1234");
		
		userRepo.put(user1.getUsername(), user1);
		userRepo.put(user2.getUsername(), user2);
	}

	@GetMapping()
	public ResponseEntity<Object> getAllUsers(){
		return new ResponseEntity<>(userRepo.values(), HttpStatus.OK);
	}
	@GetMapping("/{username}")
	public ResponseEntity<Object> getUser(@PathVariable("username") String username){
		if(!userRepo.containsKey(username)) {
			throw new UserNotfoundException();
		}
		return new ResponseEntity<>(userRepo.get(username), HttpStatus.OK);
	}
	
	@PostMapping()
	public ResponseEntity<Object> createUser(@RequestBody User user){
		userRepo.put(user.getUsername(), user);
		return new ResponseEntity<>("User is created successfully", HttpStatus.CREATED);
	}
	@PutMapping("/{username}")
	public ResponseEntity<Object> updateUser(@PathVariable("username") String username, @RequestBody User user){
		userRepo.remove(username);
		userRepo.put(username, user);
		return new ResponseEntity<>("User is updated successfully", HttpStatus.OK);
	}
	@DeleteMapping("/{username}")
	public ResponseEntity<Object> deleteUser(@PathVariable("username") String username){
		if(!userRepo.containsKey(username)) {
			throw new UserNotfoundException();
		}
		userRepo.remove(username);
		return new ResponseEntity<>("User is deleted successfully", HttpStatus.OK);
	}
}
  