package com.orthopaedicsystem.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * doctor_level
 */
@Data
public class DoctorLevel implements Serializable {
    private Long id;

    private String name;

    private static final long serialVersionUID = 1L;
}