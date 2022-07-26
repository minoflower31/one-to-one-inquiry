package com.fastcampus.ToyProject.web.controller;

import com.fastcampus.ToyProject.domain.Post;
import com.fastcampus.ToyProject.security.jpa.UserDetailsImpl;
import com.fastcampus.ToyProject.service.PostService;
import com.fastcampus.ToyProject.service.ReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

import static org.springframework.data.domain.Sort.Direction.DESC;

@Controller
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @ExceptionHandler(value = NoSuchElementException.class)
    public String noSuchPostHandle() {
        return "error/no-such-post";
    }

    @GetMapping("/")
    public String getPostList(Model model,
                              @PageableDefault(size = 3, sort = "id", direction = DESC) Pageable pageable) {
        Page<Post> postList = postService.getPostList(pageable);
        model.addAttribute("postList", postList);
        return "welcome";
    }

    @GetMapping("/post/{id}")
    public String getPost(@PathVariable int id, Model model, @AuthenticationPrincipal UserDetailsImpl user) {
        Post post = postService.getPost(id);
        //post 삭제가 됐는데 브라우저 내 뒤로 가기 버튼으로 돌아갈 경우, 게시글 목록으로 redirect.
        if(post.getId() == 0) {
            return "redirect:/";
        }

        model.addAttribute("post",post);
        model.addAttribute("user", user.getUser());
        model.addAttribute("replyList", post.getReplyList());
        return "post/get-post";
    }

    @GetMapping("/post/insert-post")
    public String insertPostView(Model model) {
        model.addAttribute("post", new Post());
        return "post/insert-post";
    }

    @PostMapping("/post/insert-post")
    @ResponseBody
    public String insertPost(@RequestBody Post post, @AuthenticationPrincipal UserDetailsImpl user) {
        post.addUser(user.getUser());
        postService.insertPost(post);

        return "새로운 1:1 문의가 등록됐습니다.";
    }

    @GetMapping("/post/{id}/update-post")
    public String updatePostView(@PathVariable int id, Model model) {
        model.addAttribute("post", postService.getPost(id));
        return "post/update-post";
    }

    @PutMapping("/post/{id}")
    @ResponseBody
    public String updatePost(@PathVariable int id, @RequestBody Post post) {
        postService.updatePost(id, post);
        return "1:1 문의가 수정됐습니다.";
    }

    @DeleteMapping("/post/{id}")
    @ResponseBody
    public String deletePost(@PathVariable int id) {
        postService.deletePost(id);
        return "1:1 문의가 삭제됐습니다.";
    }
}