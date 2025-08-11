package ks.ac.kr.board_demo.domain.comment.dto;

public record CommentRequest (
        Long postId,
        String content
) {
}