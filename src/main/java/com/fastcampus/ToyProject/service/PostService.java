package com.fastcampus.ToyProject.service;

import com.fastcampus.ToyProject.domain.Post;
import com.fastcampus.ToyProject.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostService {

    private final PostRepository postRepository;

    @Transactional
    public void insertPost(Post post) {
        postRepository.save(post);
    }

    @Transactional
    public void updatePost(Post post) {
        Post updatedPost = postRepository.findById(post.getId()).orElseThrow();
        updatedPost.setTitle(post.getTitle());
        updatedPost.setContent(post.getContent());
    }

    @Transactional
    public void deletePost(int id) {
        postRepository.deleteById(id);
    }

    public Post getPost(int id) {
        return postRepository.findById(id).orElse(new Post());
    }

    public Page<Post> getPostList(Pageable pageable) {
        return postRepository.findAll(pageable);
    }
}