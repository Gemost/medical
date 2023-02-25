package com.orthopaedicsystem.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * china
 */
@Data
public class China implements Serializable {
    private Integer id;

    private String name;

    private Integer parentId;

    private static final long serialVersionUID = 1L;
}