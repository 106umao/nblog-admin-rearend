package club.bangju.service.impl;

import club.bangju.dao.RoleMapper;
import club.bangju.dao.UserMapper;
import club.bangju.pojo.DO.RoleDO;
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
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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
    @Autowired
    RoleMapper roleMapper;
    Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        logger.debug("查询email"+email);
        UserDO user = userMapper.findUserByEmailHasRoles(email);
        logger.debug("查询出的用户"+user);
        return user;
    }

    @Override
    @Transactional
    public ResponseDTO updateUser(Integer id, Integer delete) {
        int i = userMapper.updateStatusById(id,delete);
        return i != 0 ? ResponseDTO.ok() : ResponseDTO.failed();
    }

    @Override
    @Transactional()
    public ResponseDTO dispatchRoles(UserDO userDO) {
        List<RoleDO> oldRoles = roleMapper.listRoleByUserId(userDO.getId());
        List<RoleDO> newRoles = userDO.getRoles();
        List<RoleDO> insertRoles = new ArrayList<>();
        List<RoleDO> deleteRoles = new ArrayList<>();
        for (RoleDO newRole : newRoles) {
            if (!oldRoles.contains(newRole)) {
                insertRoles.add(newRole);
            }
        }
        for (RoleDO oldRole : oldRoles) {
            if (!newRoles.contains(oldRole)) {
                deleteRoles.add(oldRole);
            }
        }
        logger.debug("insertRoles:-->" + insertRoles.toString());
        logger.debug("deleteRoles:-->" + deleteRoles.toString());

        if (insertRoles.size() != 0 || deleteRoles.size() != 0) {
            if (insertRoles.size() != 0) {
                Integer integer1 = userMapper.insertUserRoleByUserId(userDO.getId(), insertRoles);
            }
            if (deleteRoles.size() != 0) {
                Integer integer = userMapper.deleteUserRoleByUserId(userDO.getId(),deleteRoles);
            }
        } else {
            return ResponseDTO.failed();
        }
        return ResponseDTO.ok();
    }

    @Override
    public ResponseDTO deleteUser(UserDO userDO) {
        logger.debug("删除了"+userDO);
        return userMapper.deleteById(userDO.getId()) != 0 ? ResponseDTO.ok() : ResponseDTO.failed();
    }

    @Override
    public ResponseDTO listUser() {
        return  ResponseDTO.ok(userMapper.listUser());
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
