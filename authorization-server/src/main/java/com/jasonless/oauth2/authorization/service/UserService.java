package com.jasonless.oauth2.authorization.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jasonless.oauth2.authorization.entity.po.User;

import java.util.List;

/**
 * @author LiuShiZeng
 */
public interface UserService extends IService<User> {


    User findByUsername(String username);

}
