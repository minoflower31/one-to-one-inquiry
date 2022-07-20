package com.fastcampus.ToyProject.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Reply {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "REPLY_ID")
    private int id;

    @Column(nullable = false)
    private String comment;
    private String writer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "POST_ID")
    private Post post;

    @Builder
    public Reply(String comment, String writer, Post post) {
        this.comment = comment;
        this.writer = writer;
        this.post = post;
    }
}
