package com.orthopaedicsystem.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class City {
    Integer city_id;

    Date creattime;
    Date updatetime;
    Integer city_numb;

}
