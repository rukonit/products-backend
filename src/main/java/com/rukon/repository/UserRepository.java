package com.rukon.repository;

import com.rukon.dto.ProductDto;
import com.rukon.dto.UserDto;
import com.rukon.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUserName(String userName);

//    @Query("SELECT new com.rukon.UserDto(user_name, roles, active) from user")
//    UserDto findU();

    @Query("SELECT new com.rukon.dto.UserDto(user_name, roles, active) FROM user")
    Set<ProductDto> findAllProduct();



}
