package zbdy.model;


//@XmlRootElement
public class User {
	private String username;
	private String password;

	public User() {
	};

	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

//	@XmlElement
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

//	@XmlElement
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
