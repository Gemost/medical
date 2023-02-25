package com.orthopaedicsystem.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * material
 */
@Data
public class Material implements Serializable {
    private Integer id;

    private String title;

    private String message;

    private Date createTime;

    private Date updateTime;

    private static final long serialVersionUID = 1L;
}