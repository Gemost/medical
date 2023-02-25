package com.orthopaedicsystem.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * medical_policy
 */
@Data
public class MedicalPolicy implements Serializable {
    /**
     * 医保政策信息表id
     */
    private Long id;

    /**
     * 政策标题
     */
    private String title;

    /**
     * 简介
     */
    private String message;

    /**
     * 所属城市id
     */
    private Long cityId;

    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 更新时间
     */
    private String updateTime;

    private static final long serialVersionUID = 1L;
}