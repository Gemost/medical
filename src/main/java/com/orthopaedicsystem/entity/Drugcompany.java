package com.orthopaedicsystem.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * drugcompany
 */
@Data
public class Drugcompany implements Serializable {
    /**
     * 药品公司信息表id
     */
    private Long companyId;

    /**
     * 公司名
     */
    private String companyName;

    /**
     * 公司电话
     */
    private String companyPhone;

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