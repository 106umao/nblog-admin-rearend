package club.bangju.service;

import club.bangju.pojo.DO.CategoryDO;
import club.bangju.pojo.DTO.ResponseDTO;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author OrangeCat
 * @since 2020-05-09
 */
public interface ICategoryService extends IService<CategoryDO> {

    ResponseDTO listCategory();

    ResponseDTO addCategory(CategoryDO categoryDO);

    ResponseDTO deleteCategory(CategoryDO categoryDO);

    ResponseDTO updateCategory(CategoryDO categoryDO);
}
