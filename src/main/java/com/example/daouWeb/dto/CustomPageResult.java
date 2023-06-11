package com.example.daouWeb.dto;

import org.springframework.data.domain.Page;

public class CustomPageResult<T> {
    private Page<T> pageResult;
    private String searchText;
    private Integer type;
    private String searchList;

    public CustomPageResult() {
    }

    public CustomPageResult(CustomSearchParam customSearchParam) {
        this.pageResult = pageResult;
        this.searchText = searchText;
        this.type = type;
    }

    public Page<T> getPageResult() {
        return pageResult;
    }

    public void setPageResult(Page<T> pageResult) {
        this.pageResult = pageResult;
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

    public String getSearchList() {
        return searchList;
    }

    public void setSearchList(String searchList) {
        this.searchList = searchList;
    }
}
