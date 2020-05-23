package club.bangju.service.impl;

import club.bangju.dao.RoleMapper;
import club.bangju.dao.RoleMapper;
import club.bangju.pojo.DO.RoleDO;
import club.bangju.pojo.DO.RoleDO;
import club.bangju.pojo.DTO.ResponseDTO;
import club.bangju.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
public class RoleServiceImpl extends ServiceImpl<RoleMapper, RoleDO> implements IRoleService {
    @Autowired
    RoleMapper roleMapper;
    Logger logger = LoggerFactory.getLogger(RoleMapper.class);

    @Override
    public ResponseDTO updateRole(RoleDO roleDO) {
        return roleMapper.disableRole(roleDO) == 0
                ? ResponseDTO.failed()
                : ResponseDTO.ok();
    }

    @Override
    public ResponseDTO deleteRole(RoleDO roleDO) {
        return roleMapper.disableRole(roleDO) == 0
                ? ResponseDTO.failed()
                : ResponseDTO.ok();

    }

    @Override
    public ResponseDTO addRole(RoleDO roleDO) {
        int i = roleMapper.insert(roleDO);
        return i == 0 ? ResponseDTO.failed() : ResponseDTO.ok();
    }

    @Override
    public ResponseDTO listRole() {
        List<RoleDO> list = roleMapper.selectByMap(new HashMap<>());
        return ResponseDTO.ok(list);
    }
}
