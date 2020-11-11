package com.jasonless.oauth2.authorization.extension.user;

import com.jasonless.oauth2.authorization.entity.dto.UserDTO;
import com.jasonless.oauth2.authorization.entity.po.User;
import com.jasonless.oauth2.authorization.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiuShiZeng
 */
@Service
public class Oauth2UserService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userService.findByUsername(username);
        //此处可以扩展自己的role权限
        GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_USER");
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(authority);


        UserDTO userDTO = new UserDTO();
        userDTO.setUser(user);
        userDTO.setAuthorities(authorities);

        return userDTO;
    }
}
