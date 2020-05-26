package club.bangju.controller;

import club.bangju.pojo.DO.UserDO;
import club.bangju.pojo.DTO.PayloadDTO;
import club.bangju.pojo.DTO.ResponseDTO;
import club.bangju.service.IUserService;
import club.bangju.util.JwtUtils;
import club.bangju.util.Roles;
import club.bangju.util.RsaUtils;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletContext;
import java.security.PublicKey;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static club.bangju.util.Roles.*;

@RestController
public class UserController {
    Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    IUserService userService;
    @Secured({ROLE_USER})
    @GetMapping("/user/info")
    public ResponseDTO userInfo(String token) throws Exception {
        PublicKey publicKey = RsaUtils.getPublicKey();
        PayloadDTO<UserDO> info = JwtUtils.getInfoFromToken(token, publicKey, UserDO.class);
        String username = info.getUserInfo().getUsername();
        return userService.getUserByUsername(username);
    }

    @Secured({ROLE_SUPER_ADMIN,ROLE_USER_ADMIN,ROLE_SYSTEM_ADMIN})
    @GetMapping("/user/all")
    public ResponseDTO listUser() {
        return userService.listUser();
    }

    @Secured({ROLE_SUPER_ADMIN,ROLE_USER_ADMIN,ROLE_SYSTEM_ADMIN})
    @PostMapping("/user/status")
    public ResponseDTO updateUser(@RequestBody HashMap model)  {
        Integer id =  (Integer) model.get("id");
        Integer status = (Integer) model.get("delete");
        logger.debug("update->userid::"+model.get("id"));
        return userService.updateUser(id,status);
    }

    @Secured({ROLE_SUPER_ADMIN,ROLE_USER_ADMIN,ROLE_SYSTEM_ADMIN})
    @PostMapping("/user/dispatchRoles")
    public ResponseDTO dispatchRoles(@RequestBody UserDO userDO)  {
        return userService.dispatchRoles(userDO);
    }

    @Secured({ROLE_SUPER_ADMIN,ROLE_USER_ADMIN,ROLE_SYSTEM_ADMIN})
    @DeleteMapping("/user")
    public ResponseDTO deleteUser(@RequestBody UserDO userDO)  {
        return userService.deleteUser(userDO);
    }


}
