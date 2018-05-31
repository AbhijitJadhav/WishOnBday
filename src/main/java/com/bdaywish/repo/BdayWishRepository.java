package com.bdaywish.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.bdaywish.pojo.User;

@Repository
public interface BdayWishRepository extends JpaRepository<User, Integer>{

	@Query(value="select * from users where date_of_birth=?1",nativeQuery=true)
	List<User> findUsersByTime(Long time);

	@Query(value="select * from users",nativeQuery=true)
	List<User> findAllUsers();
	
	@Query(value="select * from users where emp_id=?",nativeQuery=true)
	User findUserByEmpId(Integer id);

}
