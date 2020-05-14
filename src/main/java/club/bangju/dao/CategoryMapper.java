package club.bangju.dao;

import club.bangju.pojo.DO.CategoryDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author OrangeCat
 * @since 2020-05-09
 */
public interface CategoryMapper extends BaseMapper<CategoryDO> {
@Update("update category set name = #{name},`desc` = #{desc} ,parent_id = #{parentId},update_time = #{updateTime} where id = #{id}")
    int updateOneById(CategoryDO categoryDO);

    @Delete("delete from category where id = #{id}")
    int deleteOneById(CategoryDO categoryDO);


    @Select("select * from category ")
    List<CategoryDO> listCategory();

    @Insert("insert into category (name,`desc`,parent_id) values(#{name},#{desc},#{parentId})")
    int insertOneById(CategoryDO categoryDO);
}
