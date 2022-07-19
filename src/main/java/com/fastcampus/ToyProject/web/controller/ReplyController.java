package com.fastcampus.ToyProject.web.controller;

import com.fastcampus.ToyProject.domain.Reply;
import com.fastcampus.ToyProject.security.jpa.UserDetailsImpl;
import com.fastcampus.ToyProject.service.PostService;
import com.fastcampus.ToyProject.service.ReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/post/reply")
public class ReplyController {

    private final ReplyService replyService;
    private final PostService postService;

    @PostMapping("/insertReply")
    public String insertReply(@RequestBody ReplyDto replyDto,
                              @AuthenticationPrincipal UserDetailsImpl user) {

        Reply reply = Reply.builder()
                .comment(replyDto.getComment())
                .post(postService.getPost(replyDto.getPostId()))
                .writer(user.getUsername())
                .build();
        replyService.insertReply(reply);

        return "덧글 등록이 완료됐습니다.";
    }

    @DeleteMapping
    public String deleteReply(@RequestBody ReplyDto replyDto) {
        replyService.deleteReply(replyDto.getReplyId());
        return "덧글 삭제가 완료됐습니다";
    }
}
