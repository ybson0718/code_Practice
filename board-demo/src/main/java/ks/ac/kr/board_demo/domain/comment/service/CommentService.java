package ks.ac.kr.board_demo.domain.comment.service;

import ks.ac.kr.board_demo.domain.comment.controller.CommentExceptionCode;
import ks.ac.kr.board_demo.domain.comment.model.Comment;
import ks.ac.kr.board_demo.domain.comment.repository.CommentRepository;
import ks.ac.kr.board_demo.domain.member.model.Member;
import ks.ac.kr.board_demo.domain.member.repository.MemberRepository;
import ks.ac.kr.board_demo.domain.post.model.Post;
import ks.ac.kr.board_demo.domain.post.repository.PostRepository;
import ks.ac.kr.board_demo.domain.post.service.PostService;
import ks.ac.kr.board_demo.global.exception.domain.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    final MemberRepository memberRepository;
    final PostRepository postRepository;
    final CommentRepository commentRepository;

    public void createComment(String username, Long postId, String content) {

        System.out.println(username + "\n" + postId + "\n" + content);

        Member author = memberRepository.findByUsername(username)
                .orElseThrow(() -> new NotFoundException(CommentExceptionCode.NOT_FOUND_USER_ID));
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new NotFoundException(CommentExceptionCode.NOT_FOUND_POST_ID));
        Comment comment = Comment.of(content, author, post);

        commentRepository.save(comment);
    }

    public List<Comment> getCommentsByPostId(Long postId) {
        return commentRepository.findCommentByPost_Id(postId);
    }

}