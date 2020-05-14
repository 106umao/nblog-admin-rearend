package club.bangju.service.impl;

import club.bangju.dao.ArticlesMapper;
import club.bangju.pojo.DO.ArticlesDO;
import club.bangju.service.IArticlesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * VIEW 服务实现类
 * </p>
 *
 * @author OrangeCat
 * @since 2020-05-09
 */
@Service
public class ArticlesServiceImpl extends ServiceImpl<ArticlesMapper, ArticlesDO> implements IArticlesService {

}
