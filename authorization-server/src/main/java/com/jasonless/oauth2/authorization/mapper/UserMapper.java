package com.jasonless.oauth2.authorization.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jasonless.oauth2.authorization.entity.po.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author LiuShiZeng
 */
@Mapper
@Repository
public interface UserMapper extends BaseMapper<User> {

    @Select("select * from user where username=#{username}")
    User findByUsername(@Param("username") String username);

}
