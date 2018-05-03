package zbdy.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//@XmlRootElement
@Entity
@Table(name = "USER_INFO")
public class User implements Serializable  {
	

	private static final long serialVersionUID = -3802081968056612376L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(nullable = false, name="USERNAME")
	private String username;
	@Column(nullable = false, name="PASSWORD")
	private String password;
	
	public User(){};
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
