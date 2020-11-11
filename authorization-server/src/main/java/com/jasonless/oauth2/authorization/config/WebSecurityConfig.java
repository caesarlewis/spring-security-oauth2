package com.jasonless.oauth2.authorization.config;

import com.jasonless.oauth2.authorization.extension.user.Oauth2UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

/**
 * @author LiuShiZeng
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private Oauth2UserService oauth2UserService;


    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    /**
     * 显示注入IOC容器中
     * @return
     * @throws Exception
     */
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }



    /**
     * 配置账号
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("starrk")
                .password(new BCryptPasswordEncoder().encode("123"))
                .authorities("ROOT");
//        auth.userDetailsService(oauth2UserService);

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf().disable()//禁用 csrf
            .authorizeRequests() // 设置哪些页面可以直接访问，哪些需要验证
            .antMatchers("/login","/login.html","/error.html").permitAll() // 放过
            .anyRequest().authenticated() // 剩下的所有的地址都是需要在认证状态下才可以访问
            .and()
            .formLogin() //默认表单登录
                .loginPage("/login")// 指定指定要的登录页面
                .loginProcessingUrl("/login.do") // 处理认证路径的请求
                .defaultSuccessUrl("/home.html")
                .failureForwardUrl("/error.html")
                //.failureHandler()
            .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login.html")
       //     .and()
      //          .rememberMe()
      //          .tokenRepository(tokenRepository) // 覆盖掉默认的基于内存存储的方式

        ;
    }

    /**
     * 让Security 忽略这些url，不做拦截处理
     *
     * @param
     * @throws Exception
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers
                ("/swagger-ui.html/**", "/webjars/**",
                        "/swagger-resources/**", "/v2/api-docs/**",
                        "/swagger-resources/configuration/ui/**", "/swagger-resources/configuration/security/**",
                        "/images/**");
    }

    //    @Bean
//    public PersistentTokenRepository tokenRepository(DataSource dataSource){
//        JdbcTokenRepositoryImpl repository = new JdbcTokenRepositoryImpl();
//        repository.setDataSource(dataSource);
//        // 第一次帮我们创建表结构
//        // repository.setCreateTableOnStartup(true);
//        return repository;
//    }


}
