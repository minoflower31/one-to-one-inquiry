package com.fastcampus.ToyProject.persistence;

import com.fastcampus.ToyProject.domain.Reply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReplyRepository extends JpaRepository<Reply, Integer> {

    List<Reply> findAllByPostId(int postId);

    void deleteById(int id);
}
