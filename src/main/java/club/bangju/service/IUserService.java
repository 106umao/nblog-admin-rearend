package club.bangju.service;

import club.bangju.pojo.DO.UserDO;
import club.bangju.pojo.DTO.ResponseDTO;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author OrangeCat
 * @since 2020-05-09
 */
public interface IUserService extends IService<UserDO> , UserDetailsService {

    ResponseDTO getUserByUsername(String username);

    ResponseDTO listUser();

    ResponseDTO updateUser(Integer id, Integer delete );

    ResponseDTO deleteUser(UserDO userDO);

    ResponseDTO dispatchRoles(UserDO userDO);
}
