package com.fastcampus.ToyProject.domain;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "POST_ID")
    private int id;

    @Column(nullable = false, length = 100)
    private String title;

    @Lob // 아주 긴 문자 데이터(GB)를 저장할 수 있는 설정
    @Column(nullable = false)
    private String content;

    @CreationTimestamp
    private Timestamp timestamp;

    //포스트: 회원 -> N : 1
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private User user;

    //포스트: 댓글 -> 1 : N
    @OneToMany(mappedBy = "post", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Reply> replyList = new ArrayList<>();
}
