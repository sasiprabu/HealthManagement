package com.user.usermodule.usermoduleapi.dto;

import com.user.usermodule.usermoduleapi.entity.UserTable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleDto {
    private int role_id;

    private String roleName;

    private String roleDescription;

    private List<UserTable> roleDetails;

    private String createdUser;

    private LocalDateTime createdDate;

    private String lastUpdatedUser;

    private LocalDateTime lastUpdatedDate;
}
