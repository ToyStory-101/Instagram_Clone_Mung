package instagram_clone.instagram_clone.domain.post.service;

import instagram_clone.instagram_clone.domain.post.dto.PostRequestDTO;
import instagram_clone.instagram_clone.domain.post.dto.PostResponseDTO;

public interface PostService {
    // 게시물 업로드
    PostResponseDTO.PostUploadDTO upload(PostRequestDTO.PostUploadDTO postUploadDTO, String userEmail);
    // 게시물 탈퇴
    void delete(Long postId, String userEmail);

    // 게시물 수정
    PostResponseDTO.PostUpdateDTO update(PostRequestDTO.PostUpdateDTO postUpdateDTO, String userEmail, Long postId);

    // 게시물 하나 조회
    PostResponseDTO.PostFindOneDTO findOne(Long postId);

    // 게시물 전체 조회
    PostResponseDTO.PostFindAllDTO findAll(Long memberId);
}
