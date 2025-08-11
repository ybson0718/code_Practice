package ks.ac.kr.board_demo.domain.member.dto;

import ks.ac.kr.board_demo.domain.member.model.Member;

public record MemberResponse(
        Long id,
        String username
){
    public static MemberResponse from (Member member) {
        return new MemberResponse(member.getId(), member.getUsername());
    }
}
