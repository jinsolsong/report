package com.spring.taskschedule.service;


import com.spring.taskschedule.dto.UserResponseDto;
import com.spring.taskschedule.entity.User;
import com.spring.taskschedule.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserResponseDto signUp(String username, String eMail, String password) {

        User user = new User(username, eMail, password);

        User saveUser = userRepository.save(user);

        return UserResponseDto.toDto(saveUser);
    }

    public List<UserResponseDto> findAllUsers(){
        return userRepository.findAll()
                .stream()
                .map(UserResponseDto::toDto)
                .toList();
    }

    public UserResponseDto findById(Long id){

        Optional<User> optionalUser = userRepository.findById(id);

        if (optionalUser.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist id = " + id);
        }

        User findUser = optionalUser.get();

        return UserResponseDto.toDto(findUser);

    }

    public UserResponseDto updateUser(Long id, String username, String eMail, String password){

        User findUser = userRepository.findByIdOrElseThrow(id);

        if(!findUser.getPassword().equals(password)){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "비밀번호가 일치하지 않습니다. ");
        }

        findUser.setUsername(username);
        findUser.setEMail(eMail);
        findUser.setPassword(password);

        User updateUser = userRepository.save(findUser);

        return UserResponseDto.toDto(updateUser);

    }

    public void deleteUser(Long id){

        User findUser = userRepository.findById(id).orElse(null);

        if(findUser == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        userRepository.delete(findUser);

    }

    public UserResponseDto login(String username, String password){


        Optional<User> optionalUser = userRepository.findIdByUsernameAndPassword(username, password);

        if (optionalUser.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "아이디 또는 비밀번호를 확인하세요");
        }
        User findUser = optionalUser.get();

        return UserResponseDto.toDto(findUser);
    }


}





