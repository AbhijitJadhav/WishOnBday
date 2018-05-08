package com.bdaywish.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bdaywish.pojo.User;

@Repository
public interface BdayWishRepository extends JpaRepository<User, Integer>{

}
