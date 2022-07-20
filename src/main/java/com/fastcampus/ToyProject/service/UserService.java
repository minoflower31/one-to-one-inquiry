package com.fastcampus.ToyProject.service;

import com.fastcampus.ToyProject.domain.User;
import com.fastcampus.ToyProject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public void insertUser(User user) {
        user.addRole("USER");
        userRepository.save(user);
    }

    public User getUser(String username) {
        Optional<User> findUser = userRepository.findByUsername(username);
        return findUser.orElseGet(User::new);
    }
}
