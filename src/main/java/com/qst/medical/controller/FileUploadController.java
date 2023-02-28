package com.qst.medical.controller;

import com.qst.medical.service.FileUploadService;
import com.qst.medical.util.Msg;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.security.RolesAllowed;

@Api(tags = "文件上传控制器")
@RestController

@RequestMapping("/api/base/upload")
@CrossOrigin
public class FileUploadController {

    @Autowired
    private FileUploadService fileUploadService;

    @RolesAllowed({"1","2"})
    @PostMapping(value = "")
    public Msg fileUpload(MultipartFile file) {
        Msg msg = fileUploadService.upload(file);
        return msg;
    }

}