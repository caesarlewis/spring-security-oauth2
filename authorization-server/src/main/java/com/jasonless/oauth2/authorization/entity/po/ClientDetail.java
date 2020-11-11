package com.jasonless.oauth2.authorization.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;

import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.Date;
import java.util.Map;
import java.util.Set;

/**
 * @author LiuShiZeng
 */
@TableName("client_detail")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientDetail {

    @TableId(type = IdType.AUTO)
    private Long id;

    private String clientId;

    private String clientSecret;

    private String resourceIds;

    private String scope;

    private String authorizedGrantTypes;

    private String redirectUri;

    private Boolean autoApprove;

    private Integer accessTokenValiditySeconds;

    private Integer refreshTokenValiditySeconds;

    private Date createdTime;

    private Date updatedTime;

    private String createdBy;

    private String updatedBy;



}
