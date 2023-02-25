package com.qst.medical.domain.superdomain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

public class SuperDomain implements Serializable {
    private Long total; //总记录数

    @JsonIgnore
    private Integer pn = 1; //当前页

    @JsonIgnore
    private Integer size = Integer.MAX_VALUE; //每页大小

    @JsonIgnore
    private String keyword;//查询关键字

    public SuperDomain() {
    }

    public Integer getPn() {
        return pn;
    }

    public void setPn(Integer pn) {
        this.pn = pn;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}