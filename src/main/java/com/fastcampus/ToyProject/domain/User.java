package com.fastcampus.ToyProject.domain;

import lombok.Data;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "USERS")
@Getter
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private int id;

    @Column(nullable = false, length = 50, unique = true)
    private String username;

    @Column(nullable = false, length = 50)
    private String password;
    private String email;

    private String role;

    @CreationTimestamp
    private Timestamp timestamp;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Post> posts = new ArrayList<>();

    //비즈니스 메서드
    public void addRole(String role) {
        this.role = role;
    }
}
