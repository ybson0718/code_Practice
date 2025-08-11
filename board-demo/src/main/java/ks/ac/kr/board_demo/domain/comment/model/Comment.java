package ks.ac.kr.board_demo.domain.comment.model;

import ks.ac.kr.board_demo.domain.member.model.Member;
import ks.ac.kr.board_demo.domain.post.model.Post;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String content;

    @JoinColumn
    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

    @JoinColumn
    @ManyToOne(fetch = FetchType.LAZY)
    private Post post;

    @CreationTimestamp
    LocalDateTime createdAt;

    public Comment(String content, Member member, Post post) {
        this.content = content;
        this.member = member;
        this.post = post;
    }

    public static Comment of(String content, Member member, Post post) {
        return new Comment(content, member, post);
    }

}