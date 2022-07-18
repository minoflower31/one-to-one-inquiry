package com.fastcampus.ToyProject.persistence;

import com.fastcampus.ToyProject.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

    void deleteById(int id);

}
