package instagram_clone.instagram_clone.domain.post.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPost is a Querydsl query type for Post
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPost extends EntityPathBase<Post> {

    private static final long serialVersionUID = -513584949L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPost post = new QPost("post");

    public final instagram_clone.instagram_clone.global.common.base.QBaseEntity _super = new instagram_clone.instagram_clone.global.common.base.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createDate = _super.createDate;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final instagram_clone.instagram_clone.domain.member.entity.QMember member;

    public final StringPath postContent = createString("postContent");

    public final StringPath postImg = createString("postImg");

    public final StringPath postLocation = createString("postLocation");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updateDate = _super.updateDate;

    public QPost(String variable) {
        this(Post.class, forVariable(variable), INITS);
    }

    public QPost(Path<? extends Post> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPost(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPost(PathMetadata metadata, PathInits inits) {
        this(Post.class, metadata, inits);
    }

    public QPost(Class<? extends Post> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.member = inits.isInitialized("member") ? new instagram_clone.instagram_clone.domain.member.entity.QMember(forProperty("member")) : null;
    }

}

