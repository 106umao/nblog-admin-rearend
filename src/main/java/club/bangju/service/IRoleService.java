package club.bangju.service;

import club.bangju.pojo.DO.RoleDO;
import club.bangju.pojo.DTO.ResponseDTO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author OrangeCat
 * @since 2020-05-09
 */
public interface IRoleService extends IService<RoleDO> {

    ResponseDTO updateRole(RoleDO roleDO);

    ResponseDTO deleteRole(RoleDO roleDO);

    ResponseDTO addRole(RoleDO roleDO);

    ResponseDTO listRole();
}
