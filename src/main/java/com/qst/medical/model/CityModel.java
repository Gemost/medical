package com.qst.medical.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CityModel {
    private String province;//省份
    private String city;//市
    private String cityNumber;
    private String cityId;
}
