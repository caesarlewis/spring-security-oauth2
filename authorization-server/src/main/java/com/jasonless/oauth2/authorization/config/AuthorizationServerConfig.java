package com.jasonless.oauth2.authorization.config;

import com.jasonless.oauth2.authorization.extension.oauth2.Oauth2ClientDetailService;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.code.AuthorizationCodeServices;
import org.springframework.security.oauth2.provider.code.InMemoryAuthorizationCodeServices;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

/**
 * @author LiuShiZeng
 */
@Configuration
//激活Oauth2.0 显示表示是一个授权服务
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired(required = false)
    private TokenStore tokenStore;

    @Autowired
    private ClientDetailsService clientDetailsService;

    @Autowired
    private AuthorizationCodeServices authorizationCodeServices;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private Oauth2ClientDetailService oauth2ClientDetailService;

    //权限服务的配置
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
//        security.tokenKeyAccess("permitAll()") // 资源服务发送的检查Token是否合法
//                .checkTokenAccess("permitAll()")//客户端发送的获取Token的服务方法
//                .allowFormAuthenticationForClients()//支持客户端表单提交
//        ;
        //允许表单登录
        security.allowFormAuthenticationForClients()
                .tokenKeyAccess("permitAll()")
                .checkTokenAccess("permitAll()");

        //加载client的service





    }

    //客户端信息的配置
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//        clients.inMemory() // 使用内存来存储客户端的信息
//                .withClient("c1") // 客户端编号
//                .secret(new BCryptPasswordEncoder().encode("secret"))
//                .resourceIds("res1")//可以访问的资源的编号
//                .authorizedGrantTypes("authorization_code", "password","client_credentials","implicit","refresh_token") //该客户端允许的授权类型
//                .scopes("all") // 允许授权的范围  我们对资源操作的作用域 读 写
//                .autoApprove(false) // false的话 请求到来的时候会跳转到授权页面
//                .redirectUris("http://www.baidu.com")// 回调的地址  授权码会作为参赛绑定在重定向的地址中
//            ;
        clients.withClientDetails(oauth2ClientDetailService);
    }

    /**
     * 服务请求的配置
     * @param endpoints
     * @throws Exception
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.setClientDetailsService(clientDetailsService);
        endpoints.authenticationManager(authenticationManager) // 管理认证管理器
                .authorizationCodeServices(authorizationCodeServices) // 授权码服务
                .tokenStore(tokenStore)
      //          .approvalStore()
       //         .tokenServices(tokenServices()) // token服务
                .allowedTokenEndpointRequestMethods(HttpMethod.POST,HttpMethod.GET)
            //    .pathMapping("/oauth/confirm_access","/oauth2/confirm_access") //自定义oauth授权页面
        ;
    }

//    /**
//     * token令牌 服务
//     * @return
//     */
//    @Bean
//    public AuthorizationServerTokenServices tokenServices(){
//        DefaultTokenServices services = new DefaultTokenServices();
//        services.setClientDetailsService(clientDetailsService); // 客户端的配置信息
//        services.setSupportRefreshToken(true); // 支持刷新token
//        services.setTokenStore(tokenStore); // 关联存储方式
//        services.setAccessTokenValiditySeconds(7200); // 令牌默认的有效期2小时
//        services.setRefreshTokenValiditySeconds(259200); // 刷新令牌默认的有效期3天
//        return services;
//    }

    @Bean
    public AuthorizationCodeServices authorizationCodeServices(){
        return new InMemoryAuthorizationCodeServices();
    }


//    @Bean
//    public TokenStore tokenStore() throws Exception {
//
//        TokenStore store = new JwtTokenStore(jwtAccessTokenConverter());;
//
//        return store;
//    }
//
//
//
//    @Bean
//    public JwtAccessTokenConverter jwtAccessTokenConverter() {
//        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
//
//        converter.setSigningKey("21312313131");
//
//        return converter;
//    }



}
