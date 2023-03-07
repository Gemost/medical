package com.qst.medical.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ChinaModel {
    private Integer id;
    private String name;
    private Integer parent_id;
}
