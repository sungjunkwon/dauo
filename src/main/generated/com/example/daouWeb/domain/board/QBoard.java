package com.example.daouWeb.domain.board;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QBoard is a Querydsl query type for Board
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QBoard extends EntityPathBase<Board> {

    private static final long serialVersionUID = -943668734L;

    public static final QBoard board = new QBoard("board");

    public final StringPath boardContent = createString("boardContent");

    public final StringPath boardEtc = createString("boardEtc");

    public final NumberPath<Long> boardNo = createNumber("boardNo", Long.class);

    public final StringPath boardPhone = createString("boardPhone");

    public final StringPath boardTitle = createString("boardTitle");

    public final NumberPath<Integer> boardType = createNumber("boardType", Integer.class);

    public final StringPath boardWriter = createString("boardWriter");

    public final ComparablePath<Character> delYn = createComparable("delYn", Character.class);

    public final DateTimePath<java.time.LocalDateTime> regDt = createDateTime("regDt", java.time.LocalDateTime.class);

    public final DateTimePath<java.time.LocalDateTime> updDt = createDateTime("updDt", java.time.LocalDateTime.class);

    public QBoard(String variable) {
        super(Board.class, forVariable(variable));
    }

    public QBoard(Path<? extends Board> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBoard(PathMetadata metadata) {
        super(Board.class, metadata);
    }

}

