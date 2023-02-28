package com.qst.medical.model;

import com.qst.medical.domain.CompanyPolicy;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyPolicyModel extends CompanyPolicy {

    private DrugCompanyModel drugCompanyModel;

    public DrugCompanyModel getDrugCompanyModel() {
        return drugCompanyModel;
    }

    public void setDrugCompanyModel(DrugCompanyModel drugCompanyModel) {
        this.drugCompanyModel = drugCompanyModel;
    }
}