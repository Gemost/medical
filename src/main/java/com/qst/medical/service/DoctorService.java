package com.qst.medical.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qst.medical.mapper.DoctorMapper;
import com.qst.medical.model.DoctorLevelModel;
import com.qst.medical.model.DoctorModel;
import com.qst.medical.model.TreatTypeModel;
import com.qst.medical.param.DoctorParam;
import com.qst.medical.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.util.List;

@Service
public class DoctorService {
    @Autowired
    private DoctorMapper doctorMapper;
    public Msg getDoctorWithPage(DoctorParam param) {
        if (param.getSize() == 0) {
            param.setSize(1);
        }
        PageHelper.startPage(param.getPn(), param.getSize());
        List<DoctorModel> list = doctorMapper.getAllDoctor(param);
        PageInfo<DoctorModel> info = new PageInfo<>(list,5);
        return Msg.success().data("doctorInfo",info);
    }
    public Msg getLevelAndType() {
        List<TreatTypeModel> allTreatType = doctorMapper.getAllTreatType();
        List<DoctorLevelModel> allLevel = doctorMapper.getAllLevel();
        return Msg.success().data("allTreatType",allTreatType).data("allLevel",allLevel);
    }
}
