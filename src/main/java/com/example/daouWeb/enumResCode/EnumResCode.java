package com.example.daouWeb.enumResCode;

public enum EnumResCode {
    OK("0000" ,"정상처리"),
    E001("E001" , "해당 게시글이 존재하지 않습니다"),
    E002("E002" , "해당 작성자가 존재하지 않습니다"),
    E003("E003" , "해당 내용이 존재하지 않습니다"),
    E004("E004" , "해당 아이디가 존재하지 않거나 비밀번호가 틀립니다."),

    E006("E006" , "해당 아이디는 이미 존재합니다."),
    E007("E007" , "중복 된 값입니다 다시 확인해 주세요"),
    E008("E008" , "검색 결과가 없습니다"),
    E009("E009" , "변경 내역이 없습니다"),

    E010("E010" , "조회하는 도중 오류가 발생하였습니다"),
    E011("E011" , "생성하는 도중 오류가 발생하였습니다"),
    E012("E012" , "수정하는 도중 오류가 발생하였습니다"),
    E013("E013" , "삭제하는 도중 오류가 발생하였습니다"),

    E020("E020" , "아이디 또는 비밀번호가 잘못됐습니다"),
    E021("E021" , "등록 권한이 없습니다."),
    E022("E022" , "수정 권한이 없습니다."),
    E023("E023" , "삭제 권한이 없습니다."),

    E990("E990" , "파라미터 부족"),
    E991("E991" , "파라미터 변환 오류"),
    E996("E996" , "DB 커넥션이 최대치 입니다"),
    E997("E997" , "잘못 된 URL 입니다"),
    E998("E998" , "데이터베이스 에러"),
    E999("E999" , "시스템 에러");

    private String code;
    private String msg;

    EnumResCode(String code) {
        this.code = code;
    }

    EnumResCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    public String getCode() {
        return this.code;
    }
    public String getMessage() {
        return this.msg;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
