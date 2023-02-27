package com.qst.medical.controller;

import com.github.pagehelper.PageInfo;
import com.qst.medical.domain.DrugCompany;
import com.qst.medical.service.CompanyService;
import com.qst.medical.util.Msg;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "医药公司信息控制器")
@RestController

@RequestMapping("/api/companys")
@CrossOrigin
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    /**
     * 医药公司信息的分页查询,name不为空则模糊查询
     * @param pn 页码
     * @param size 每页显示的记录数
     * @param name 模糊查询的字段
     * @return 返回分页信息
     */
    @GetMapping(value = {"/{pn}/{size}",""})
    public Msg getCompanyWithPage(@PathVariable(value = "pn",required = false) Integer pn,
                                  @PathVariable(value = "size",required = false) Integer size,
                                  @RequestParam(required = false) String name) {
        PageInfo<DrugCompany> info = companyService.getCompanyWithPage(pn, size, name);
        if (info != null) {
            return Msg.success().data("pageInfo",info);
        }
        return Msg.fail();
    }

    /**
     * 根据id查询一个医药公司信息
     * @param id 公司id
     * @return 返回一个Msg对象，包含一个DrugCompany对象
     */
    @GetMapping("{id}")
    public Msg getCompanyById(@PathVariable("id") Integer id) {
        Msg msg = companyService.getCompanyById(id);
        return msg;
    }

}