package com.qst.medical.controller;

import com.qst.medical.param.DoctorParam;
import com.qst.medical.service.DoctorService;
import com.qst.medical.util.Msg;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;

@Api(tags = "医师控制器类")
@RestController
@RequestMapping("/api/doctors")
@CrossOrigin
public class DoctorController {
        @Autowired
        private DoctorService doctorService;

    @RolesAllowed({"1","2"})
    @GetMapping(value = "")
    public Msg getDoctorWithPage(DoctorParam param) {
        return doctorService.getDoctorWithPage(param);
    }

    @RolesAllowed({"1","2"})
    @GetMapping("/info")
    public Msg getLevelAndType() {
        return doctorService.getLevelAndType();
    }
    /**
     * 新增医师信息
     * @param param
     * @return
     */
    @RolesAllowed({"1","2"})
    @PostMapping(value = "")
    public Msg saveDoctor(@RequestBody @Validated DoctorParam param) {
        return doctorService.saveDoctor(param);
    }


    /**
     * 修改医师信息
     * @param param
     * @return
     */
    @RolesAllowed({"1"})
    @PutMapping("/{id}")
    public Msg updateDoctor(@PathVariable("id") Long id, @RequestBody DoctorParam param) {
        return doctorService.updateDoctor(id, param);
    }

    /**
     * 根据id删除医师信息并且删除其账户
     * @param id
     * @return
     */
    @RolesAllowed({"1"})
    @DeleteMapping("{id}")
    public Msg deleteDoctor(@PathVariable("id") Long id) {

        return doctorService.deleteDoctorById(id);
    }

    /**
     * 重置医师密码
     * @param id
     * @return
     */
    @RolesAllowed({"1"})
    @PutMapping("/reset/{id}")
    public Msg resetPwd(@PathVariable Long id) {
        return doctorService.resetPwd(id);
    }
    }
