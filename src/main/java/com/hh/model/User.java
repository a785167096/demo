package com.hh.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class User extends BaseUser implements Serializable {
    private String username;
    private String password;
    private String phone;
}
