package com.test.type.controller;

import com.test.type.dto.UserDTO;
import com.test.type.entity.UserEntity;
import com.test.type.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;


    public ResponseEntity<UserEntity> createUser(@RequestBody UserDTO userDTO){
        UserEntity createdUser = userService.createUser(userDTO);
        return ResponseEntity.ok(createdUser);
    }
}
