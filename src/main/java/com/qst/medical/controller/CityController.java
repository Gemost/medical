package com.qst.medical.controller;

import com.github.pagehelper.PageInfo;
import com.qst.medical.model.CityModel;
import com.qst.medical.service.CityService;
import com.qst.medical.util.Msg;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;

@Api(tags = "城市信息控制器")
@RestController
@RequestMapping("/api/citys")
@CrossOrigin
public class CityController {

    @Autowired
    private CityService cityService;

    /**
     * 城市信息的分页查询,name不为空则模糊查询,路径""为整页查询
     * @param pn
     * @param size
     * @param name
     * @return
     */
    @GetMapping(value = {"/{pn}/{size}",""})
    public Msg getCityWithPage(@PathVariable(value = "pn",required = false) Integer pn,
                               @PathVariable(value = "size",required = false) Integer size,
                               @RequestParam(required = false) String name) {
        PageInfo<CityModel> info = cityService.getCityWithPage(pn, size, name);
        if (info != null) {
            return Msg.success().data("cityPageInfo",info);
        }
        return Msg.fail();
    }


    /**
     * 根据id查询一个城市信息
     * @param id
     * @return
     */
    @GetMapping("{id}")
    public Msg getCityById(@PathVariable("id") Integer id) {
        Msg msg = cityService.getCityById(id);
        return msg;
    }
    /**
     * 新增一个城市信息
     * @return
     */
    @RolesAllowed({"1"})
    @PostMapping(value = "")
    public Msg saveCity(Integer cityNumber) {
        if (cityService.checkCityByName(cityNumber) > 0) {
            return Msg.fail().mess("城市已经存在").code(10004);
        }
        return cityService.saveCity(cityNumber);
    }

    /**
     * 根据id删除城市
     * @param id
     * @return
     */
    @RolesAllowed({"1"})
    @DeleteMapping("{id}")
    public Msg deleteSaleById(@PathVariable("id") Integer id) {
        Msg msg = cityService.deleteCityById(id);
        return msg;
    }

}