package ks.ac.kr.board_demo.domain.member.dto;

public record MemberRequest(
    String username,
    String password
) {
}
