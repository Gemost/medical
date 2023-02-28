package com.qst.medical.controller;

import com.qst.medical.param.CompanyPolicyParam;
import com.qst.medical.service.CompanyPolicyService;
import com.qst.medical.util.Msg;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;


@Api(tags = "医药公司政策控制器类")
@RestController
@RequestMapping("/api/company_policys")
@CrossOrigin
public class CompanyPolicyController {

    @Autowired
    private CompanyPolicyService companyPolicyService;

    /**
     * 分页、关键字查询医药公司政策信息
     * @param param
     * @return
     */
    @GetMapping(value = "")
    public Msg getPolicyWithPage(CompanyPolicyParam param) {
        Msg msg = companyPolicyService.getAllPolicyWithPage(param);
        return msg;
    }
}