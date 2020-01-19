package com.hh.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hh.DTO.UserDto;
import com.hh.mapper.UserMapper;
import com.hh.model.User;
import com.hh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<UserDto> findUserList() {
        QueryWrapper queryWrapper = new QueryWrapper();
        //queryWrapper.eq("id",7);
        User user = new User();
        List<UserDto> list1 = userMapper.selectList(queryWrapper);
//        List<UserDto> collect = list1.stream().filter(ss -> {
//            return ss.getUsername() != null;
//        }).map(s->{
//            s.setPassword("1111");
//            if ( s.getCreateDate()==null ){
//                s.setCreateDate(new Date());
//
//                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//                String format = simpleDateFormat.format(s.getCreateDate());
//                try {
//                    s.setCreateDate(simpleDateFormat.parse(format));
//                } catch (ParseException e) {
//                    e.printStackTrace();
//                }
//            }
//            return s;
//        }).sorted(Comparator.comparing(User::getCreateDate)).collect(Collectors.toList());

        return list1;
    }

    @Override
    public User findUserByid(String uid) throws Exception {
        User user = new User();
        user.setId(uid);
        User user1 = userMapper.selectById(user);
        Optional.ofNullable(user1).orElse(new User());
        if ( user1==null ){
            throw new Exception("no user");
        }
        return user1;
    }

    @Override
    public void insertUser(User user) {
        user.init();
        userMapper.insert(user);
    }

    @Override
    public void delectUser(User user) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("id",7);
        userMapper.delete(queryWrapper);
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateById(user);
    }
}
