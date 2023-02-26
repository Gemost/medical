package com.qst.medical.controller;

import com.qst.medical.param.DoctorParam;
import com.qst.medical.service.DoctorService;
import com.qst.medical.util.Msg;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    }
