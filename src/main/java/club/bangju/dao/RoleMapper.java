package club.bangju.dao;

import club.bangju.pojo.DO.RoleDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author OrangeCat
 * @since 2020-05-09
 */
public interface RoleMapper extends BaseMapper<RoleDO> {
    @Select("SELECT role.id,name,`desc` from role inner join user_role on role.id = user_role.role_id where user_role.user_id = #{userId}")
    List<RoleDO> listRoleByUserId(Integer userId);
}
