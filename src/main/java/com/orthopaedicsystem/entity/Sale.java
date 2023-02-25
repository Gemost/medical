package com.orthopaedicsystem.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * sale
 */
@Data
public class Sale implements Serializable {
    private Long saleId;

    private String saleName;

    private String salePhone;

    private Date createtime;

    private Date updatetime;

    private static final long serialVersionUID = 1L;
}