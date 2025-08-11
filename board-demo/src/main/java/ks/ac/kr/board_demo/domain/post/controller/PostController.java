package ks.ac.kr.board_demo.domain.post.controller;
import ks.ac.kr.board_demo.domain.post.dto.AllPostResponse;
import ks.ac.kr.board_demo.domain.post.dto.PostRequest;
import ks.ac.kr.board_demo.domain.post.dto.PostResponse;
import ks.ac.kr.board_demo.domain.post.model.Post;
import ks.ac.kr.board_demo.domain.post.service.PostService;
import ks.ac.kr.board_demo.global.response.BoardResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
@AllArgsConstructor

public class PostController {

    PostService postService;

    @PostMapping("/write")
    public BoardResponse createPost(
            @RequestHeader("Authorization") String username,
            @RequestBody PostRequest req
    ){
        Long generatedId = postService.createPost(username, req.title(), req.content());
        return BoardResponse.of(PostSuccessCode.GENERATED_POST, generatedId);
    }
    @GetMapping("/{id}")
    public BoardResponse<PostResponse> getPostById(
            @PathVariable Long id
    ) {
        PostResponse post = postService.getPost(id);
        return BoardResponse.of(PostSuccessCode.OK_GET_POST, post);
    }

    @GetMapping("/")
    public BoardResponse<List<AllPostResponse>> getAllPosts() {
        List<AllPostResponse> posts = postService.getAllPosts();
        return BoardResponse.of(PostSuccessCode.OK_GET_ALL_POSTS, posts);
    }

}
