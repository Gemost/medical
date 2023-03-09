package com.qst.medical.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qst.medical.domain.City;
import com.qst.medical.entity.CityEntity;
import com.qst.medical.mapper.CityMapper;
import com.qst.medical.mapper.MedicalPolicyMapper;
import com.qst.medical.model.ChinaCityModel;
import com.qst.medical.model.ChinaModel;
import com.qst.medical.model.CityModel;
import com.qst.medical.util.Msg;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class CityService {

    @Autowired
    private CityMapper cityMapper;
    @Autowired
    private MedicalPolicyMapper medicalPolicyMapper;
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

    /**
     * 添加一个城市
     * @param cityNumber
     * @return
     */
    public Msg saveCity(Integer cityNumber) {
        City city = new City();
        Date d = new Date();
        city.setCityNumber(cityNumber);
        city.setCreatetime(d);
        city.setUpdatetime(d);
        CityEntity ce = new CityEntity();
        BeanUtils.copyProperties(city,ce);//对象拷贝
        int i = cityMapper.saveCity(ce);
        if (i > 0) {
            Long num = ce.getTotal() % 5 == 0 ? (ce.getTotal() / 5) : (ce.getTotal() / 5)+1;
            return Msg.success().data("pages",num).mess("添加成功");
        }
        return Msg.fail().mess("添加失败");
    }

    /**
     * 根据id删除城市
     * @param id
     * @return
     */
    public Msg deleteCityById(Integer id) {
        int i = cityMapper.deleteCityById(id);
        medicalPolicyMapper.deleteByCity(id);
        if (i > 0) {
            return Msg.success().mess("删除成功");
        } else {
            return Msg.fail().mess("删除失败");
        }

    }
    /**
     * 检查城市名是否存在
     * @param number
     * @return
     */
    public int checkCityByName(Integer number) {
        return cityMapper.checkCityByName(number);
    }

    public Msg getChinaInfo(){
        List<ChinaModel> list = cityMapper.getChinaInfo();
//        for (ChinaModel chinaModel : list) {
//            System.out.println(chinaModel);
//        }
        HashMap<Integer, ChinaCityModel> map = new HashMap<>();
        for (ChinaModel chinaModel : list) {
            if (chinaModel.getParent_id() == null)
                continue;
            if (chinaModel.getId().equals(0))
                continue;
            if (chinaModel.getParent_id().equals(0)){
                ChinaCityModel cm = new ChinaCityModel();
                cm.setLabel(chinaModel.getName());
                cm.setValue(chinaModel.getId());
                cm.setChildren(new ArrayList<>());
                map.put(chinaModel.getId(), cm);
            }
        }

        for (ChinaModel chinaModel : list) {
            if (chinaModel.getParent_id() == null)
                continue;

            if (!chinaModel.getParent_id().equals(0)){
                ChinaCityModel cm = map.get(chinaModel.getParent_id());
                if (cm == null)
                    continue;

                ChinaCityModel ch = new ChinaCityModel();
                ch.setLabel(chinaModel.getName());
                ch.setValue(chinaModel.getId());

                if (cm.getChildren() == null)
                    cm.setChildren(new ArrayList<>());
                cm.getChildren().add(ch);
            }
        }

        List<ChinaCityModel> ans = new ArrayList<>();
        for (Integer integer : map.keySet()) {
            ans.add(map.get(integer));
        }

        return Msg.success().data("china",ans);
    }
}
