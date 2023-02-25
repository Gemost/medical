package com.orthopaedicsystem.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * treat_type
 */
@Data
public class TreatType implements Serializable {
    /**
     * 诊治类型id
     */
    private Long id;

    /**
     * 诊治类型名
     */
    private String name;

    private static final long serialVersionUID = 1L;
}