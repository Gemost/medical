package com.qst.medical.entity;

import com.qst.medical.domain.DrugCompany;

public class DrugCompanyEntity extends DrugCompany {

    private Long total;//插入存储返回插入后的总记录数

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

}