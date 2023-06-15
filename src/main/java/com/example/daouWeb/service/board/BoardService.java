package com.example.daouWeb.service.board;

import com.example.daouWeb.domain.board.Board;
import com.example.daouWeb.dto.CustomPageResult;
import com.example.daouWeb.dto.CustomSearchParam;
import com.example.daouWeb.dto.Result;
import com.example.daouWeb.dto.board.BoardDTO;

import java.util.List;

public interface BoardService {
    CustomPageResult getBoardList(CustomSearchParam customSearchParam);

    BoardDTO getBoardDetail(Long id);

    Board getBoardDetailed(Long id);

    Result insertBoard(Board board);

    Long getBoardListTotal(CustomSearchParam customSearchParam);
}

