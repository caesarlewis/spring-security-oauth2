package com.jasonless.oauth2.authorization.controller;

import org.springframework.security.oauth2.provider.AuthorizationRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author LiuShiZeng
 */
@Controller
public class Oauth2Controller {

    @RequestMapping("/oauth2/confirm_access")
    public String getAccessConfirmation(Map<String, Object> param, HttpServletRequest request, Model model) throws Exception {

        AuthorizationRequest authorizationRequest = (AuthorizationRequest) param.get("authorizationRequest");
//        if (authorizationRequest==null){
//            return "redirect:"+properties.getLoginPage();
//        }
//        String clientId = authorizationRequest.getClientId();
//        model.addAttribute("scopes",authorizationRequest.getScope());
//        Client client = this.clientService.findClientByClientId(clientId);
//        model.addAttribute("client",client);

        return "oauth2_confirm_access";
    }

}
