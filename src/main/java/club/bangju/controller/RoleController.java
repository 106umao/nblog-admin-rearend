package club.bangju.controller;


import club.bangju.pojo.DO.RoleDO;
import club.bangju.pojo.DTO.ResponseDTO;
import club.bangju.service.IRoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import static club.bangju.util.Roles.*;
import static club.bangju.util.Roles.ROLE_COMMENT_ADMIN;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author OrangeCat
 * @since 2020-05-09
 */
@RestController
public class RoleController {
    Logger logger = LoggerFactory.getLogger(RoleController.class);
    @Autowired
    IRoleService roleService;
    @Secured({ROLE_SUPER_ADMIN, ROLE_SYSTEM_ADMIN, ROLE_COMMENT_ADMIN})
    @GetMapping("/role")
    public ResponseDTO listRole() {
        return roleService.listRole();
    }

    @Secured({ROLE_SUPER_ADMIN, ROLE_SYSTEM_ADMIN, ROLE_COMMENT_ADMIN})
    @PostMapping("/role")
    public ResponseDTO updateRole(@RequestBody RoleDO roleDO) {
        return roleService.updateRole(roleDO);
    }


//    @Secured({ROLE_SUPER_ADMIN, ROLE_SYSTEM_ADMIN, ROLE_COMMENT_ADMIN})
//    @DeleteMapping("/role")
//    public ResponseDTO deleteRole(@RequestBody RoleDO roleDO) {
//        return roleService.deleteRole(roleDO);
//    }

// Role不可修改
//    @Secured({ROLE_SUPER_ADMIN, ROLE_SYSTEM_ADMIN, ROLE_COMMENT_ADMIN})
//    @PutMapping("/role")
//    public ResponseDTO addRole(@RequestBody RoleDO roleDO) {
//        return roleService.addRole(roleDO);
//    }

}

