package com.user.usermodule.usermoduleapi.service;

import com.user.usermodule.usermoduleapi.dto.RoleDto;
import com.user.usermodule.usermoduleapi.dto.UserDto;
import com.user.usermodule.usermoduleapi.entity.RoleTable;
import com.user.usermodule.usermoduleapi.entity.UserTable;
import com.user.usermodule.usermoduleapi.repository.UserModuleRepository;
import com.user.usermodule.usermoduleapi.serviceimpl.UserModuleServiceImpl;
//import com.user.usermodule.usermoduleapi.util.AuthenticationUtil;
import com.user.usermodule.usermoduleapi.util.AuthenticationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public interface UserModuleService {

    public UserTable insertUserDetails(UserDto userDto);

    public List<UserTable> findAll();

    public UserTable findByUsername(String username);

    public List<UserTable> findByRoleId(int roleId);

    public ResponseEntity<UserTable> updateByUser(int userid, UserDto userDto) throws Exception;

    public List<UserTable> getUserList(String username);
}
