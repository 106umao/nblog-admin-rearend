package club.bangju.dao;

import club.bangju.pojo.DO.UserDO;
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
public interface UserMapper extends BaseMapper<UserDO> {
    UserDO findUserByUsernameHasRoles(String username);

    UserDO findUserByEmailHasRoles(String email);

    @Select("SELECT id,\n" +
            "       email,\n" +
            "       username,\n" +
            "       `password`,\n" +
            "       `desc`,\n" +
            "       sex,\n" +
            "       age,\n" +
            "       avatar,\n" +
            "       phone,\n" +
            "       ip,\n" +
            "       create_time,\n" +
            "       update_time,\n" +
            "       is_delete `delete`\n" +
            "FROM `user`\n" +
            "WHERE username = #{username}")
    List<UserDO> getUserByUsername(String username);
}
