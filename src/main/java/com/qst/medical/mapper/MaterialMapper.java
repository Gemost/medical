package com.qst.medical.mapper;

import com.qst.medical.entity.MaterialEntity;
import com.qst.medical.model.MaterialModel;
import com.qst.medical.param.MaterialParam;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface MaterialMapper {

    /*查询所有的材料*/
    List<MaterialModel> getAllMaterial(MaterialParam param);

    /*新增材料*/
    int saveMaterial(MaterialEntity entity);

    /*更新材料*/
    int updateMaterial(MaterialEntity entity);

    /*删除材料*/
    int deleteMaterial(Long id);
}