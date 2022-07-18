package com.fastcampus.ToyProject.service;

import com.fastcampus.ToyProject.domain.Reply;
import com.fastcampus.ToyProject.persistence.ReplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ReplyService {

    private final ReplyRepository replyRepository;

    @Transactional
    public void insertReply(Reply reply) {
        replyRepository.save(reply);
    }

    @Transactional
    public void deleteReply(int id) { replyRepository.deleteById(id);}

    public List<Reply> getReplyList(int postId) {
        return replyRepository.findAllByPostId(postId);
    }
}
