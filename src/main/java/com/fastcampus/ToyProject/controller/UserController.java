package com.fastcampus.ToyProject.controller;

import com.fastcampus.ToyProject.domain.User;
import com.fastcampus.ToyProject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/auth/insertUser")
    public String insertUserView() {
        return "user/insertUser";
    }

    @PostMapping("/auth/insertUser")
    @ResponseBody
    public String insertUser(@RequestBody User user) {
        //username으로 검증
        User findUser = userService.getUser(user.getUsername());

        if (findUser.getUsername() == null) {
            userService.insertUser(user);
            return user.getUsername() + " 회원 가입 성공";
        } else {
            return findUser.getUsername() + " -> 이미 등록된 회원입니다.";
        }
    }

    @GetMapping("/auth/login")
    public String loginView() {
        return "system/login";
    }
}
