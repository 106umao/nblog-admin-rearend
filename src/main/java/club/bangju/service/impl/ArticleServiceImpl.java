package club.bangju.service.impl;

import club.bangju.dao.ArticleMapper;
import club.bangju.pojo.DO.ArticleDO;
import club.bangju.service.IArticleService;
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
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, ArticleDO> implements IArticleService {

}
