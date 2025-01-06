package com.spring.taskschedule.service;


import com.spring.taskschedule.dto.UserResponseDto;
import com.spring.taskschedule.entity.User;
import com.spring.taskschedule.exception.IdAndPasswordMismatchException;
import com.spring.taskschedule.exception.IdNotFoundException;
import com.spring.taskschedule.exception.PasswordMismatchException;
import com.spring.taskschedule.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
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
            throw new IdNotFoundException("아이디를 확인해주세요");
        }

        User findUser = optionalUser.get();

        return UserResponseDto.toDto(findUser);

    }

    public UserResponseDto updateUser(Long id, String username, String eMail, String password){

        User findUser = userRepository.findByIdOrElseThrow(id);

        if(!findUser.getPassword().equals(password)){
            throw new PasswordMismatchException("비밀번호가 일치하지 않습니다");
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
            throw new IdNotFoundException("아이디를 확인해주세요");
        }

        userRepository.delete(findUser);

    }

//    public UserResponseDto login(String username, String password){
//
//
//        Optional<User> optionalUser = userRepository.findIdByUsernameAndPassword(username, password);
//
//        if (optionalUser.isEmpty()){
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist username and password");
//        }
//        User findUser = optionalUser.get();
//
//        return UserResponseDto.toDto(findUser);
//    }


    public UserResponseDto login(String eMail, String password){


    Optional<User> optionalUser = userRepository.findUserByEMailAndPassword(eMail, password);

    if (optionalUser.isEmpty()){
        throw new IdAndPasswordMismatchException("아이디 또는 패스워드를 확인하세요");
    }
    User findUser = optionalUser.get();

    return UserResponseDto.toDto(findUser);
}

    //서버 설정(애플리케이션파일)server.error.include-stacktrace=never


    //익셉션핸들러(오류났을때 반환값을 마음대로 컨트롤할 수 있음)(공부좀해야됨)
    //예외발생을 잡아서 응답값을 재정의 할 수 있음
    //적용되는 범위가 있음

}





