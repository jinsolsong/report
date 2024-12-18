package com.spring.taskschedule.lv2_3.controller;

import com.spring.taskschedule.lv2_3.dto.UserRequestDto;
import com.spring.taskschedule.lv2_3.dto.UserResponseDto;
import com.spring.taskschedule.lv2_3.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<UserResponseDto> signUp (@RequestBody UserRequestDto dto){
        UserResponseDto userResponseDto =
                userService.signUp(
                        dto.getUsername(),
                        dto.getEMail(),
                        dto.getPassword()
                );
        return new ResponseEntity<>(userResponseDto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDto>> findAllUsers(){
        List<UserResponseDto> responseDtoList = userService.findAllUsers();
        return new ResponseEntity<>(responseDtoList, HttpStatus.OK);
    }



    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> findById (@PathVariable Long id){

        UserResponseDto userResponseDto = userService.findById(id);

        return new ResponseEntity<>(userResponseDto, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<UserResponseDto> updateUser(
            @PathVariable Long id,
            @RequestBody UserRequestDto dto
    ){
        UserResponseDto updateUser = userService.updateUser(id, dto.getUsername(), dto.getEMail(), dto.getPassword());

        return new ResponseEntity<>(updateUser, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){

        userService.deleteUser(id);

        return new ResponseEntity<>(HttpStatus.OK);

    }


}
