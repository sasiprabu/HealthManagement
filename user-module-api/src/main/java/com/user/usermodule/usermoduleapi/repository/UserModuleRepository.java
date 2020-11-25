package com.user.usermodule.usermoduleapi.repository;

import com.user.usermodule.usermoduleapi.entity.RoleTable;
import com.user.usermodule.usermoduleapi.entity.UserTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import java.util.List;

@Repository
public interface UserModuleRepository extends JpaRepository<UserTable,Integer> {

//    List<UserTable> getUserName();

    UserTable findByUsername(String username);

    List<UserTable> findByRoleId(int roleId);

    /* Get User-Info based on UserName and Password */
    @Query("From UserTable where user_name=?1 and password=?2")
    List<UserTable> getRole(@Param("user_name") String user_name, @Param("password") String password);

    @Query("From UserTable where user_name=?1")
    List<UserTable> getUserList(@Param("user_name") String user_name);

//    @NamedQuery("From UserTable where user_name=?1")
//    List<UserTable> getUser(@Param("user_name") String user_name);

//    List<UserTable> findAllOrderedByNameDescending();
}
