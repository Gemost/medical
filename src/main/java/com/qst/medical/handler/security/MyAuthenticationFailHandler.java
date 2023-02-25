package com.qst.medical.handler.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qst.medical.util.Msg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class MyAuthenticationFailHandler implements AuthenticationFailureHandler {
    private static Logger logger = LoggerFactory.getLogger(MyAuthenticationFailHandler.class);
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException e) throws IOException, ServletException {
        logger.info("MyAuthenticationFailHandler.request: "+request);
        logger.info("MyAuthenticationFailHandler.response: "+response);
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(new ObjectMapper().writeValueAsString(Msg.fail().mess("用户名或密码错误")));
    }
}