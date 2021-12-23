package com.jw.ums.dao;

import com.jw.ums.entity.User;

import java.util.List;

public interface UserDao {

    //根据ID查询
    User select(Long id);

    //查询全部
    List<User> selectAll();

    //新增
    int insert(User user);

    //更新
    int update(User user);

    //删除
    int delete(Long id);

    //校验用户名
    User selectByName(String name);

}

