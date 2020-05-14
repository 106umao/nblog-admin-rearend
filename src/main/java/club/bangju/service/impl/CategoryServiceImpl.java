package club.bangju.service.impl;

import club.bangju.dao.CategoryMapper;
import club.bangju.pojo.DO.CategoryDO;
import club.bangju.service.ICategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
