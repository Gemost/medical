package com.qst.medical.entity;

import com.qst.medical.domain.City;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CityEntity extends City {
    private Long total;
}
