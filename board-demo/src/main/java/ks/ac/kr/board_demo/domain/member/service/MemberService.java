package ks.ac.kr.board_demo.domain.member.service;

import ks.ac.kr.board_demo.domain.member.controller.MemberExceptionCode;
import ks.ac.kr.board_demo.domain.member.dto.TokenResponse;
import ks.ac.kr.board_demo.domain.member.model.Member;
import ks.ac.kr.board_demo.domain.member.repository.MemberRepository;
import ks.ac.kr.board_demo.global.exception.domain.BadRequestException;
import ks.ac.kr.board_demo.global.exception.domain.NotFoundException;
import ks.ac.kr.board_demo.global.exception.domain.UnauthorizedException;
import ks.ac.kr.board_demo.global.security.JwtTokenProvider;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MemberService {

    MemberRepository memberRepository;
    JwtTokenProvider jwtTokenProvider;

    public void createMember(String username, String password) {
        Member member = Member.of(username, password);
        memberRepository.save(member);
    }
    public void validateMember(String username, String password) {
        Member member = memberRepository.findByUsername(username)
                .orElseThrow(() -> new NotFoundException(MemberExceptionCode.NOT_FOUND_USER_NAME));
        if (!member.getPassword().equals(password)) {
            throw new UnauthorizedException(MemberExceptionCode.UNAUTHORIZED_WRONG_PASSWORD);
        }
    }
    public void withdrawalMember(String username, String password) {
        Member member = memberRepository.findByUsername(username)
                .orElseThrow(() -> new NotFoundException(MemberExceptionCode.NOT_FOUND_USER_NAME));
        if (!member.getPassword().equals(password)) {
            throw new UnauthorizedException(MemberExceptionCode.UNAUTHORIZED_WRONG_PASSWORD);
        }
        memberRepository.delete(member);
    }

    public TokenResponse reissue(String oldRefreshToken) {
        jwtTokenProvider.validateRefreshToken(oldRefreshToken);
        String subject    = jwtTokenProvider.getSubject(oldRefreshToken);
        String newAccess  = jwtTokenProvider.createAccessToken(subject);
        String newRefresh = jwtTokenProvider.createRefreshToken(subject);
        return new TokenResponse(newAccess, newRefresh);
        }

}
