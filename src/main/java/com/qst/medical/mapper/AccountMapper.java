package com.qst.medical.mapper;

import com.qst.medical.entity.AccountEntity;
import com.qst.medical.model.AccountModel;
import org.springframework.stereotype.Component;

@Component
public interface AccountMapper {
    /*用户登录security*/
    AccountModel securityLogin(String uname);

    /*校验手机号存在*/
    int checkPhone(String phone);

    /*重置密码*/
    int resetPwd(Long id, String pwd);
    /*注册账号*/
    int regist(AccountEntity entity);

    /*更新账户信息*/
    int updateAccount(AccountEntity entity);

    int deleteAccountById(Long id);
}