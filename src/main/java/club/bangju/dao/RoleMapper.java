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
    @Select("SELECT id,name,desc from role where id = #{id}")
    List<RoleDO> findById(Integer Id);
}
