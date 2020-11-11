package com.jasonless.oauth2.authorization.entity.dto;

import com.jasonless.oauth2.authorization.entity.po.ClientDetail;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.util.StringUtils;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author LiuShiZeng
 */
@Data
public class ClientDetailDTO implements ClientDetails {

    private ClientDetail clientDetail;

    private Set<String> scope;

    private List<GrantedAuthority> authorities;

    @Override
    public String getClientId() {
        return clientDetail.getClientId();
    }

    @Override
    public Set<String> getResourceIds() {
        return StringUtils.hasText(clientDetail.getResourceIds())?
                StringUtils.commaDelimitedListToSet(clientDetail.getResourceIds()):null;
    }

    @Override
    public boolean isSecretRequired() {
        return true;
    }

    @Override
    public String getClientSecret() {
        return clientDetail.getClientSecret();
    }

    @Override
    public boolean isScoped() {
        return true;
    }

    @Override
    public Set<String> getScope() {
        return StringUtils.hasText(clientDetail.getScope())?
                StringUtils.commaDelimitedListToSet(clientDetail.getScope()):null;
    }

    @Override
    public Set<String> getAuthorizedGrantTypes() {
        return StringUtils.hasText(clientDetail.getRedirectUri())?
                StringUtils.commaDelimitedListToSet(clientDetail.getAuthorizedGrantTypes()):null;

    }

    @Override
    public Set<String> getRegisteredRedirectUri() {
        if (StringUtils.hasText(clientDetail.getRedirectUri())) {
            return StringUtils.commaDelimitedListToSet(clientDetail.getRedirectUri());
        }else{
            return null;
        }
    }

    @Override
    //Spring Security的权限值,就是类似role的属性,可以看成是role
    public Collection<GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public Integer getAccessTokenValiditySeconds() {
        return clientDetail.getAccessTokenValiditySeconds();
    }

    @Override
    public Integer getRefreshTokenValiditySeconds() {
        return clientDetail.getRefreshTokenValiditySeconds();
    }

    @Override
    public boolean isAutoApprove(String s) {
        return clientDetail.getAutoApprove();
    }

    @Override
    public Map<String, Object> getAdditionalInformation() {
        return null;
    }
}
