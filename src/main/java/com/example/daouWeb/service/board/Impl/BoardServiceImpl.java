package com.example.daouWeb.service.board.Impl;

import com.example.daouWeb.domain.board.Board;
import com.example.daouWeb.dto.CustomPageResult;
import com.example.daouWeb.dto.CustomSearchParam;
import com.example.daouWeb.dto.Result;
import com.example.daouWeb.dto.board.BoardDTO;
import com.example.daouWeb.enumResCode.EnumResCode;
import com.example.daouWeb.repository.board.BoardRepository;
import com.example.daouWeb.service.board.BoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final BoardRepository boardRepository;

    @Autowired
    public BoardServiceImpl(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @Override
    public CustomPageResult getBoardList(CustomSearchParam customSearchParam) {
        CustomPageResult pageResult = new CustomPageResult(customSearchParam);
        pageResult.setPageResult(boardRepository.getBoardList(customSearchParam));
        return pageResult;
    }


    @Override
    public Result insertBoard(Board board) {
        boardRepository.save(board);

        return new Result(EnumResCode.OK);
    }

    @Override
    public BoardDTO getBoardDetail(Long id) {
        return boardRepository.getBoardDetail(id);
    }

    @Override
    public Board getBoardDetailed(Long id) {
        return boardRepository.findById(id).get();
    }

    @Override
    public Long getBoardListTotal() {
        return boardRepository.getBoardListTotal();
    }
}
