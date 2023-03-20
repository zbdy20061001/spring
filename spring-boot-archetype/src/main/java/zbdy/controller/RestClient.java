package zbdy.controller;

import org.springframework.web.client.RestTemplate;

import zbdy.model.User;

public class RestClient {

	public static final String REST_SERVICE_URI = "http://localhost/users/";

	public static RestTemplate restTemplate = new RestTemplate();

	// get
	private static void getAllUsers() {
		User[] users = restTemplate.getForObject(REST_SERVICE_URI, User[].class);
		for (User user : users) {
			System.out.println(user);
		}
	}

	// get
	private static void getUser(String username) {
		User user = restTemplate.getForObject(REST_SERVICE_URI + username, User.class);
		System.out.println(user);
	}

	// post
	private static void createUser(User user) {
		restTemplate.postForLocation(REST_SERVICE_URI, user, User.class);
	}

	// put
	private static void updateUser(User user) {
		restTemplate.put(REST_SERVICE_URI + user.getUsername(), new User("qwer", "1111"));
	}

	// delete
	private static void deleteUser(String username) {
		restTemplate.delete(REST_SERVICE_URI + username);
	}

	public static void main(String[] args) {
		getUser("zbdy");
		getAllUsers();
		createUser(new User("qwer", "1234"));
		getAllUsers();
		updateUser(new User("qwer", "1111"));
		getAllUsers();
		deleteUser("qwer");
		getAllUsers();
	}
}
