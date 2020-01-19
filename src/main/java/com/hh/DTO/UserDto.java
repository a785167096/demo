package com.hh.DTO;

import com.hh.model.User;
import lombok.Data;

import java.io.Serializable;
import java.util.Optional;

@Data
public class UserDto extends User implements Serializable {
    private Integer age;
    private String phone;
    private String crd;
}
