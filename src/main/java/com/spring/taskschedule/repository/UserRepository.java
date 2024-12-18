package com.spring.taskschedule.repository;

import com.spring.taskschedule.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    default User findByIdOrElseThrow(Long id){
        return findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist id =" + id));
    }



    Optional<User> findIdByUsernameAndPassword(String username, String password);

    default User findUserByUsernameOrElseThrow(String username, String password){
        return findIdByUsernameAndPassword(username, password).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist username and password= "+username +"/"+password));
    }






}
