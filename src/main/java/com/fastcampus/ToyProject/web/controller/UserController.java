package com.fastcampus.ToyProject.web.controller;

import com.fastcampus.ToyProject.domain.User;
import com.fastcampus.ToyProject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/auth/sign-up")
    public String insertUserView(Model model) {
        model.addAttribute("user", new User());
        return "user/sign-up";
    }

    @PostMapping("/auth/sign-up")
    @ResponseBody
    public String insertUser(@RequestBody User user) {
        User findUser = userService.getUser(user.getUsername());

        if (findUser.getUsername() == null) {
            userService.insertUser(user);
            return user.getUsername() + " 회원 가입 성공";
        } else {
            return findUser.getUsername() + " -> 이미 등록된 회원입니다.";
        }
    }

    @GetMapping("/auth/login")
    public String loginView(Model model) {
        model.addAttribute("user", new User());
        return "system/login";
    }
}
