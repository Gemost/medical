package com.orthopaedicsystem.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * drug
 */
@Data
public class Drug implements Serializable {
    /**
     * 药品信息表id
     */
    private Long drugId;

    /**
     * 药名
     */
    private String drugName;

    /**
     * 药品成分信息
     */
    private String drugInfo;

    /**
     * 药品功能
     */
    private String drugEffect;

    /**
     * 药品图片url
     */
    private String drugImg;

    /**
     * 创建时间
     */
    private Date createtime;

    /**
     * 更新时间
     */
    private Date updatetime;

    /**
     * 发布者
     */
    private String publisher;

    private static final long serialVersionUID = 1L;
}