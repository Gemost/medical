package com.qst.medical.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qst.medical.mapper.CompanyPolicyMapper;
import com.qst.medical.model.CompanyPolicyModel;
import com.qst.medical.param.CompanyPolicyParam;
import com.qst.medical.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyPolicyService {

    @Autowired
    private CompanyPolicyMapper companyPolicyMapper;

    /**
     * 分页、关键字查询医药公司政策信息
     * @param param
     * @return
     */
    public Msg getAllPolicyWithPage(CompanyPolicyParam param) {
        if (param.getSize() == 0) {
            param.setSize(1);
        }
        PageHelper.startPage(param.getPn(), param.getSize());
        List<CompanyPolicyModel> list = companyPolicyMapper.getAllPolicy(param);
        PageInfo<CompanyPolicyModel> info = new PageInfo<>(list,5);
        return Msg.success().data("policyInfo",info);
    }
}