package instagram_clone.instagram_clone.domain.post.service;

import instagram_clone.instagram_clone.domain.post.dto.PostRequestDTO;
import instagram_clone.instagram_clone.domain.post.dto.PostResponseDTO;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {
    @Override
    public void delete(Long postId, String userEmail) {

    }

    @Override
    public PostResponseDTO.PostUpdateDTO update(PostRequestDTO.PostUpdateDTO postUpdateDTO, String userEmail, Long postId) {
        return null;
    }

    @Override
    public PostResponseDTO.PostFindOneDTO findOne(Long postId) {
        return null;
    }

    @Override
    public PostResponseDTO.PostFindAllDTO findAll(Long postId) {
        return null;
    }
}
