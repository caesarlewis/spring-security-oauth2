package com.jasonless.oauth2.authorization.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jasonless.oauth2.authorization.entity.po.ClientDetail;
import com.jasonless.oauth2.authorization.mapper.ClientDetailMapper;
import com.jasonless.oauth2.authorization.service.ClientDetailService;
import org.springframework.stereotype.Service;

/**
 * @author LiuShiZeng
 */
@Service
public class ClientDetailServiceImpl extends ServiceImpl<ClientDetailMapper, ClientDetail> implements ClientDetailService {


    @Override
    public ClientDetail findByClientId(String clientId) {
        return this.baseMapper.findByClientId(clientId);
    }
}
