package ks.ac.kr.board_demo.domain.member.controller;

import ks.ac.kr.board_demo.domain.member.dto.MemberResponse;
import ks.ac.kr.board_demo.domain.member.dto.MemberRequest;
import ks.ac.kr.board_demo.domain.member.dto.MemberWithdrawalRequest;
import ks.ac.kr.board_demo.domain.member.dto.TokenResponse;
import ks.ac.kr.board_demo.domain.member.service.MemberService;
import ks.ac.kr.board_demo.global.response.BoardResponse;
import ks.ac.kr.board_demo.global.exception.domain.BadRequestException;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class MemberController {

    MemberService memberService;

    @PostMapping("/register")
    public BoardResponse register(
            @RequestBody MemberRequest req
            ) {
       memberService.createMember(req.username(), req.password());
       return BoardResponse.of(MemberSuccessCode.OK_REGISTERED_MEMBER);
    }

    @PostMapping("/login")
    public BoardResponse login(
            @RequestBody MemberRequest req
    )
    {
        memberService.validateMember(req.username(), req.password());
        return BoardResponse.of(MemberSuccessCode.OK_LOGGED_IN);
    }

    @PostMapping("/reissue")
    public BoardResponse reissue(@RequestHeader("Authorization-Refresh") String oldRefreshToken) {
        TokenResponse tokens = memberService.reissue(oldRefreshToken);
        return BoardResponse.of(MemberSuccessCode.OK_TOKEN_REISSUED, tokens);
    }



    @PostMapping("/withdrawal")
    public BoardResponse withdrawal(
            @RequestHeader("Authorization") String username,
            @RequestBody MemberWithdrawalRequest req
    ) {
        if (req.password() == null || req.password().isBlank()) {
            throw new BadRequestException(MemberExceptionCode.BAD_REQUEST_NO_INFO);
        }

        memberService.withdrawalMember(username, req.password());
        return BoardResponse.of(MemberSuccessCode.OK_WITHDRAWAL_MEMBER);
    }


}
