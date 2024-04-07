package instagram_clone.instagram_clone.domain.member.dto;
import instagram_clone.instagram_clone.domain.member.entity.Member;
import lombok.Data;

@Data
public class MemberResponseDTO {
    @Data
    public static class MemberLoginDTO {
        private String memberEmail;
        private String memberPassword;
        private String memberName;
        private String memberPhone;
        private String memberImg;
        public MemberLoginDTO(Member member) {
            this.memberEmail = member.getMemberEmail();
            this.memberPassword = member.getMemberPassword();
            this.memberName = member.getMemberName();
            this.memberPhone = member.getMemberPhone();
            this.memberImg = member.getMemberImg();
        }
    }
    @Data
    public static class MemberLogoutDTO {
        private String memberEmail;
        private String memberPassword;
        private String memberName;
        private String memberPhone;
        private String memberImg;
        public MemberLogoutDTO(Member member) {
            this.memberEmail = member.getMemberEmail();
            this.memberPassword = member.getMemberPassword();
            this.memberName = member.getMemberName();
            this.memberPhone = member.getMemberPhone();
            this.memberImg = member.getMemberImg();
        }
    }
    @Data
    public static class MemberJoinDTO {
        private String memberEmail;
        private String memberPassword;
        private String memberName;
        private String memberPhone;
        private String memberImg;
        public MemberJoinDTO(Member member) {
            this.memberEmail = member.getMemberEmail();
            this.memberPassword = member.getMemberPassword();
            this.memberName = member.getMemberName();
            this.memberPhone = member.getMemberPhone();
            this.memberImg = member.getMemberImg();
        }
    }
    @Data
    public static class MemberDeleteDTO {
        private String memberEmail;
        private String memberPassword;
        private String memberName;
        private String memberPhone;
        private String memberImg;
        public MemberDeleteDTO(Member member) {
            this.memberEmail = member.getMemberEmail();
            this.memberPassword = member.getMemberPassword();
            this.memberName = member.getMemberName();
            this.memberPhone = member.getMemberPhone();
            this.memberImg = member.getMemberImg();
        }
    }
    @Data
    public static class MemberUpdateDTO {
        private String memberEmail;
        private String memberPassword;
        private String memberName;
        private String memberPhone;
        private String memberImg;
        public MemberUpdateDTO(Member member) {
            this.memberEmail = member.getMemberEmail();
            this.memberPassword = member.getMemberPassword();
            this.memberName = member.getMemberName();
            this.memberPhone = member.getMemberPhone();
            this.memberImg = member.getMemberImg();
        }
    }
    @Data
    public static class MemberFindOneDTO {
        private String memberEmail;
        private String memberPassword;
        private String memberName;
        private String memberPhone;
        private String memberImg;
        public MemberFindOneDTO(Member member) {
            this.memberEmail = member.getMemberEmail();
            this.memberPassword = member.getMemberPassword();
            this.memberName = member.getMemberName();
            this.memberPhone = member.getMemberPhone();
            this.memberImg = member.getMemberImg();
        }
    }
}
