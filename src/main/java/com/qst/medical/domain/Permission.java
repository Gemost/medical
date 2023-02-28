package com.qst.medical.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.qst.medical.domain.superdomain.SuperDomain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor


public class Permission extends SuperDomain {
    @JsonIgnore
    private Integer id;//菜单id
    @JsonIgnore
    private Integer pid;//菜单父id
    private String path;//菜单路径
    private String name;//菜单name
    private String component;//菜单组件
    @JsonIgnore
    private Integer level;//菜单级别
    private List<Permission> children;//子菜单

}