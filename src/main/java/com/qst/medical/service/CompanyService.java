package com.qst.medical.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qst.medical.domain.DrugCompany;
import com.qst.medical.mapper.CompanyMapper;
import com.qst.medical.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {

    @Autowired
    private CompanyMapper companyMapper;
    /**
     * 获取所有医药公司信息并分页，name不为空则模糊查询
     * @param pn 页码
     * @param size 每页显示的记录数
     * @param name 模糊查询的名字
     */
    public PageInfo<DrugCompany> getCompanyWithPage(Integer pn, Integer size, String name) {
        if (pn ==null && size == null) {
            pn = 1;
            size = Integer.MAX_VALUE;
        }
        if (pn == null) {
            pn = 1;
        }
        if (size == null) {
            size = Integer.MAX_VALUE;
        }
        if (size == 0) {
            size = 1;
        }
        PageHelper.startPage(pn, size);
        List<DrugCompany> list = companyMapper.getAllCompany(name);
        PageInfo<DrugCompany> info = new PageInfo<>(list,5);
        return info;
    }

    /**
     * 根据id查找一个医药公司
     * @param id 公司id
     * @return 返回一个Msg对象，包含一个DrugCompany对象
     */
    public Msg getCompanyById(Integer id) {
        DrugCompany company = companyMapper.getCompanyById(id);

        if(company == null) {
            return Msg.fail().mess("没有找到");
        }
        return Msg.success().data("company", company);
    }
}