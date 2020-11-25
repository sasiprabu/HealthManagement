package com.user.usermodule.usermoduleapi.serviceimpl;

import com.user.usermodule.usermoduleapi.dto.RoleDto;
import com.user.usermodule.usermoduleapi.dto.UserDto;
import com.user.usermodule.usermoduleapi.entity.RoleTable;
import com.user.usermodule.usermoduleapi.entity.UserTable;
import com.user.usermodule.usermoduleapi.repository.UserModuleRepository;
import com.user.usermodule.usermoduleapi.repository.UserModuleRoleRepository;
import com.user.usermodule.usermoduleapi.service.UserModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserModuleServiceImpl implements UserModuleService {

    private final UserModuleRepository userModuleRepository;

    private final UserModuleRoleRepository userModuleRoleRepository;

    @Lazy
    @Autowired
    public UserModuleServiceImpl(UserModuleRepository userModuleRepository, UserModuleRoleRepository userModuleRoleRepository) {
        this.userModuleRepository = userModuleRepository;
        this.userModuleRoleRepository = userModuleRoleRepository;
    }

    public List<UserTable> getRole(String username, String password) {
        return userModuleRepository.getRole(username, password);
    }

    public UserTable insertUserDetails(UserDto userDto) {
        UserTable userDataImpl = UserDto.userDTOtoUser(userDto);
        return userModuleRepository.save(userDataImpl);
    }

    public List<UserTable> findAll() {
        return userModuleRepository.findAll();
    }

    public UserTable findByUsername(String username) {
        return userModuleRepository.findByUsername(username);
    }

    public List<UserTable> findByRoleId(int roleId) {
        return userModuleRepository.findByRoleId(roleId);
    }

    public Optional<UserTable> getPatientVitalSignResponse(int patient_id) {
        return userModuleRepository.findById(patient_id);
    }

    public ResponseEntity<UserTable> updateByUser(int userid, UserDto userDto) throws Exception {
        UserTable userData = userModuleRepository.findById(userid)
                .orElseThrow(() -> new Exception("User not found for this id :: " + userid));
        userData.setUserid(userid);
        userData.setUsername(userDto.getUsername());
        userData.setPassword(userDto.getPassword());
        userData.setMobileNumber(userDto.getMobileNumber());
        final UserTable userUpdate = userModuleRepository.save(userData);
        return ResponseEntity.ok(userUpdate);
    }

    public List<UserTable> getUserList(String username) {
        return userModuleRepository.getUserList(username);
    }
}