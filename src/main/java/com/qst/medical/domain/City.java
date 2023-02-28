package com.qst.medical.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class City {
    private Long cityId;//城市id
    private Integer cityNumber;//城市编号
    private Date createtime;//创建时间
    private Date updatetime;//修改时间
}
