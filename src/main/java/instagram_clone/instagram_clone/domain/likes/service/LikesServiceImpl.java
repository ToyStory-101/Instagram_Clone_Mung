package instagram_clone.instagram_clone.domain.likes.service;

import instagram_clone.instagram_clone.domain.likes.entity.Likes;
import instagram_clone.instagram_clone.domain.likes.repository.LikesRepository;
import instagram_clone.instagram_clone.domain.member.entity.Member;
import instagram_clone.instagram_clone.domain.member.repository.MemberRepository;
import instagram_clone.instagram_clone.domain.post.entity.Post;
import instagram_clone.instagram_clone.domain.post.repository.PostRepository;
import instagram_clone.instagram_clone.global.common.CommonMethod;
import instagram_clone.instagram_clone.global.common.exception.CustomException;
import instagram_clone.instagram_clone.global.common.response.ErrorCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Slf4j
public class LikesServiceImpl implements LikesService {
    private final LikesRepository likesRepository;
    private final CommonMethod commonMethod;
    @Override
    @Transactional
    public String toggle(Long postId, String memberEmail) {
        Member findMember = commonMethod.getMember("email", memberEmail);
        Post findPost = commonMethod.getPost(postId);
        try {
            String result = likesRepository.findByMemberAndPost(findMember, findPost).map(
                    // 좋아요가 이미 존재할 경우
                    like -> {
                        likesRepository.delete(like);
                        return "좋아요를 취소함";
                    }
            ).orElseGet(() -> {
                // 좋아요가 없을 경우
                likesRepository.save(new Likes(findMember, findPost));
                return "좋아요를 누름";
            });

            return result;
        } catch (CustomException ce){
            log.info("[CustomException] LikesServiceImpl toggle");
            throw ce;
        } catch (Exception e){
            throw new CustomException(ErrorCode.SERVER_ERROR, "LikesServiceImpl toggle : " + e.getMessage());
        }
    }

    @Override
    public String count(Long postId) {
        try {
            long countLike = likesRepository.countByPostId(postId);
            Post findPost = commonMethod.getPost(postId);
            String result = countLike+" 이다";
            return result;
        } catch (CustomException ce){
            log.info("[CustomException] LikesServiceImpl count");
            throw ce;
        } catch (Exception e){
            throw new CustomException(ErrorCode.SERVER_ERROR, "LikesServiceImpl count : " + e.getMessage());
        }
    }
}
