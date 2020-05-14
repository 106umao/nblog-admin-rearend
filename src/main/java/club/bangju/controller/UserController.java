package club.bangju.controller;

import club.bangju.pojo.DO.UserDO;
import club.bangju.pojo.DTO.PayloadDTO;
import club.bangju.pojo.DTO.ResponseDTO;
import club.bangju.service.IUserService;
import club.bangju.util.JwtUtils;
import club.bangju.util.RsaUtils;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletContext;
import java.security.PublicKey;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    IUserService userService;
    @Secured({"ROLE_USER"})
    @RequestMapping("/info")
    public ResponseDTO userInfo(String token) throws Exception {
        PublicKey publicKey = RsaUtils.getPublicKey();
        PayloadDTO<UserDO> info = JwtUtils.getInfoFromToken(token, publicKey, UserDO.class);
        String username = info.getUserInfo().getUsername();
        return userService.getUserByUsername(username);
    }
}
