package instagram_clone.instagram_clone.domain.post.repository;

import instagram_clone.instagram_clone.domain.post.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long>, PostRepositoryCustom  {
}
