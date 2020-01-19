package com.hh.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Data
public class BaseUser implements Serializable {
    private String id;
    private Date createDate;

    public void init(){
        this.id = UUID.randomUUID().toString();
        this.createDate = new Date();
    }
}
