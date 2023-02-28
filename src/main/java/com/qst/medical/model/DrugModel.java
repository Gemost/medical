package com.qst.medical.model;

import com.qst.medical.domain.Drug;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DrugModel extends Drug {

    private List<SaleModel> drugSales;//销售该药的药店地址（集合类型，有多个）

    private String drugSale;//销售该药的药店地址（字符串类型，有多个）

    @Override
    public String toString() {
        return "DrugModel{" +
                "drugSales=" + drugSales +
                ", drugSale='" + drugSale + '\'' +
                '}';
    }         //省略get/set方法

}