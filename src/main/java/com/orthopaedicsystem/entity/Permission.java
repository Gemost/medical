package com.orthopaedicsystem.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * permission
 */
@Data
public class Permission implements Serializable {
    /**
     * 权限id
     */
    private Integer id;

    /**
     * 父id
     */
    private Integer pid;

    /**
     * 菜单名
     */
    private String name;

    /**
     * 路径
     */
    private String path;

    /**
     * 组件
     */
    private String component;

    /**
     * 菜单级别
     */
    private Integer level;

    private String title;

    private static final long serialVersionUID = 1L;
}