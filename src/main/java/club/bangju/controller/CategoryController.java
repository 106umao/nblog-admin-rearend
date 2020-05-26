package club.bangju.controller;


import club.bangju.pojo.DO.CategoryDO;
import club.bangju.pojo.DTO.ResponseDTO;
import club.bangju.service.ICategoryService;
import club.bangju.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import static club.bangju.util.Roles.*;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author OrangeCat
 * @since 2020-05-09
 */
@RestController
public class CategoryController {
    Logger logger = LoggerFactory.getLogger(CategoryController.class);
    @Autowired
    ICategoryService categoryService;
    @Secured({ROLE_SUPER_ADMIN, ROLE_RESOURCE_ADMIN, ROLE_CATEGORY_ADMIN})
    @GetMapping("/category")
    public ResponseDTO listCategory() {
        return categoryService.listCategory();
    }

    @Secured({ROLE_SUPER_ADMIN, ROLE_RESOURCE_ADMIN, ROLE_CATEGORY_ADMIN})
    @PutMapping("/category")
    public ResponseDTO addCategory(@RequestBody CategoryDO categoryDO) {
        logger.debug(categoryDO.toString());
        return categoryService.addCategory(categoryDO);
    }

    @Secured({ROLE_SUPER_ADMIN, ROLE_RESOURCE_ADMIN, ROLE_CATEGORY_ADMIN})
    @DeleteMapping("/category")
    public ResponseDTO deleteCategory(@RequestBody CategoryDO categoryDO) {
        return categoryService.deleteCategory(categoryDO);
    }

    @Secured({ROLE_SUPER_ADMIN, ROLE_RESOURCE_ADMIN, ROLE_CATEGORY_ADMIN})
    @PostMapping("/category")
    public ResponseDTO updateCategory(@RequestBody CategoryDO categoryDO) {
        return categoryService.updateCategory(categoryDO);
    }

}

