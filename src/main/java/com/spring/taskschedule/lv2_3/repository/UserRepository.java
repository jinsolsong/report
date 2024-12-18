package com.spring.taskschedule.lv2_3.repository;

import com.spring.taskschedule.lv2_3.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public interface UserRepository extends JpaRepository<User, Long> {

    default User findByIdOrElseThrow(Long id){
        return findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist id =" + id));
    }

//    Optional<User> findUserByUsername(String username);
//
//    default User findUserByUsernameOrElseThrow(String username){
//        return findUserByUsername(username).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist username = "+username));
//    }
//
}
