package instagram_clone.instagram_clone.domain.follow.entity;

import instagram_clone.instagram_clone.global.common.base.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity
@Getter
public class follow extends BaseEntity {
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
