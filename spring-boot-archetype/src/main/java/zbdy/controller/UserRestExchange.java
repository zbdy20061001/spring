package zbdy.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import zbdy.model.User;

//https://www.yiibai.com/spring-boot/spring_boot_rest_template.html

@RestController
@RequestMapping("/template/users")
public class UserRestExchange {

	@Autowired
	RestTemplate restTemplate;

	@GetMapping()
	public String getUsers() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);

		return restTemplate.exchange("http://localhost:8080/users", HttpMethod.GET, entity, String.class).getBody();
	}

	@PostMapping()
	public String createUsers(@RequestBody User user) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<User> entity = new HttpEntity<User>(user, headers);

		return restTemplate.exchange("http://localhost:8080/users", HttpMethod.POST, entity, String.class).getBody();
	}

	@PutMapping("/{username}")
	public String updateUser(@PathVariable("username") String username, @RequestBody User user) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<User> entity = new HttpEntity<User>(user, headers);

		return restTemplate.exchange("http://localhost:8080/users/"+username, HttpMethod.PUT, entity, String.class).getBody();
	}

	@DeleteMapping("/{username}")
	public String deleteUser(@PathVariable("username") String username) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<User> entity = new HttpEntity<User>(headers);

		return restTemplate.exchange("http://localhost:8080/users/"+username, HttpMethod.DELETE, entity, String.class).getBody();
	}
}
