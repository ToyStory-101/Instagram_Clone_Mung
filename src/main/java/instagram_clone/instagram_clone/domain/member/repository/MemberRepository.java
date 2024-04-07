package instagram_clone.instagram_clone.domain.member.repository;

import instagram_clone.instagram_clone.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long>, MemberRepositoryCustom {
    Optional<Member> findByMemberEmail(String memberEmail);
    boolean existsByMemberEmail(String memberEmail);

    Optional<Member> findByMemberEmailAndMemberPassword(String memberEmail, String memberPassword);
}
