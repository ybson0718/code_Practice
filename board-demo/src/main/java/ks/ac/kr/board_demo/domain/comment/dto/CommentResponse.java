package ks.ac.kr.board_demo.domain.comment.dto;

import ks.ac.kr.board_demo.domain.comment.model.Comment;
import ks.ac.kr.board_demo.domain.member.dto.MemberResponse;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public record CommentResponse(
        Long id,
        String content,
        LocalDateTime createdAt,
        MemberResponse author
) {
    public static CommentResponse from(Comment comment) {
        return new CommentResponse(
                comment.getId(),
                comment.getContent(),
                comment.getCreatedAt(),
                MemberResponse.from(comment.getMember())
        );
    }

    public static List<CommentResponse> from(List<Comment> comments) {
        List<CommentResponse> commentResponses = new ArrayList<>();
        for (Comment comment : comments)
            commentResponses.add(CommentResponse.from(comment));

        return commentResponses;
    }
}