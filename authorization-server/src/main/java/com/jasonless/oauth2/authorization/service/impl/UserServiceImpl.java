package com.jasonless.oauth2.authorization.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jasonless.oauth2.authorization.entity.po.User;
import com.jasonless.oauth2.authorization.mapper.UserMapper;
import com.jasonless.oauth2.authorization.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author LiuShiZeng
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public User findByUsername(String username) {
        return this.baseMapper.findByUsername(username);
    }
}
