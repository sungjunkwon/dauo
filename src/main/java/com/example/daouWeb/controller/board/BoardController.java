package com.example.daouWeb.controller.board;

import com.example.daouWeb.domain.board.Board;
import com.example.daouWeb.dto.CustomSearchParam;
import com.example.daouWeb.dto.Result;
import com.example.daouWeb.dto.board.BoardDTO;
import com.example.daouWeb.service.board.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Controller
public class BoardController {

    BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }


    @RequestMapping(value = "/board/insert", method = RequestMethod.GET)
    public String insert(Model model){
        return "board/board_insert";
    }

    @RequestMapping(value = "/board/list", method = RequestMethod.GET)
    public String getBoardList(Model model, @ModelAttribute CustomSearchParam customSearchParam){
        model.addAttribute("result", boardService.getBoardList(customSearchParam));
        model.addAttribute("total", boardService.getBoardListTotal(customSearchParam));
        return "board/board_list";
    }

    //    @PreAuthorize("isAuthenticated() and hasAnyAuthority('Supervisor','Manager')")
    @RequestMapping(value = "/board/detail/{id}", method = RequestMethod.GET)
    public String getBoardDetail(Model model, @PathVariable Long id){


        model.addAttribute("result", boardService.getBoardDetailed(id));
        return "board/board_detail";
    }

    // @PreAuthorize("isAuthenticated() and hasAnyAuthority('Supervisor','Manager')")
    @RequestMapping(value = "/board/insert", method = RequestMethod.POST)
    public @ResponseBody Result boardInsert(@RequestBody Board param){
        param.setRegDt(LocalDateTime.now());
        return boardService.insertBoard(param);
    }

}
