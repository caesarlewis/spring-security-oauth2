package com.jasonless.oauth2.authorization.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jasonless.oauth2.authorization.entity.po.ClientDetail;

/**
 * @author LiuShiZeng
 */
public interface ClientDetailService extends IService<ClientDetail> {

    ClientDetail findByClientId(String clientId);

}
