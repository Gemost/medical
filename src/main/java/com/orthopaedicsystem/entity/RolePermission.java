package com.orthopaedicsystem.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * role_permission
 */
@Data
public class RolePermission implements Serializable {
    private Integer id;

    /**
     * 角色id
     */
    private String rolename;

    /**
     * 权限id
     */
    private Integer perId;

    private static final long serialVersionUID = 1L;
}