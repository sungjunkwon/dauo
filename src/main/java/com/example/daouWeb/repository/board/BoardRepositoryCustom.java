package com.example.daouWeb.repository.board;

import com.example.daouWeb.domain.board.Board;
import com.example.daouWeb.dto.CustomSearchParam;
import com.example.daouWeb.dto.board.BoardDTO;
import org.springframework.data.domain.Page;

public interface BoardRepositoryCustom {
    Page<BoardDTO> getBoardList(CustomSearchParam customSearchParam);

    Long getBoardListTotal();

    BoardDTO getBoardDetail(Long id);

}
