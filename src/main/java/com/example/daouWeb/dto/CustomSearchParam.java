package com.example.daouWeb.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomSearchParam {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private int page = 0;
    private int size = 15;

    private String searchText;
    private Integer type;

    private String boardWriter;

    private String boardPhone;

    private String boardTitle;

    private String boardType;

    private String boardContent;

    public CustomSearchParam(){};

    public CustomSearchParam(Logger logger, int page, int size, String searchText, Integer type, String boardWriter, String boardPhone, String boardTitle, String boardType, String boardContent) {
        this.logger = logger;
        this.page = page;
        this.size = size;
        this.searchText = searchText;
        this.type = type;
        this.boardWriter = boardWriter;
        this.boardPhone = boardPhone;
        this.boardTitle = boardTitle;
        this.boardType = boardType;
        this.boardContent = boardContent;
    }

    public Logger getLogger() {
        return logger;
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getSearchText() {
        return searchText;
    }

    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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

    public String getBoardTitle() {
        return boardTitle;
    }

    public void setBoardTitle(String boardTitle) {
        this.boardTitle = boardTitle;
    }

    public String getBoardType() {
        return boardType;
    }

    public void setBoardType(String boardType) {
        this.boardType = boardType;
    }

    public String getBoardContent() {
        return boardContent;
    }

    public void setBoardContent(String boardContent) {
        this.boardContent = boardContent;
    }
}
