package com.orthopaedicsystem.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * account
 */
@Data
public class Account implements Serializable {
    /**
     * id（账号表）
     */
    private Long id;

    /**
     * 姓名
     */
    private String realname;

    /**
     * 用户名
     */
    private String uname;

    /**
     * 密码
     */
    private String pwd;

    /**
     * 电话号码
     */
    private String phonenumber;

    /**
     * 角色类型：1管理员，2医生，3患者
     */
    private String utype;

    /**
     * 更新时间
     */
    private Date updatetime;

    /**
     * 创建时间
     */
    private Date createtime;

    private static final long serialVersionUID = 1L;
}