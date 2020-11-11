package com.jasonless.oauth2.resource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

/**
 * @author LiuShiZeng
 */
@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ResourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ResourceApplication.class,args);
    }

}
