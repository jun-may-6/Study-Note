package com.ohgiraffers.restapi.section03.valid;


import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;


/* 익셉션 관리
* 1. 익셉션 정의
* 2. 익셉션 상속
* 3. 메세지 정의
* 4. throw
* */
@RestController
@RequestMapping("/valid")
public class ValidTestController {
    @GetMapping("/users/{userId}")
    public ResponseEntity<Void> findUserByNo() throws UserNotFoundException {
        boolean check = true;
        if(check){
            throw new UserNotFoundException("회원 정보를 찾을 수 없습니다.");
        }
        return ResponseEntity.ok().build();
    }

    @PostMapping("/users")
    public ResponseEntity<Void> registUser(@Valid @RequestBody UserDTO user){
        return ResponseEntity
                .created(URI.create("/valid/users/1"))
                .build();
    }
}
