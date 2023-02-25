package com.orthopaedicsystem.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * company_policy
 */
@Data
public class CompanyPolicy implements Serializable {
    /**
     * 公司政策主键id
     */
    private Long id;

    /**
     * 政策标题
     */
    private String title;

    /**
     * 政策内容
     */
    private String message;

    /**
     * 公司id
     */
    private Long companyId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    private static final long serialVersionUID = 1L;
}