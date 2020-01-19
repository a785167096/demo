package com.hh.service;

import com.hh.DTO.UserDto;
import com.hh.model.User;

import java.util.List;


public interface UserService {
     List<UserDto> findUserList();
     User findUserByid(String uid) throws Exception;
     void insertUser(User user);
     void delectUser(User user);
     void updateUser(User user);
}
