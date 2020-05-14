package club.bangju.service.impl;

import club.bangju.dao.CategoryMapper;
import club.bangju.dao.UserMapper;
import club.bangju.pojo.DO.CategoryDO;
import club.bangju.pojo.DTO.ResponseDTO;
import club.bangju.service.ICategoryService;
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
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, CategoryDO> implements ICategoryService {
    @Autowired
    CategoryMapper categoryMapper;
    Logger logger = LoggerFactory.getLogger(CategoryMapper.class);

    @Override
    public ResponseDTO updateCategory(CategoryDO categoryDO) {
        int i = categoryMapper.updateOneById(categoryDO);
        return i == 0 ? ResponseDTO.failed() : ResponseDTO.ok();
    }

    @Override
    public ResponseDTO deleteCategory(CategoryDO categoryDO) {
        int i = categoryMapper.deleteOneById(categoryDO);
        return i == 0 ? ResponseDTO.failed() : ResponseDTO.ok();
    }

    @Override
    public ResponseDTO addCategory(CategoryDO categoryDO) {
        int i = categoryMapper.insertOneById(categoryDO);
        return i == 0 ? ResponseDTO.failed() : ResponseDTO.ok();
    }

    @Override
    public ResponseDTO listCategory() {
        List<CategoryDO> list = categoryMapper.listCategory();
        return ResponseDTO.ok(list);
    }
}
