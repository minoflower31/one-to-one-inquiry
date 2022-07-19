package com.fastcampus.ToyProject.web.controller;

import lombok.Data;

@Data
public class ReplyDto {

    private int postId;
    private int replyId;
    private String comment;
}
