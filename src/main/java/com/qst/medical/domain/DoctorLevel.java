package com.qst.medical.domain;

import com.qst.medical.domain.superdomain.SuperDomain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DoctorLevel extends SuperDomain {
    private Long id;//级别id
    private String name;//级别名称
    //省略get/set方法
}
