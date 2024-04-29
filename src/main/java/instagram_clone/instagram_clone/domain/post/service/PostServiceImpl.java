package instagram_clone.instagram_clone.domain.post.service;

import instagram_clone.instagram_clone.domain.member.entity.Member;
import instagram_clone.instagram_clone.domain.member.repository.MemberRepository;
import instagram_clone.instagram_clone.domain.post.dto.PostRequestDTO;
import instagram_clone.instagram_clone.domain.post.dto.PostResponseDTO;
import instagram_clone.instagram_clone.domain.post.entity.Post;
import instagram_clone.instagram_clone.domain.post.repository.PostRepository;
import instagram_clone.instagram_clone.global.common.CommonMethod;
import instagram_clone.instagram_clone.global.common.exception.CustomException;
import instagram_clone.instagram_clone.global.common.exception.Exception500;
import instagram_clone.instagram_clone.global.common.response.ErrorCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Slf4j
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final CommonMethod commonMethod;
    @Override
    @Transactional
    public PostResponseDTO.PostUploadDTO upload(PostRequestDTO.PostUploadDTO postUploadDTO, String memberEmail) {
        Member findUser = commonMethod.getMember("email", memberEmail);
        try {
            Post post = postUploadDTO.toEntity();
            post.setPostUser(findUser);
            postRepository.save(post);
            return new PostResponseDTO.PostUploadDTO(post);
        } catch (CustomException ce){
            log.info("[CustomException] PostServiceImpl upload");
            throw ce;
        } catch (Exception e){
            throw new CustomException(ErrorCode.SERVER_ERROR, "PostServiceImpl upload : " + e.getMessage());
        }
    }

    @Override
    @Transactional
    public void delete(Long postId, String userEmail) {

    }

    @Override
    @Transactional
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
