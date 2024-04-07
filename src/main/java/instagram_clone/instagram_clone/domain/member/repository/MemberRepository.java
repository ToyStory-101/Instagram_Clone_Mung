package instagram_clone.instagram_clone.domain.member.repository;

import instagram_clone.instagram_clone.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long>, MemberRepositoryCustom {
}
