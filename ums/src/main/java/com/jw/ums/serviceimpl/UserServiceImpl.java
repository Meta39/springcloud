package com.jw.ums.serviceimpl;

import com.jw.ums.entity.User;
import com.jw.ums.dao.UserDao;
import com.jw.ums.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    //根据ID查询
    @Override
    public User select(Long id) {
        return userDao.select(id);
    }

    //查询全部
    @Override
    public List<User> selectAll() {
        return userDao.selectAll();
    }

    //新增
    @Override
    public Integer insert(User user) {
        return userDao.insert(user);
    }

    //更新
    @Override
    public Integer update(User user) {
        return userDao.update(user);
    }

    //删除
    @Override
    public Integer delete(Long id) {
        return userDao.delete(id);
    }
}

