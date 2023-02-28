package com.qst.medical.model;

import com.qst.medical.domain.City;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CityModel extends City {
    private String province;//省份
    private String city;//市
}
