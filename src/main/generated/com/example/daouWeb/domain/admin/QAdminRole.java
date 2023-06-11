package com.example.daouWeb.domain.admin;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QAdminRole is a Querydsl query type for AdminRole
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAdminRole extends EntityPathBase<AdminRole> {

    private static final long serialVersionUID = -1571880278L;

    public static final QAdminRole adminRole = new QAdminRole("adminRole");

    public final NumberPath<Long> adminRoleId = createNumber("adminRoleId", Long.class);

    public final StringPath adminRoleNm = createString("adminRoleNm");

    public QAdminRole(String variable) {
        super(AdminRole.class, forVariable(variable));
    }

    public QAdminRole(Path<? extends AdminRole> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAdminRole(PathMetadata metadata) {
        super(AdminRole.class, metadata);
    }

}

