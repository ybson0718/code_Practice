package ks.ac.kr.board_demo.domain.post.service;


import ks.ac.kr.board_demo.domain.comment.dto.CommentResponse;
import ks.ac.kr.board_demo.domain.comment.model.Comment;
import ks.ac.kr.board_demo.domain.comment.service.CommentService;
import ks.ac.kr.board_demo.domain.member.model.Member;
import ks.ac.kr.board_demo.domain.member.repository.MemberRepository;
import ks.ac.kr.board_demo.domain.post.controller.PostExceptionCode;
import ks.ac.kr.board_demo.domain.post.dto.AllPostResponse;
import ks.ac.kr.board_demo.domain.post.dto.PostResponse;
import ks.ac.kr.board_demo.domain.post.model.Post;
import ks.ac.kr.board_demo.domain.post.repository.PostRepository;
import ks.ac.kr.board_demo.global.exception.domain.NotFoundException;
import lombok.AllArgsConstructor;
import ks.ac.kr.board_demo.global.exception.domain.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PostService {

    PostRepository postRepository;
    MemberRepository memberRepository;
    CommentService commentService;


    public Long createPost(String username, String title, String content) {
        if (username.isEmpty() || title.isEmpty() || content.isEmpty())
            throw new BadRequestException(PostExceptionCode.BAD_REQUEST_MISSING_FIELD);

        Member author = findMemberByUsername(username);
        Post post = Post.of(author, title, content);
        Post generatedPost = postRepository.save(post);

        return generatedPost.getId();
    }

    public PostResponse getPost(Long id) {
        Post post = findPostById(id);
        List<Comment> comments = commentService.getCommentsByPostId(post.getId());

        return PostResponse.from(post, CommentResponse.from(comments));
    }

    public List<AllPostResponse> getAllPosts() {
        return AllPostResponse.from(postRepository.findAll());
    }

    private Post findPostById(Long id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(PostExceptionCode.NOT_FOUND_POSTID));
    }

    private Member findMemberByUsername(String username) {
        return memberRepository.findByUsername(username)
                .orElseThrow(() ->  new NotFoundException(PostExceptionCode.NOT_FOUND_USERID));
    }
}
