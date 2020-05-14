package club.bangju.controller;


import club.bangju.pojo.DO.ArticleDO;
import club.bangju.pojo.DO.CategoryDO;
import club.bangju.pojo.DTO.ResponseDTO;
import club.bangju.service.IArticleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import static club.bangju.util.Roles.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author OrangeCat
 * @since 2020-05-09
 */
@RestController
public class ArticleController {
    Logger logger = LoggerFactory.getLogger(CategoryController.class);
    @Autowired
    IArticleService articleService;
    @Secured({ROLE_SUPER_ADMIN, ROLE_RESOURCE_ADMIN, ROLE_ARTICLE_ADMIN})
    @GetMapping("/article")
    public ResponseDTO listCategory() {
        return articleService.listArticle();
    }

    @Secured({ROLE_SUPER_ADMIN, ROLE_RESOURCE_ADMIN, ROLE_ARTICLE_ADMIN})
    @PutMapping("/article")
    public ResponseDTO addArticle(@RequestBody ArticleDO articleDO) {
        return articleService.addArticle(articleDO);
    }

    @DeleteMapping("/article")
    @Secured({ROLE_SUPER_ADMIN, ROLE_RESOURCE_ADMIN, ROLE_ARTICLE_ADMIN})
    public ResponseDTO deleteArticle(@RequestBody ArticleDO articleDO) {
        logger.debug(articleDO.toString());
        return articleService.deleteArticle(articleDO);
    }

    @Secured({ROLE_SUPER_ADMIN, ROLE_RESOURCE_ADMIN, ROLE_ARTICLE_ADMIN})
    @PostMapping("/article")
    public ResponseDTO updateArticle(@RequestBody ArticleDO articleDO) {
        return articleService.updateArticle(articleDO);
    }

}

