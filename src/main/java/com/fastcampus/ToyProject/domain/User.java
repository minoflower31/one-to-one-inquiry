package com.fastcampus.ToyProject.domain;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "USERS")
public @Data class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private int id; // 회원 일련번호

    @Column(nullable = false, length = 50, unique = true)
    private String username; // 아이디
    private String password; // 비밀번호
    private String email; // 이메일

    private String role;

    @CreationTimestamp
    private Timestamp timestamp;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Post> posts = new ArrayList<>();
}
