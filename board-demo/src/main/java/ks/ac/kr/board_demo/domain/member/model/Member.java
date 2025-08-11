package ks.ac.kr.board_demo.domain.member.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique=true, nullable=false)
    private String username;

    @Column(nullable = false)
    private String password;

    public Member(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public static Member of(String username, String password) {
        return new Member(username, password);
    }
}
