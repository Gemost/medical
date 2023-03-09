package com.qst.medical.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qst.medical.entity.AccountEntity;
import com.qst.medical.entity.DoctorEntity;
import com.qst.medical.mapper.AccountMapper;
import com.qst.medical.mapper.DoctorMapper;
import com.qst.medical.model.DoctorKindModel;
import com.qst.medical.model.DoctorLevelModel;
import com.qst.medical.model.DoctorModel;
import com.qst.medical.model.TreatTypeModel;
import com.qst.medical.param.DoctorParam;
import com.qst.medical.util.Msg;
import org.joda.time.DateTime;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class DoctorService {
    @Autowired
    private DoctorMapper doctorMapper;

    @Autowired
    private AccountMapper accountMapper;
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


    /**
     * 添加医师，为医师创建账号密码
     * @param param 医师信息
     * @return 返回一个Msg对象
     */
    public Msg saveDoctor(DoctorParam param) {
        int i,j;

        AccountEntity aEntity = new AccountEntity();
        aEntity.setPhoneNumber(param.getPhoneNumber());
        aEntity.setUname(param.getName()+param.getPhoneNumber().substring(7));//医生用户名姓名+手机号后四位
        aEntity.setRealname(param.getName());
        aEntity.setPwd(new BCryptPasswordEncoder().encode(param.getPwd()));
        aEntity.setCreatetime(new DateTime().toDate());
        aEntity.setUpdatetime(new DateTime().toDate());
//        aEntity.setId(param.getAccountId());
        aEntity.setUtype("ROLE_2");
        int checkPhone = accountMapper.checkPhone(param.getPhoneNumber());

        if (checkPhone > 0) {
            return Msg.fail().code(10001).mess("手机号已被使用");
        }

        try {
            i = accountMapper.regist(aEntity);
        } catch (DuplicateKeyException e) {
            return Msg.fail().mess("该账号已经注册");
        }

        DoctorEntity de = new DoctorEntity();
        BeanUtils.copyProperties(param,de);
        de.setCreateTime(new DateTime().toDate());
        de.setUpdateTime(new DateTime().toDate());
        de.setAccountId(aEntity.getId());
        j = doctorMapper.saveDoctor(de);
        Msg ret = null;

        if (i > 0 && j > 0) {
            List<DoctorModel> allDoctor = doctorMapper.getAllDoctor(null);
            de.setTotal((long) allDoctor.size());
            param.setPwd("");
            Long num = de.getTotal() % 5 == 0 ? (de.getTotal() / 5) : (de.getTotal() / 5)+1;
            ret = Msg.success().mess("添加成功").data("pages",num).data("addData",param);
        }else{
            ret = Msg.fail().mess("添加失败");
        }

        return ret;
    }
    /**
     * 修改医师信息
     * @param param 医师信息
     * @return 返回一个Msg对象
     */
    public Msg updateDoctor(Long id, DoctorParam param) {
        int checkPhone = accountMapper.checkPhone(param.getPhoneNumber());
        if (checkPhone > 0) {
            return Msg.fail().code(10001).mess("手机号已被使用");
        }
        AccountEntity ae = new AccountEntity();
        ae.setId(param.getAccountId());
        System.out.println(param.getAccountId());
        ae.setUpdatetime(new DateTime().toDate());
        ae.setUname(param.getName()+param.getPhoneNumber().substring(7));
        ae.setPhoneNumber(param.getPhoneNumber());
        int j = accountMapper.updateAccount(ae);//
        DoctorEntity de = new DoctorEntity();
        BeanUtils.copyProperties(param, de);
        de.setId(id);
        de.setUpdateTime(new DateTime().toDate());
        int i = doctorMapper.updateDoctor(de);
        if (i > 0 && j > 0) {
            param.setPwd("");
            return Msg.success().mess("修改成功").data("updateData", param);
        }
        return Msg.fail().mess("修改失败");
    }

    /**
     * 根据id删除医师并且删除所在账号
     * @param id 医师id
     * @return 返回一个Msg对象
     */
    public Msg deleteDoctorById(Long id) {
        int i = doctorMapper.deleteDoctorById(id);
        if (i >= 2) {
            return Msg.success().mess("删除成功").data("deleteDocInfo",1).data("deleteDocAccount",1);
        }
        return Msg.fail().mess("删除失败");
    }

    /**
     * 重置医师密码
     * @param id 医师id
     * @return  返回一个Msg对象
     */
    public Msg resetPwd(Long id) {
        String newPwd = new BCryptPasswordEncoder().encode("666666");
        int i = accountMapper.resetPwd(id,newPwd);
        if (i > 0) {
            return Msg.success().mess("重置成功");
        }
        return Msg.fail().mess("重置失败");
    }

    public Msg getDoctorKind(){
        List<DoctorModel> l = doctorMapper.getAllDoctor(null);
        HashMap<String, Integer> map = new HashMap<>();
        for (DoctorModel d : l) {
            if (d == null)
                continue;
            String treatType = d.getTreatType();
            if (map.containsKey(treatType)) {
                map.put(treatType,map.get(treatType)+1);
            }else{
                map.put(treatType,1);
            }
        }
        List<DoctorKindModel> ret = new ArrayList<>();
        for (String s : map.keySet()) {
            ret.add(new DoctorKindModel(s,map.get(s)));
        }
        return Msg.success().data("doctorKind",ret);
    }
}
