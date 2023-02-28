package com.qst.medical.model;

import com.qst.medical.domain.Doctor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DoctorModel extends Doctor {
    private String treatType;//诊治类型
    private String doctorLevel;//医师级别
    //省略get/set方法
}