package com.qst.medical.model;

import com.qst.medical.domain.Account;
import com.qst.medical.handler.security.MyAuthenticationFailHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.List;

public class AccountModel extends Account implements UserDetails {
    private String urealName; //用户真实姓名
    private Collection<? extends GrantedAuthority> authorities; //认证集

    public AccountModel(Long id, String uname, String realname, String role, String pwd, List<GrantedAuthority> auths) {
        super(id, uname, realname, role, pwd);
        urealName = realname;
        this.authorities = auths;
    }

    public AccountModel(Long id, String realname, String uname, String pwd, String phone, String role){
        this.urealName = realname;
        setId(id);
        setRealname(realname);
        setUname(uname);
        setPwd(pwd);
        setPhoneNumber(phone);
        setUtype(role);
    }

    public AccountModel(Long id, String realname, String uname, String pwd, String phone,
                        String role, Date updatetime, Date createtime){
        super(id, realname, uname, pwd, phone, role, updatetime, createtime);
        this.urealName = realname;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return getPwd();
    }

    @Override
    public String getUsername() {
        return getUname();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getUrealName() {
        return urealName;
    }
}