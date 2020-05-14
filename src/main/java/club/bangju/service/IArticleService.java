package club.bangju.service;

import club.bangju.pojo.DO.ArticleDO;
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
public interface IArticleService extends IService<ArticleDO> {


    ResponseDTO listArticle();

    ResponseDTO addArticle(ArticleDO articleDO);

    ResponseDTO updateArticle(ArticleDO articleDO);

    ResponseDTO deleteArticle(ArticleDO articleDO);
}
