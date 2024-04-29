package instagram_clone.instagram_clone.domain.post.dto;

import instagram_clone.instagram_clone.domain.post.entity.Post;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Data
public class PostResponseDTO {
    @Setter
    @Getter
    public static class PostUploadDTO {
        private Long id;
        private String postImg;
        private String postLocation;
        private String postContent;

        public PostUploadDTO(Post post) {
            this.id = post.getId();
            this.postImg = post.getPostImg();
            this.postLocation = post.getPostLocation();
            this.postContent = post.getPostContent();
        }
    }
    @Setter
    @Getter
    public static class PostUpdateDTO {
        private Long id;
        private String postImg;
        private String postLocation;
        private String postContent;
        public PostUpdateDTO(Post post) {
            this.id = post.getId();
            this.postImg = post.getPostImg();
            this.postLocation = post.getPostLocation();
            this.postContent = post.getPostContent();
        }
    }
    @Setter
    @Getter
    public static class PostFindOneDTO {
        private Long id;
        private String postImg;
        private String postLocation;
        private String postContent;
        private String memberEmail;
        private String memberName;
        private String memberPhone;
        private String memberImg;

        public PostFindOneDTO(Long id, String postImg,  String postLocation, String postContent, String memberEmail, String memberName, String memberPhone, String memberImg) {
            this.id = id;
            this.postImg = postImg;
            this.postLocation = postLocation;
            this.postContent = postContent;
            this.memberEmail = memberEmail;
            this.memberName = memberName;
            this.memberPhone = memberPhone;
            this.memberImg = memberImg;
        }
    }
    @Setter
    @Getter
    public class PostFindAllDTO {
        private String memberEmail;
        private String memberName;
        private String memberImg;
        List<PostFindOneDTO> postList;
        public PostFindAllDTO(String memberEmail, String memberName, String memberImg, List<PostFindOneDTO> postList) {
            this.memberEmail = memberEmail;
            this.memberName = memberName;
            this.memberImg = memberImg;
            this.postList = postList;
        }
    }
}
