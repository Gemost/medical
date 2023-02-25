package com.orthopaedicsystem.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * city
 */
@Data
public class City implements Serializable {
    /**
     * 城市编号
     */
    private Long cityId;

    /**
     * 创建时间
     */
    private Date createtime;

    /**
     * 更新时间
     */
    private Date updatetime;

    /**
     * 城市编号
     */
    private Integer cityNumber;

    private static final long serialVersionUID = 1L;
}