package com.user.usermodule.usermoduleapi.service;

import com.user.usermodule.usermoduleapi.dto.RoleDto;
import com.user.usermodule.usermoduleapi.entity.RoleTable;
import com.user.usermodule.usermoduleapi.serviceimpl.UserModuleRoleServiceImpl;
import com.user.usermodule.usermoduleapi.serviceimpl.UserModuleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserModuleRoleService {

    public RoleTable insertRoleDetails(RoleDto roleDto);

    public RoleTable getRoleById(int roleId);

    public void deleteByUser(int roleId);

    public ResponseEntity<RoleTable> updateByRole(int roleId, RoleDto roleDto) throws Exception;

    public List<RoleTable> getAllRecords();
}
