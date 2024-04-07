package instagram_clone.instagram_clone.domain.follow.entity;

import instagram_clone.instagram_clone.domain.member.entity.Member;
import instagram_clone.instagram_clone.global.common.base.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Getter
@EntityListeners(AuditingEntityListener.class)
public class Follow extends BaseEntity {
    @Id
    @GeneratedValue
    @Column(name = "follow_id")
    private Long id; // 고유 식별자

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "from_member_id")
    private Member fromMember;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "to_member_id")
    private Member toMember;
}
