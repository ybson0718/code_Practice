package ks.ac.kr.board_demo.global.security;

import org.springframework.stereotype.Component;

@Component
public class JwtTokenProvider {

    // 커스텀 예외(서비스에서 캐치용)
    public static class InvalidFormat extends RuntimeException {}
    public static class Expired extends RuntimeException {}

    public void validateRefreshToken(String token) {
        if (token == null || token.isBlank()) throw new InvalidFormat();
        // TODO: 파싱/서명/만료/type=refresh 검사
    }

    public String getSubject(String token) {
        // TODO: 클레임 sub 추출
        return "memberId-or-username";
    }

    public String createAccessToken(String subject) {
        // TODO: 액세스 토큰 생성
        return "new_accessToken";
    }

    public String createRefreshToken(String subject) {
        // TODO: 리프레시 토큰 생성
        return "new_refreshToken";
    }
}
