package com.example.daouWeb.repository.admin.Impl;

import com.example.daouWeb.config.SearchType;
import com.example.daouWeb.domain.admin.QAdmin;
import com.example.daouWeb.dto.CustomSearchParam;
import com.example.daouWeb.dto.admin.AdminDTO;
import com.example.daouWeb.repository.admin.AdminRepositoryCustom;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.QueryResults;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class AdminRepositoryImpl extends QuerydslRepositorySupport implements AdminRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    private JPAQueryFactory queryFactory;

    public AdminRepositoryImpl() {
        super(AdminDTO.class);
    }

    @Override
    public long getSAdminCount(){

        QAdmin admin = QAdmin.admin;

        return from(admin).where(admin.adminAuth.eq((long)1)).fetchCount();
    }

    @Override
    public Page<AdminDTO> getAdminListInfoQ(CustomSearchParam customSearchParam) {
        Pageable pageable = PageRequest.of(customSearchParam.getPage(), customSearchParam.getSize(), Sort.by("adminId").ascending());
        QAdmin admin = QAdmin.admin;

        BooleanBuilder booleanBuilder = new BooleanBuilder();

        if(customSearchParam.getType() != null){
            if(customSearchParam.getType() == SearchType.SEARCH_BY_ADMIN_ID){
                booleanBuilder
                        .and(admin.adminId.like('%' + customSearchParam.getSearchText()+'%'));
            }
            if(customSearchParam.getType() == SearchType.SEARCH_BY_ADMIN_NM){
                booleanBuilder
                        .and(admin.adminNm.like('%' + customSearchParam.getSearchText()+'%'));
            }
        }

        QueryResults<AdminDTO> result = queryFactory.select(
                        Projections.constructor(
                                AdminDTO.class,
                                admin.adminNo,
                                admin.adminId,
                                admin.adminNm,
                                admin.regDt))
                .from(admin)
                .where(booleanBuilder)
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(admin.adminNo.desc())
                .fetchResults();

        return new PageImpl<>(result.getResults(), pageable, result.getTotal());
    }
}
