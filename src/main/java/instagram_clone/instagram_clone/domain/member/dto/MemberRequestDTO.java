package instagram_clone.instagram_clone.domain.member.dto;

import instagram_clone.instagram_clone.domain.member.entity.Member;
import lombok.Data;

@Data
public class MemberRequestDTO {
    public static class MemberLoginDTO {
        private String memberEmail;
        private String memberPassword;
    }

    public static class MemberJoinDTO {
        private String memberEmail;
        private String memberPassword;
        private String memberName;
        private String memberPhone;
        public Member toEntity() {
            return new Member(this.memberEmail, this.memberPassword, this.memberName, this.memberPhone);
        }
    }

    public static class MemberUpdateDTO {
        private String memberName;
    }
}
