package zbdy.controller;

import java.util.HashMap;
import java.util.Map;

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

import zbdy.model.User;

@RestController
@RequestMapping("/user")
public class UserRestController {

	private User user = new User("zbdy", "1111");

	@GetMapping()
	public User getUser() {
		System.out.println("------------restful----------");
		return this.user;
	}

	private static Map<String, User> userRepo = new HashMap<>();
	static {
		User user1 = new User("zbdy", "1111");
		User user2 = new User("abcd", "1234");
		
		userRepo.put(user1.getUsername(), user1);
		userRepo.put(user2.getUsername(), user2);
	}

//	@GetMapping()
//	public ResponseEntity<Object> getUsers(){
//		return new ResponseEntity<>(userRepo.values(), HttpStatus.OK);
//	}
	
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
		userRepo.remove(username);
		return new ResponseEntity<>("User is deleted successfully", HttpStatus.OK);
	}
}
