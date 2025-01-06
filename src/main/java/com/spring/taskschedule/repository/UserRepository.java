package com.spring.taskschedule.repository;

import com.spring.taskschedule.entity.User;
import com.spring.taskschedule.exception.IdNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    default User findByIdOrElseThrow(Long id){
        return findById(id).orElseThrow(()->new IdNotFoundException("아이디를 확인해주세요"));
    }


//    Optional<User> findIdByUsernameAndPassword(String username, String password);
//
//    default User findUserByUsernameOrElseThrow(String username, String password){
//        return findIdByUsernameAndPassword(username, password).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist username and password= "+username +"/"+password));
//    }

    Optional<User> findUserByEMailAndPassword(String eMail, String password);

//    default User findUserByEmailOrElseThrow(String eMail, String password){
//        return findUserByEMailAndPassword(eMail, password).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist email and password = "+ eMail + password));
//    }





}
