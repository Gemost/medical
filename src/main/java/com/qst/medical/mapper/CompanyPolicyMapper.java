package com.qst.medical.mapper;

import com.qst.medical.model.CompanyPolicyModel;
import com.qst.medical.param.CompanyPolicyParam;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CompanyPolicyMapper {

    /*查询所有的医药公司政策*/
    List<CompanyPolicyModel> getAllPolicy(CompanyPolicyParam param);

}