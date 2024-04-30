package instagram_clone.instagram_clone.domain.likes.entity;

import instagram_clone.instagram_clone.domain.member.entity.Member;
import instagram_clone.instagram_clone.domain.post.entity.Post;
import instagram_clone.instagram_clone.global.common.base.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Getter
@EntityListeners(AuditingEntityListener.class)
public class Likes extends BaseEntity {
    @Id
    @GeneratedValue
    @Column(name = "likes_id")
    private Long id; // 고유 식별자

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;


    public Likes() {

    }
    public Likes(Member member, Post post) {
        this.member = member;
        this.post = post;
    }
}
