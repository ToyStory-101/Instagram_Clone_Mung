package instagram_clone.instagram_clone.domain.post.repository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import instagram_clone.instagram_clone.domain.post.dto.PostResponseDTO;
import jakarta.persistence.EntityManager;

import java.util.List;

import static instagram_clone.instagram_clone.domain.member.entity.QMember.member;
import static instagram_clone.instagram_clone.domain.post.entity.QPost.post;


public class PostRepositoryImpl implements PostRepositoryCustom {
    private final JPAQueryFactory queryFactory;
    public PostRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public PostResponseDTO.PostFindOneDTO findOne(Long postId) {
        return queryFactory
                .select(Projections.constructor(PostResponseDTO.PostFindOneDTO.class,
                        post.id,
                        post.postImg,
                        post.postLocation,
                        post.postContent,
                        member.memberEmail,
                        member.memberName,
                        member.memberPhone,
                        member.memberImg
                ))
                .from(post)
                .leftJoin(post.member, member)
                .where(post.id.eq(postId))
                .fetchOne();
    }
    @Override
    public PostResponseDTO.PostFindAllDTO postFindAll(Long memberId) {
        List<PostResponseDTO.PostFindOneDTO> postList = queryFactory
                .select(Projections.constructor(PostResponseDTO.PostFindOneDTO.class,
                        post.id,
                        post.postImg,
                        post.postLocation,
                        post.postContent,
                        member.memberEmail,
                        member.memberName,
                        member.memberPhone,
                        member.memberImg
                ))
                .from(post)
                .leftJoin(post.member, member)
                .where(member.id.eq(memberId))
                .fetch();
        return new PostResponseDTO.PostFindAllDTO(memberId, postList);
    }
}
