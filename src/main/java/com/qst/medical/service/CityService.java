package com.qst.medical.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qst.medical.domain.City;
import com.qst.medical.mapper.CityMapper;
import com.qst.medical.model.CityModel;
import com.qst.medical.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    @Autowired
    private CityMapper cityMapper;

    /**
     * 获取所有城市信息并分页，name不为空则模糊查询,当pn和size为null,则整页查询
     * @param pn
     * @param size
     * @param name
     */
    public PageInfo<CityModel> getCityWithPage(Integer pn, Integer size, String name) {
        if (pn == null && size == null) {
            pn=1;
            size=0;
        }
        PageHelper.startPage(pn, size);
        List<CityModel> list = cityMapper.getAllCity(name);
        PageInfo<CityModel> info = new PageInfo<>(list,5);
        return info;
    }

    /**
     * 根据id查找一个城市
     * @param id
     * @return
     */
    public Msg getCityById(Integer id) {
        City city = cityMapper.getCityById(id);

        if(city == null) {
            return Msg.fail().mess("没有找到");
        }
        return Msg.success().data("city", city);
    }


}
