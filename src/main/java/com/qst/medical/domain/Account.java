package com.qst.medical.domain;

import com.qst.medical.domain.superdomain.SuperDomain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account extends SuperDomain {
    private Long id;
    private String uname;
    private String realname; //真实姓名
    private String pwd;
    private String phoneNumber;
    private String utype;   //取值：ROLE_1：管理员、ROLE_2：医生、ROLE_3：患者
    private Date updatetime;
    private Date createtime;

    public Account(Long id, String uname, String realname, String role, String pwd){
        this.id = id;
        this.uname = uname;
        this.realname = realname;
        this.utype = role;
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", uname='" + uname + '\'' +
                ", pwd='" + pwd + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", utype='" + utype + '\'' +
                ", updatetime=" + updatetime +
                ", createtime=" + createtime +
                ", realname='" + realname + '\'' +
                '}';
    }
}