package zbdy.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import zbdy.dao.UserDao;
import zbdy.domain.User;

@Repository
public class UserDaoImpl implements UserDao {
	
	private DataSource dataSource;
	
	@Autowired
	public void setDatasource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void addUser(User user) {
		System.out.println("-------Implemented by UserDaoImp addUser()----------");
		System.out.println(this.dataSource);
		System.out.println("-----username:" + user.getUsername() + "------");
	}

}
