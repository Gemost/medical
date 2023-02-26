package com.qst.medical.param;

import com.qst.medical.domain.Doctor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DoctorParam extends Doctor {
    private String pwd;//新增医师的密码
    //省略get/set方法
}