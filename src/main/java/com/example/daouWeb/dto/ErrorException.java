package com.example.daouWeb.dto;

public class ErrorException extends Exception{

    private String msg;
    private int code;

    public ErrorException(int code, String msg){ //생성자
        super(msg);
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
