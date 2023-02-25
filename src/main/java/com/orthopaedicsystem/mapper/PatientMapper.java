package com.orthopaedicsystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.orthopaedicsystem.entity.Patient;
import org.apache.tomcat.websocket.BackgroundProcess;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientMapper extends BaseMapper<Patient> {
}
