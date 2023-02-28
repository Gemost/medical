package com.qst.medical.model;

import com.qst.medical.domain.MedicalPolicy;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MedicalPolicyModel extends MedicalPolicy {

    private CityModel cityModel;//医保政策包含的所属城市
}