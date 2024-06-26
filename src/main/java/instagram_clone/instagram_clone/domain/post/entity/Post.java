package instagram_clone.instagram_clone.domain.post.entity;

import instagram_clone.instagram_clone.domain.member.entity.Member;
import instagram_clone.instagram_clone.global.common.base.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Getter
@EntityListeners(AuditingEntityListener.class)
public class Post extends BaseEntity {
    @Id
    @GeneratedValue
    @Column(name = "image_id")
    private Long id; // 고유 식별자

    private String postImg;
    private String postLocation;
    private String postContent;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    public Post(String postImg, String postLocation, String postContent) {
        this.postImg = postImg;
        this.postLocation = postLocation;
        this.postContent = postContent;
    }

    public Post() {

    }

    public void setPostUser(Member member)  {
        this.member = member;
    }
    public void updatePost(String postImg, String postLocation, String postContent) {
        this.postImg = postImg;
        this.postLocation = postLocation;
        this.postContent = postContent;
    }
}
