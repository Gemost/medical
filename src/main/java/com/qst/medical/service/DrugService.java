package com.qst.medical.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qst.medical.entity.DrugEntity;
import com.qst.medical.mapper.DrugMapper;
import com.qst.medical.model.DrugModel;
import com.qst.medical.param.DrugParam;
import com.qst.medical.util.Msg;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service

@Transactional
public class DrugService {

    @Autowired
    private DrugMapper drugMapper;

    /**
     * 获取所有药品信息并分页，name不为空则模糊查询
     * @param pn
     * @param size
     * @param name
     */
    public PageInfo<DrugModel> getDrugWithPage(int pn, int size, String name) {
        PageHelper.startPage(pn, size);
        List<DrugModel> list = drugMapper.getAllDrug(name);
        //list.forEach();
        PageInfo<DrugModel> info = new PageInfo<>(list,5);
        return info;
    }
    /**
     * 添加药品的信息
     * @param drugParam
     * @return
     */
    public Msg saveDrug(DrugParam drugParam) {
        drugParam.setCreatetime(new Date());
        drugParam.setUpdatetime(new Date());
//        System.out.println(drugParam);
        int i = drugMapper.saveDrug(drugParam);
        int j = drugMapper.insertSalePlace(drugParam.getDrugId(), drugParam.getSaleIds());
        //由于前端不好判断插入后的总记录数，所以插入之后返回全部的药品数量
        List<DrugModel> allDrug = drugMapper.getAllDrug(null);
        drugParam.setTotal((long) allDrug.size());
        if (i > 0 && j > 0) {
            Long num = drugParam.getTotal() % 5 == 0 ? (drugParam.getTotal() / 5) : (drugParam.getTotal() / 5)+1;
            return Msg.success().data("pages",num).mess("添加成功");
        }
        return Msg.fail().mess("添加失败");
    }

    /**
     * 更新药品信息
     * @param drugParam
     * @return
     */
    public Msg updateDrug(Long id, DrugParam drugParam) {
        drugParam.setUpdatetime(new Date());
        drugParam.setDrugId(id);
        drugMapper.deleteSaleByDrugId(drugParam.getDrugId());
        drugMapper.insertSalePlace(drugParam.getDrugId(),drugParam.getSaleIds());
        DrugEntity drugEntity = new DrugEntity();
//        BeanUtils.copyProperties(drugParam,drugEntity);
        drugEntity.setDrugId(drugParam.getDrugId());
        drugEntity.setCreatetime(drugParam.getCreatetime());
        drugEntity.setUpdatetime(drugParam.getUpdatetime());
        drugEntity.setDrugEffect(drugParam.getDrugEffect());
        drugEntity.setDrugName(drugParam.getDrugName());
        drugEntity.setDrugInfo(drugParam.getDrugInfo());
        drugEntity.setDrugPublisher(drugParam.getDrugPublisher());
        drugEntity.setDrugImg(drugParam.getDrugImg());
        int i = drugMapper.updateDrugById(drugEntity);
        if (i > 0) {
            return Msg.success().mess("修改成功");
        }
        return Msg.fail().mess("修改失败");
    }

    /**
     * 根据id删除药品信息
     * @param drugId
     * @return
     */
    public Msg deleteDrug(Long drugId) {
        int i = drugMapper.deleteDrugById(drugId);
        int j = drugMapper.deleteSaleByDrugId(drugId);
        if (i > 0 && j > 0) {
            return Msg.success().mess("删除成功");
        }
        return Msg.fail().mess("删除失败");
    }



}