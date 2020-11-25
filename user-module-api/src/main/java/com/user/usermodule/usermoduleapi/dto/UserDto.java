package com.user.usermodule.usermoduleapi.dto;

import com.user.usermodule.usermoduleapi.entity.UserTable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private int userid;
    private String username;
    private String password;
    private int mobileNumber;
    private int roleId;
    private String createdUser;
    private LocalDateTime createdDate;
    private String lastUpdatedUser;
    private LocalDateTime lastUpdatedDate;

    public static UserTable userDTOtoUser(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }
        UserTable user = new UserTable();
        user.setUserid( userDto.getUserid());
        user.setUsername(userDto.getUsername());
        user.setPassword( userDto.getPassword() );
        user.setMobileNumber( userDto.getMobileNumber());
        user.setRoleId( userDto.getRoleId() );
        user.setCreatedUser(userDto.getCreatedUser());
        user.setCreatedDate(userDto.getCreatedDate());
        user.setLastUpdatedUser(userDto.getLastUpdatedUser());
        user.setLastUpdatedDate(userDto.getLastUpdatedDate());
        return user;
    }

    public static UserDto userToUserDTO(UserTable user) {
        if ( user == null ) {
            return null;
        }
        UserDto userDto = new UserDto();
        userDto.setUserid( user.getUserid());
        userDto.setUsername(user.getUsername());
        userDto.setPassword( user.getPassword() );
        userDto.setMobileNumber( user.getMobileNumber());
        userDto.setRoleId( user.getRoleId());
        userDto.setCreatedUser(user.getCreatedUser());
        userDto.setCreatedDate(user.getCreatedDate());
        userDto.setLastUpdatedUser(user.getLastUpdatedUser());
        userDto.setLastUpdatedDate(user.getLastUpdatedDate());
        return userDto;
    }
}