package instagram_clone.instagram_clone.global.common;
import instagram_clone.instagram_clone.domain.member.entity.Member;
import instagram_clone.instagram_clone.domain.member.repository.MemberRepository;
import instagram_clone.instagram_clone.domain.post.entity.Post;
import instagram_clone.instagram_clone.domain.post.repository.PostRepository;
import instagram_clone.instagram_clone.global.common.exception.CustomException;
import instagram_clone.instagram_clone.global.common.response.ErrorCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Slf4j
@Service
public class CommonMethod {
    private final MemberRepository memberRepository;
    private final PostRepository postRepository;

    /** Member Method **/
    public Member getMember(String identifier, Object value) throws CustomException {
        Optional<Member> findMember = null;
        if (identifier.equals("email")) {
            findMember = memberRepository.findByMemberEmail((String) value);
        } else if (identifier.equals("id")) {
            findMember = memberRepository.findById((Long) value);
        }

        if (findMember == null || !findMember.isPresent()) {
            throw new CustomException(ErrorCode.USER_NOT_FOUND);
        }

        return findMember.get();
    }

    /** Post Method **/
    public Post getPost(Long id) {
        Optional<Post> findPost = postRepository.findById(id);
        if(!findPost.isPresent()) {
            throw new CustomException(ErrorCode.POST_NOT_FOUND);
        }
        else {
            Post post = findPost.get();
            return post;
        }
    }
}
