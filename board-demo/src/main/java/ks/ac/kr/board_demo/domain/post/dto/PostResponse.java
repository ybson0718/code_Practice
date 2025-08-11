package ks.ac.kr.board_demo.domain.post.dto;

import ks.ac.kr.board_demo.domain.comment.dto.CommentResponse;
import ks.ac.kr.board_demo.domain.member.dto.MemberResponse;
import ks.ac.kr.board_demo.domain.post.model.Post;

import java.time.LocalDateTime;
import java.util.List;

public record PostResponse(
        Long id,
        String title,
        String content,
        LocalDateTime createdAt,
        MemberResponse author,
        List<CommentResponse> comments
) {
    public static PostResponse from(final Post post, final List<CommentResponse> comments) {
        return new PostResponse(
                post.getId(),
                post.getTitle(),
                post.getContent(),
                post.getCreatedAt(),
                MemberResponse.from(post.getMember()),
                comments
        );
    }
}
