package club.bangju.service.impl;

import club.bangju.dao.UserMapper;
import club.bangju.pojo.DO.UserDO;
import club.bangju.pojo.DTO.ResponseDTO;
import club.bangju.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;


/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author OrangeCat
 * @since 2020-05-09
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserDO> implements IUserService {
    @Autowired
    UserMapper userMapper;
    Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.debug("查询用户名"+username);
        UserDO user = userMapper.findUserByEmailHasRoles(username);
        logger.debug("查询出的用户"+user);
        return user;
    }

    @Override
    public ResponseDTO getUserByUsername(String username) {
        List<UserDO> res = userMapper.getUserByUsername(username);
        if (res.size() == 0) {
            return ResponseDTO.failed();
        } else {
            return ResponseDTO.ok(res.get(0));
        }
    }
}
