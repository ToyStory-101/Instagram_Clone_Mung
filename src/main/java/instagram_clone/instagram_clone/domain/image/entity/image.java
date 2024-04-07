package instagram_clone.instagram_clone.domain.image.entity;

import instagram_clone.instagram_clone.domain.member.entity.Member;
import instagram_clone.instagram_clone.global.common.base.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class image extends BaseEntity {
    @Id
    @GeneratedValue
    @Column(name = "image_id")
    private Long id; // 고유 식별자

    private String imageUrl;
    private String imageLocation;
    private String imageComment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;
}
