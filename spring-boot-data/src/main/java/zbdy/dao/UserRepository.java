package zbdy.dao;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import zbdy.model.User;

//public interface UserRepository extends CrudRepository<User, Integer>{
//PagingAndSortingRepository extends CrudRepository
public interface UserRepository extends PagingAndSortingRepository<User, Integer> {

	List<User> findByUsername(String username);

	// derivation method, such as countByXXX, deleteByXXX, removeByXXX
	// long deleteByLastname(String lastname);
	// List<User> removeByLastname(String lastname);
	//Refer to Spring JPA Doc 2.4.2. Query Creation
	long countByUsername(String username);
}
