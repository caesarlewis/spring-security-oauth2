package com.jasonless.oauth2.authorization.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * @author LiuShiZeng
 */
@TableName("user")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {

    @TableId(type = IdType.AUTO)
    private Long id;
    //用户名
    private String username;

    private String password;
    //名称（昵称）
    private String name;

    private String email;

    private String phone;


    @TableField("is_enable")
    private Boolean enable;
    @TableField("is_expired")
    private Boolean expired;
    @TableField("is_locked")
    private Boolean locked;


    private Date createdTime;

    private Date updatedTime;

    private String createdBy;

    private String updatedBy;


}
