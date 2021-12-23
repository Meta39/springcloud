package com.jw.ums.service;

import com.jw.ums.entity.User;
import com.jw.ums.service.UserService;

import java.util.List;


public interface UserService {

    //根据ID查询
    User select(Long id);

    //查询全部
    List<User> selectAll();

    //新增
    Integer insert(User user);

    //更新
    Integer update(User user);

    //删除
    Integer delete(Long id);
}
