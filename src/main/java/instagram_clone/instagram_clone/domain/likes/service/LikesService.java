package instagram_clone.instagram_clone.domain.likes.service;

public interface LikesService {
    // 좋아요 토글
    String toggle(Long postId, String memberEmail);

    // 좋아요 갯수 조회
    String count(Long postId);
}
