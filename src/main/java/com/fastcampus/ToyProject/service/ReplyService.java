package com.fastcampus.ToyProject.service;

import com.fastcampus.ToyProject.domain.Reply;
import com.fastcampus.ToyProject.repository.ReplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
