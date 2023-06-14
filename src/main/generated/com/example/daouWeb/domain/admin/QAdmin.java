package com.example.daouWeb.domain.admin;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAdmin is a Querydsl query type for Admin
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAdmin extends EntityPathBase<Admin> {

    private static final long serialVersionUID = 283785236L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QAdmin admin = new QAdmin("admin");

    public final NumberPath<Long> adminAuth = createNumber("adminAuth", Long.class);

    public final StringPath adminId = createString("adminId");

    public final StringPath adminNm = createString("adminNm");

    public final NumberPath<Long> adminNo = createNumber("adminNo", Long.class);

    public final StringPath adminPhone = createString("adminPhone");

    public final StringPath adminPw = createString("adminPw");

    public final QAdminRole adminRole;

    public final DateTimePath<java.time.LocalDateTime> regDt = createDateTime("regDt", java.time.LocalDateTime.class);

    public final DateTimePath<java.time.LocalDateTime> updDt = createDateTime("updDt", java.time.LocalDateTime.class);

    public QAdmin(String variable) {
        this(Admin.class, forVariable(variable), INITS);
    }

    public QAdmin(Path<? extends Admin> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QAdmin(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QAdmin(PathMetadata metadata, PathInits inits) {
        this(Admin.class, metadata, inits);
    }

    public QAdmin(Class<? extends Admin> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.adminRole = inits.isInitialized("adminRole") ? new QAdminRole(forProperty("adminRole")) : null;
    }

}

