package com.example.daouWeb.dto.board;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class BoardDTO implements Serializable {
    private static final long serialVersionUID = 1360673805337413716L;

    private Long boardNo;
    private String boardTitle;
    private String boardWriter;
    private String boardPhone;
    private int boardType;
    private String boardContent;
    private String boardEtc;
    private char delYn;
    private LocalDateTime regDt;
    private LocalDateTime updDt;

    public BoardDTO(Long boardNo, String boardTitle, String boardWriter, String boardPhone, String boardEtc, LocalDateTime regDt) {
        this.boardNo = boardNo;
        this.boardTitle = boardTitle;
        this.boardWriter = boardWriter;
        this.boardPhone = boardPhone;
        this.boardEtc = boardEtc;
        this.regDt = regDt;
    }

    public BoardDTO(Long boardNo, String boardTitle, String boardWriter, String boardPhone, int boardType, String boardContent, String boardEtc, char delYn, LocalDateTime regDt, LocalDateTime updDt) {
        this.boardNo = boardNo;
        this.boardTitle = boardTitle;
        this.boardWriter = boardWriter;
        this.boardPhone = boardPhone;
        this.boardType = boardType;
        this.boardContent = boardContent;
        this.boardEtc = boardEtc;
        this.delYn = delYn;
        this.regDt = regDt;
        this.updDt = updDt;
    }

    public Long getBoardNo() {
        return boardNo;
    }

    public void setBoardNo(Long boardNo) {
        this.boardNo = boardNo;
    }

    public String getBoardTitle() {
        return boardTitle;
    }

    public void setBoardTitle(String boardTitle) {
        this.boardTitle = boardTitle;
    }

    public String getBoardWriter() {
        return boardWriter;
    }

    public void setBoardWriter(String boardWriter) {
        this.boardWriter = boardWriter;
    }

    public String getBoardPhone() {
        return boardPhone;
    }

    public void setBoardPhone(String boardPhone) {
        this.boardPhone = boardPhone;
    }

    public int getBoardType() {
        return boardType;
    }

    public void setBoardType(int boardType) {
        this.boardType = boardType;
    }

    public String getBoardContent() {
        return boardContent;
    }

    public void setBoardContent(String boardContent) {
        this.boardContent = boardContent;
    }

    public String getBoardEtc() {
        return boardEtc;
    }

    public void setBoardEtc(String boardEtc) {
        this.boardEtc = boardEtc;
    }

    public char getDelYn() {
        return delYn;
    }

    public void setDelYn(char delYn) {
        this.delYn = delYn;
    }

    public LocalDateTime getRegDt() {
        return regDt;
    }

    public void setRegDt(LocalDateTime regDt) {
        this.regDt = regDt;
    }

    public LocalDateTime getUpdDt() {
        return updDt;
    }

    public void setUpdDt(LocalDateTime updDt) {
        this.updDt = updDt;
    }
}
