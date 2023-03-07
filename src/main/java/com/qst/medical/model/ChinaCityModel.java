package com.qst.medical.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChinaCityModel {
    private String label;
    private Integer value;
    private List<ChinaCityModel> children;
}
