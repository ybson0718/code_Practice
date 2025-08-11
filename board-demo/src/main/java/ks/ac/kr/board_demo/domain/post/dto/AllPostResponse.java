package ks.ac.kr.board_demo.domain.post.dto;

import ks.ac.kr.board_demo.domain.member.dto.MemberResponse;
import ks.ac.kr.board_demo.domain.post.model.Post;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public record AllPostResponse(
        Long id,
        String title,
        LocalDateTime createdAt,
        MemberResponse author
) {
    public static AllPostResponse from(final Post post) {
        return new AllPostResponse(
                post.getId(),
                post.getTitle(),
                post.getCreatedAt(),
                MemberResponse.from(post.getMember())
        );
    }

    public static List<AllPostResponse> from(final List<Post> posts) {
        List<AllPostResponse> allPostResponses = new ArrayList<>();
        for (Post post : posts)
            allPostResponses.add(AllPostResponse.from(post));

        return allPostResponses;
    }
}
