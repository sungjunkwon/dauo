package com.example.daouWeb.domain.board;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "board")
public class Board implements Serializable {

    private static final long serialVersionUID = 5074754495811628659L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="board_no", nullable = false)
    private Long boardNo;

    @Column(name="board_title", nullable = false)
    private String boardTitle;

    @Column(name="board_writer", nullable = false)
    private String boardWriter;

    @Column(name="board_phone", nullable = false)
    private String boardPhone;

    @Column(name="board_type", nullable = false)
    private int boardType;

    @Column(name="board_content")
    private String boardContent;

    @Column(name="board_etc")
    private String boardEtc;

    @Column(name="del_yn", nullable = false)
    private char delYn;

    @Column(name="reg_dt")
    private LocalDateTime regDt;

    @Column(name="upd_dt")
    private LocalDateTime updDt;

    public Board(){};

    public Board(Long boardNo, String boardTitle, String boardWriter, String boardPhone, int boardType, String boardContent, String boardEtc, char delYn, LocalDateTime regDt, LocalDateTime updDt) {
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
