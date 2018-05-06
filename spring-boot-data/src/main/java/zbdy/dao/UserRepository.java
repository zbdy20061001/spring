package zbdy.dao;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import zbdy.model.User;

//public interface UserRepository extends CrudRepository<User, Integer>{
//PagingAndSortingRepository extends CrudRepository
public interface UserRepository extends PagingAndSortingRepository<User, Integer>{

	List<User> findByUsername(String username);
	
	long countByUsername(String username);
}
