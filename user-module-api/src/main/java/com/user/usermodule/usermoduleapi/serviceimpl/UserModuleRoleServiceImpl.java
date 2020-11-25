package com.user.usermodule.usermoduleapi.serviceimpl;

import com.user.usermodule.usermoduleapi.dto.RoleDto;
import com.user.usermodule.usermoduleapi.entity.RoleTable;
import com.user.usermodule.usermoduleapi.repository.UserModuleRoleRepository;
import com.user.usermodule.usermoduleapi.service.UserModuleRoleService;
import com.user.usermodule.usermoduleapi.service.UserModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserModuleRoleServiceImpl implements UserModuleRoleService {

    @Lazy
    @Autowired
    private UserModuleRoleRepository userModuleRoleRepository;

    public UserModuleRoleServiceImpl(UserModuleRoleRepository userModuleRoleRepository) {
        this.userModuleRoleRepository = userModuleRoleRepository;
    }

    @Transactional
    public RoleTable insertRoleDetails(RoleDto roleDto) {
        RoleTable roleData = new RoleTable();
        roleData.setRole_id(roleDto.getRole_id());
        roleData.setRoleName(roleDto.getRoleName());
        roleData.setRoleDescription(roleDto.getRoleDescription());
        return userModuleRoleRepository.save(roleData);
    }

    public RoleTable getRoleById(int roleId) {
        return userModuleRoleRepository.getOne(roleId);
    }

    public void deleteByUser(int roleId) {
        userModuleRoleRepository.deleteById(roleId);
    }

    public ResponseEntity<RoleTable> updateByRole(int roleId, RoleDto roleDto) throws Exception {
        RoleTable roleData = userModuleRoleRepository.findById(roleId)
                .orElseThrow(() -> new Exception("User not found for this id :: " + roleId));
        roleData.setRole_id(roleId);
        roleData.setRoleName(roleDto.getRoleName());
        roleData.setRoleDescription(roleDto.getRoleDescription());
        final RoleTable roleUpdate = userModuleRoleRepository.save(roleData);
        return ResponseEntity.ok(roleUpdate);
    }

    public List<RoleTable> getAllRecords() {
        return userModuleRoleRepository.findAll();
    }
}
