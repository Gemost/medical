package com.qst.medical.param;

import com.qst.medical.domain.Drug;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DrugParam extends Drug {

    private Long[] saleIds;//售卖该药品的药店
    //private String publisher;//发布者


    public Long[] getSaleIds() {
        return saleIds;
    }

    public void setSaleIds(Long[] saleIds) {
        this.saleIds = saleIds;
    }

}