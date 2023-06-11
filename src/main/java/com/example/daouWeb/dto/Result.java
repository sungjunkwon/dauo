package com.example.daouWeb.dto;

import com.example.daouWeb.enumResCode.EnumResCode;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;

@JsonSerialize
public class Result implements Serializable {

    private static final long serialVersionUID = -6406438110095836318L;
    private String code;
    private String msg;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Object data;

    public Result(EnumResCode resCode) {
        code = resCode.getCode();
        msg = resCode.getMessage();
    }

    public Result(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
