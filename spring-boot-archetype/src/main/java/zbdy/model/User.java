package zbdy.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + "]";
	}

	private String username;
	private String password;

	public User() {
	};

	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	@XmlElement
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@XmlElement
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
