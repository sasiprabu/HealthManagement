package com.user.usermodule.usermoduleapi.controller;

import com.user.usermodule.usermoduleapi.dto.RoleDto;
import com.user.usermodule.usermoduleapi.dto.UserDto;
import com.user.usermodule.usermoduleapi.entity.RoleTable;
import com.user.usermodule.usermoduleapi.entity.UserTable;
import com.user.usermodule.usermoduleapi.service.UserModuleAuthenticationService;
import com.user.usermodule.usermoduleapi.service.UserModuleService;
import com.user.usermodule.usermoduleapi.serviceimpl.UserModuleServiceImpl;
import com.user.usermodule.usermoduleapi.util.AuthenticationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * User details implementations
 * @author – Sasiprabu
 */
@RestController
@RequestMapping("/users")
public class UserModuleController {

    private UserModuleService userModuleService;
    private AuthenticationUtil authenticationUtil;
    private final AuthenticationManager authenticationManager;
    private UserModuleAuthenticationService userModuleAuthenticationService;

    @Lazy
    @Autowired
    public UserModuleController(UserModuleService userModuleService, AuthenticationUtil authenticationUtil,
                                AuthenticationManager authenticationManager, UserModuleAuthenticationService userModuleAuthenticationService){
        this.userModuleService = userModuleService;
        this.authenticationUtil = authenticationUtil;
        this.authenticationManager = authenticationManager;
        this.userModuleAuthenticationService = userModuleAuthenticationService;
    }

    /**
     * Generate Token and Authenticate
     * @param authRequest :- Getting username and password from authRequest
     * @return username and password to UserModuleService
     *  */
    @PostMapping("/userAuthentication")
    public String generateToken(@RequestBody UserDto authRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(),authRequest.getPassword()));
        } catch (Exception e) {
            throw new Exception("Username/Password is not Valid");
        }
        return userModuleAuthenticationService.authenticationCheck(authRequest.getUsername(), authRequest.getPassword());
    }

    /**
     * Register a new user for respective roles
     * @Param   Identification for a new user
     * @return  the user data,if not found return a null
     * */
    @PostMapping("/")
    public UserTable insertUserDetails(@RequestBody UserDto userDto){
        return userModuleService.insertUserDetails(userDto);
    }

    /**
     * Get all user details
     * */
    @GetMapping("/")
    public List<UserDto> getUserDetails() {
        List<UserTable> users = userModuleService.findAll();
        return users.stream().map(UserDto::userToUserDTO).collect(Collectors.toList());
    }

    /**
     * Update the user records
     * @Param  userDto,userid
     * @return userid,userDto
     * */
    @PutMapping("/{userid}")
    public ResponseEntity<UserTable> updateByUser(@PathVariable int userid,
                                                  @RequestBody UserDto userDto) throws Exception{
        return userModuleService.updateByUser(userid,userDto);
    }

    /**
     * Get the username based on username
     * @param  username
     * @return username
     * */
    @GetMapping("/user-name/{username}")
    public UserTable getUserDetails(@PathVariable String username) {
        return userModuleService.findByUsername(username);
    }

    /**
     * Get the user details based on roleId
     * @param roleId
     * @return roleId
     * */
    @GetMapping("/role-by/{roleId}")
    public List<UserTable> getRoleDetails(@PathVariable int roleId) {
        return userModuleService.findByRoleId(roleId);
    }

    @GetMapping("/{username}")
    public List<UserTable> getUserList(@PathVariable String username){
        return userModuleService.getUserList(username);
    }
}
