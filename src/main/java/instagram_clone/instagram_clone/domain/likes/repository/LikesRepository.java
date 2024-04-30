package instagram_clone.instagram_clone.domain.likes.repository;

import instagram_clone.instagram_clone.domain.likes.entity.Likes;
import instagram_clone.instagram_clone.domain.member.entity.Member;
import instagram_clone.instagram_clone.domain.post.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LikesRepository extends JpaRepository<Likes, Long> {
    Optional<Likes> findByMemberAndPost(Member member, Post post);
    long countByPostId(Long postId);
}
