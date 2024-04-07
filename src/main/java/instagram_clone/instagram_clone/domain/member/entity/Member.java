package instagram_clone.instagram_clone.domain.member.entity;

import instagram_clone.instagram_clone.global.common.base.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Getter
@EntityListeners(AuditingEntityListener.class)
public class Member extends BaseEntity {
    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id; // 고유 식별자

    private String memberEmail;
    private String memberName;
    private String memberPassword;
    private String memberPhone;
    private String memberImg;
}
