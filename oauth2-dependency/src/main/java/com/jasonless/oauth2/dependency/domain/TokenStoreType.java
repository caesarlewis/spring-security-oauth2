package com.jasonless.oauth2.dependency.domain;

/**
 * token store 的存储类型
 * @author LiuShiZeng
 */
public enum TokenStoreType {

    /*
       内存
    */
    memory,
    /*
        redis
     */
    redis,
    /*
        json web token
     */
    jwt,
    /*
        数据库
     */
    jdbc

}
