package com.qst.medical.controller;

import com.github.pagehelper.PageInfo;
import com.qst.medical.domain.DrugCompany;
import com.qst.medical.service.CompanyService;
import com.qst.medical.util.Msg;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;

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

    @RolesAllowed({"1"})
    @PostMapping(value = "")
    public Msg saveCompany(@RequestBody DrugCompany company) {
        String name = company.getCompanyName();
        String phone = company.getCompanyPhone();

        if (name == null || phone == null || name.equals("") || phone.equals("")) {
            return Msg.fail().mess("填写信息不完整");
        }
        return companyService.saveCompany(company);
    }

    /**
     * 根据id更新医药公司信息
     * @param company 医药公司信息
     * @return 返回一个Msg对象
     */
    @RolesAllowed({"1"})
    @PutMapping(value = "/{id}")
    public Msg updateCompanyById(@PathVariable("id") Long id, @RequestBody DrugCompany company) {
        String name = company.getCompanyName();
        String phone = company.getCompanyPhone();
        if (name == null || name.equals("")) {
            return Msg.fail().mess("公司名称不能为空");
        }
        if (phone == null || phone.equals("")) {
            return Msg.fail().mess("公司电话不能为空");
        }
        return companyService.updateCompanyById(id, company);
    }

    @RolesAllowed({"1"})
    @DeleteMapping("{id}")
    public Msg deleteCompanyById(@PathVariable("id") Integer id) {
        return companyService.deleteCompanyById(id);
    }
}