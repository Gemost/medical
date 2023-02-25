package com.orthopaedicsystem.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * drug_sale
 */
@Data
public class DrugSale implements Serializable {
    /**
     * 主键id
     */
    private Long id;

    /**
     * 药的名称
     */
    private Long drugId;

    /**
     * 售卖该药的药店的id
     */
    private Long saleId;

    private static final long serialVersionUID = 1L;
}