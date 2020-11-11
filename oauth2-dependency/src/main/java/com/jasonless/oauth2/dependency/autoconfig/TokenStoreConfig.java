package com.jasonless.oauth2.dependency.autoconfig;

import com.jasonless.oauth2.dependency.properties.Oauth2Properties;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

import javax.sql.DataSource;

/**
 * @author LiuShiZeng
 */
@Configuration
public class TokenStoreConfig {

    @Autowired(required = false)
    private Oauth2Properties oauth2Properties;

    @Autowired(required = false)
    private DataSource dataSource;

    @Autowired(required = false)
    private RedisConnectionFactory factory;


    @Bean
    public TokenStore tokenStore() throws Exception {

        TokenStore store = null;

        switch (oauth2Properties.getTokenStoreType()) {
            case jwt:
                store = new JwtTokenStore(jwtAccessTokenConverter());
                break;
            case redis:
                if (factory == null) {
                    throw new BeanCreationException("配置Redis存储Token需要redisConnectionFactory bean，未找到");
                }
                store = new RedisTokenStore(factory);
                break;
            case jdbc:

                if(dataSource==null){
                    throw new BeanCreationException("配置jdbc存储Token需要dataSource bean，未找到");
                }
                store=new JdbcTokenStore(dataSource);
                break;
            default:
                store = new InMemoryTokenStore();
        }

        return store;
    }



    @Bean
    @Primary
    public JwtAccessTokenConverter jwtAccessTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();

        converter.setSigningKey(oauth2Properties.getTokenSigningKey());

        return converter;
    }

}
