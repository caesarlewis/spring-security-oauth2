package com.jasonless.oauth2.authorization.extension.oauth2;


import com.jasonless.oauth2.authorization.entity.dto.ClientDetailDTO;
import com.jasonless.oauth2.authorization.entity.po.ClientDetail;
import com.jasonless.oauth2.authorization.service.ClientDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.stereotype.Service;

/**
 * @author LiuShiZeng
 */
@Service
public class Oauth2ClientDetailService implements ClientDetailsService {

    @Autowired
    private ClientDetailService clientDetailService;

    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {

        ClientDetail client = this.clientDetailService.findByClientId(clientId);

        if(client==null){
            throw new ClientRegistrationException("客户端不存在");
        }
        ClientDetailDTO clientDetailDTO=new ClientDetailDTO();
        clientDetailDTO.setClientDetail(client);

        return clientDetailDTO;

    }
}
