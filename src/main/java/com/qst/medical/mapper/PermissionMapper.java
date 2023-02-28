package com.qst.medical.mapper;

import com.qst.medical.model.PermissionModel;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PermissionMapper {

    List<PermissionModel> getPermission(String roleName);

}