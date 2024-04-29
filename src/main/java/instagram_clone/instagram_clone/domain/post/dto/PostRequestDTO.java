package instagram_clone.instagram_clone.domain.post.dto;

import instagram_clone.instagram_clone.domain.post.entity.Post;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class PostRequestDTO {
    @Setter
    @Getter
    public static class PostUploadDTO {
        private String postImg;
        private String postLocation;
        private String postContent;

        public Post toEntity() {
            return new Post(this.postImg, this.postLocation, this.postContent);
        }
    }

    @Getter
    @Setter
    public static class PostUpdateDTO {
        private String postImg;
        private String postLocation;
        private String postContent;
    }
}
