package com.hh.DTO;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Result<T> {
    private  String code;
    private String msg;
    private T data;

    public Result(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
