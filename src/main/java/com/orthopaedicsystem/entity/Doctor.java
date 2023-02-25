package com.orthopaedicsystem.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * doctor
 */
@Data
public class Doctor implements Serializable {
    /**
     * id(医生信息表)
     */
    private Long id;

    /**
     * 医生姓名
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 性别：1男，2女
     */
    private Integer sex;

    /**
     * 医师级别id
     */
    private Long levelId;

    /**
     * 联系方式
     */
    private String phone;

    /**
     * 诊治类别id
     */
    private Long typeId;

    /**
     * 所属医院
     */
    private String hospital;

    /**
     * 更新时间
     */
    private Date updatetime;

    /**
     * 创建时间
     */
    private Date createtime;

    /**
     * 账号id
     */
    private Long accountId;

    private static final long serialVersionUID = 1L;
}