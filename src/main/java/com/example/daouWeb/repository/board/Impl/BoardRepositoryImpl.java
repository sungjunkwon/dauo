package com.example.daouWeb.repository.board.Impl;

import com.example.daouWeb.config.SearchType;
import com.example.daouWeb.domain.board.QBoard;
import com.example.daouWeb.dto.CustomSearchParam;
import com.example.daouWeb.dto.board.BoardDTO;
import com.example.daouWeb.repository.admin.AdminRepositoryCustom;
import com.example.daouWeb.repository.board.BoardRepositoryCustom;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.QueryResults;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;

@Repository
public class BoardRepositoryImpl extends QuerydslRepositorySupport implements BoardRepositoryCustom {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @PersistenceContext
    private EntityManager entityManager;

    public BoardRepositoryImpl() {super(BoardDTO.class);}

    @Override
    public Long getBoardListTotal() {
        JPAQueryFactory queryFactory = new JPAQueryFactory(this.getEntityManager());

        QBoard board = QBoard.board;

        // LocalDate currentDate = LocalDate.now();

        return queryFactory.select(board.count())
                .from(board)
                .fetchOne();
    }

    @Override
    public BoardDTO getBoardDetail(Long id) {
        JPAQueryFactory queryFactory = new JPAQueryFactory(this.getEntityManager());

        QBoard board = QBoard.board;

        // LocalDate currentDate = LocalDate.now();

        return queryFactory.select(
                Projections.constructor(
                    BoardDTO.class,
                    board.boardNo,
                    board.boardWriter,
                    board.boardPhone,
                    board.boardTitle,
                    board.boardEtc,
                    board.regDt
                ))
                .from(board)
                .where(board.boardNo.eq(id))
                .fetchOne();
    }

    @Override
    public Page<BoardDTO> getBoardList(CustomSearchParam customSearchParam) {
        Pageable pageable =  PageRequest.of(customSearchParam.getPage(), customSearchParam.getSize(), Sort.by("boardNo").descending());
        JPAQueryFactory queryFactory = new JPAQueryFactory(this.getEntityManager());

        QBoard board = QBoard.board;

        BooleanBuilder booleanBuilder = new BooleanBuilder();

        if(customSearchParam.getType() != null){
            if(customSearchParam.getType() == SearchType.SEARCH_BY_BOARD_WRITER){
                booleanBuilder
                        .and(board.boardWriter.like('%' + customSearchParam.getSearchText()+'%'));
            }
        }
        QueryResults<BoardDTO> result = queryFactory.select(
                        Projections.constructor(
                                BoardDTO.class,
                                board.boardNo,
                                board.boardTitle,
                                board.boardWriter,
                                board.boardPhone,
                                board.boardEtc,
                                board.regDt
                        ))
                .from(board)
                .where(booleanBuilder)
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(board.boardNo.desc())
                .fetchResults();

        return new PageImpl<>(result.getResults(), pageable, result.getTotal());
    }
}
