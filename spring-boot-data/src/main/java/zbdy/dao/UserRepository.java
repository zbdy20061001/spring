package zbdy.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import zbdy.model.User;

public interface UserRepository extends CrudRepository<User, Integer>{
	List<User> findByUsername(String username);
}
