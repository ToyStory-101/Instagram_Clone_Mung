package instagram_clone.instagram_clone.domain.post.repository;

import instagram_clone.instagram_clone.domain.post.dto.PostResponseDTO;

import java.util.List;

public interface PostRepositoryCustom {
    PostResponseDTO.PostFindOneDTO findOne(Long postId);
    PostResponseDTO.PostFindAllDTO postFindAll(Long memberId);
}
