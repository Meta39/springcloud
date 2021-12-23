package com.jw.ums;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jw.common.entity.TokenInfo;
import com.jw.common.result.Err;
import com.jw.ums.entity.User;
import com.jw.ums.dao.UserDao;
import com.jw.ums.redis.RedisUtils;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * 登录
 */
@RestController
public class LoginController {
    @Resource
    private UserDao userDao;
    @Resource
    private RedisUtils redisUtils;

    @PostMapping("login")
    public TokenInfo login(@RequestParam String userName,@RequestParam String password) throws JsonProcessingException {
        User user = userDao.selectByName(userName);
        if (user == null) throw new Err("用户名不存在");
        if (!user.getPassword().equals(DigestUtils.md5DigestAsHex((userName+password).getBytes()))) throw new Err("密码错误");
        String token = UUID.randomUUID().toString();
        TokenInfo tokenInfo = new TokenInfo(token,user.getId(),user.getName());
        redisUtils.set(token,new ObjectMapper().writeValueAsString(tokenInfo));
        return tokenInfo;
    }

}
