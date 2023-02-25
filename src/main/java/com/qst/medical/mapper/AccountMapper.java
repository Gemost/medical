package com.qst.medical.mapper;

import com.qst.medical.model.AccountModel;
import org.springframework.stereotype.Component;

@Component
public interface AccountMapper {
    /*用户登录security*/
    AccountModel securityLogin(String uname);
}