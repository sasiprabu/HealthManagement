package com.user.usermodule.usermoduleapi.controller;

import com.user.usermodule.usermoduleapi.dto.RoleDto;
import com.user.usermodule.usermoduleapi.entity.RoleTable;
import com.user.usermodule.usermoduleapi.service.UserModuleRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Role details manipulations
 * @author – Sasiprabu
 */
@RestController
@RequestMapping("/roles")
public class UserModuleRoleController {

    private UserModuleRoleService userModuleRoleService;

    @Autowired
    @Lazy
    public UserModuleRoleController(UserModuleRoleService userModuleRoleService) {
        this.userModuleRoleService = userModuleRoleService;
    }

    /**
     * Register a new role for respective users
     * @Param   Identification for a new role
     * @return  the role data,if not found return a null
     * */
    @PostMapping("/")
    public RoleTable insertRoleDetails(@RequestBody RoleDto roleDto){
        return userModuleRoleService.insertRoleDetails(roleDto);
    }

    /**
     * Return a specific role record based on roleId
     * @Param   roleId
     * @return  roleId
     * */
    @GetMapping("/{roleId}")
    public RoleTable getRoleById(@PathVariable int roleId){
        return userModuleRoleService.getRoleById(roleId);
    }

    /**
     * Delete the specific role data based on given role Id
     * @Param  roleId
     * @return roleId
     * */
    @DeleteMapping("/{roleId}")
    public void deleteByUser(@PathVariable int roleId){
        userModuleRoleService.deleteByUser(roleId);
    }

    /**
     * Update the role records
     * @Param  roleId,roleDto
     * @return roleId,roleDto
     * */
    @PutMapping("/{roleId}")
    public ResponseEntity<RoleTable> updateByRole(@PathVariable int roleId,
                                                  @RequestBody RoleDto roleDto) throws Exception{
        return userModuleRoleService.updateByRole(roleId,roleDto);
    }

    /**
     * return the all role records
     * */
    @GetMapping("/listAllRole")
    public List<RoleTable> getAllRecords(){
        return userModuleRoleService.getAllRecords();
    }
}
