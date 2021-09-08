package com.rukon.repository;

import com.rukon.dto.ProductDto;
import com.rukon.dto.UserDto;
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


    @Query("SELECT new com.rukon.dto.UserDto(userName, roles, active) FROM User where userName=:userName")
    UserDto findAUser(String userName);




}
