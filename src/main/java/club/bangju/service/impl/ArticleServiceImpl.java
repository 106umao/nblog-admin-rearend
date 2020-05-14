package club.bangju.service.impl;

import club.bangju.dao.ArticleMapper;
import club.bangju.dao.ArticleMapper;
import club.bangju.pojo.DO.ArticleDO;
import club.bangju.pojo.DO.ArticleDO;
import club.bangju.pojo.DTO.ResponseDTO;
import club.bangju.service.IArticleService;
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
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, ArticleDO> implements IArticleService {
    @Autowired
    ArticleMapper articleMapper;
    Logger logger = LoggerFactory.getLogger(ArticleServiceImpl.class);

    @Override
    public ResponseDTO updateArticle(ArticleDO articleDO) {

        int i = articleMapper.updateById(articleDO);
        return i == 0 ? ResponseDTO.failed() : ResponseDTO.ok();
    }

    @Override
    public ResponseDTO deleteArticle(ArticleDO articleDO) {
        int i = articleMapper.deleteById(articleDO);
        return i == 0 ? ResponseDTO.failed() : ResponseDTO.ok();
    }

    @Override
    public ResponseDTO addArticle(ArticleDO articleDO) {
        int i = articleMapper.insert(articleDO);
        return i == 0 ? ResponseDTO.failed() : ResponseDTO.ok();
    }

    @Override
    public ResponseDTO listArticle() {
        List<ArticleDO> list = articleMapper.selectByMap(new HashMap<>());
        return ResponseDTO.ok(list);
    }
}
