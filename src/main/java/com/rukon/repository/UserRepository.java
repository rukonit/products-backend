package com.rukon.repository;

import com.rukon.dto.ProductDto;
import com.rukon.dto.UserDto;
import com.rukon.dto.UserDto2;
import com.rukon.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Set;

@Repository

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUserName(String userName);


//    @Query("SELECT distinct new com.rukon.dto.UserDto(userName, roles, active, cart) FROM User u JOIN FETCH u.cart ")
//    UserDt o findAUser(String userName);




}
