package com.jw.ums.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageSerializable;
import com.jw.ums.entity.User;
import com.jw.ums.serviceimpl.UserServiceImpl;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 *
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Resource
    private UserServiceImpl userServiceImpl;

    /**
     * 根据ID查询
     *
     * @param id
     */
    @GetMapping("select")
    public User select(@RequestParam Long id) {
        return userServiceImpl.select(id);
    }

    /**
     * 查询全部
     */
    @GetMapping("selectAll")
    public List<User> selectAll() {
        return userServiceImpl.selectAll();
    }

    /**
     * 查询全部（分页）
     *
     * @param pageNum  起始页
     * @param pageSize 每页数据量
     */
    @GetMapping("selectPage")
    public PageSerializable<User> selectPage(@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "10") Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return PageSerializable.of(userServiceImpl.selectAll());
    }

    /**
     * 新增
     *
     * @param user
     */
    @PostMapping("insert")
    public Integer insert(@RequestBody @Valid User user) {
        return userServiceImpl.insert(user);
    }

    /**
     * 修改
     *
     * @param user
     */
    @PostMapping("update")
    public Integer update(@RequestBody @Valid User user) {
        return userServiceImpl.update(user);
    }

    /**
     * 删除
     *
     * @param id
     */
    @PostMapping("delete")
    public Integer delete(@RequestParam Long id) {
        return userServiceImpl.delete(id);
    }

}

