package com.qst.medical.handler.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qst.medical.model.AccountInfoModel;
import com.qst.medical.model.AccountModel;
import com.qst.medical.util.JwtUtils;
import com.qst.medical.util.Msg;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                        Authentication authentication) throws IOException, ServletException {
        httpServletResponse.setContentType("text/json;charset=utf-8");
        AccountModel model = (AccountModel) authentication.getPrincipal();
        String jwtToken = JwtUtils.getJwtToken(model.getId(), model.getUname(), model.getUtype());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        AccountInfoModel info = new AccountInfoModel();
        info.setRealname(model.getUrealName());
        info.setUtype(model.getUtype());
        info.setUtype(info.getUtype().substring("ROLE_".length()));
        httpServletResponse.getWriter().write(new ObjectMapper().writeValueAsString(Msg.success().mess("登陆成功").data("token",jwtToken).data("userInfo", info)));
    }
}