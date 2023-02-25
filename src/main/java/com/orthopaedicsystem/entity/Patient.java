package com.orthopaedicsystem.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * patient
 */
@Data
public class Patient implements Serializable {
    /**
     * 患者id
     */
    private Integer id;

    /**
     * 患者年龄
     */
    private Integer age;

    /**
     * 患者姓名
     */
    private String pname;

    /**
     * 入院时间
     */
    private Date enterTime;

    /**
     * 出院时间
     */
    private Date outTime;

    /**
     * 性别：1男，2女
     */
    private Integer sex;

    /**
     * 状态
     */
    private Integer state;

    private static final long serialVersionUID = 1L;
}