package club.bangju.controller;


import club.bangju.pojo.DO.TagDO;
import club.bangju.pojo.DTO.ResponseDTO;
import club.bangju.service.ITagService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import static club.bangju.util.Roles.*;
import static club.bangju.util.Roles.ROLE_COMMENT_ADMIN;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author OrangeCat
 * @since 2020-05-09
 */
@RestController
public class TagController {
    Logger logger = LoggerFactory.getLogger(TagController.class);
    @Autowired
    ITagService tagService;
    @Secured({ROLE_SUPER_ADMIN, ROLE_RESOURCE_ADMIN, ROLE_TAG_ADMIN})
    @GetMapping("/tag")
    public ResponseDTO listTag() {
        return tagService.listTag();
    }

    @Secured({ROLE_SUPER_ADMIN, ROLE_RESOURCE_ADMIN, ROLE_TAG_ADMIN})
    @PutMapping("/tag")
    public ResponseDTO addTag(@RequestBody TagDO tagDO) {
        return tagService.addTag(tagDO);
    }

    @Secured({ROLE_SUPER_ADMIN, ROLE_RESOURCE_ADMIN, ROLE_TAG_ADMIN})
    @DeleteMapping("/tag")
    public ResponseDTO deleteTag(@RequestBody TagDO tagDO) {
        return tagService.deleteTag(tagDO);
    }

    @Secured({ROLE_SUPER_ADMIN, ROLE_RESOURCE_ADMIN, ROLE_TAG_ADMIN})
    @PostMapping("/tag")
    public ResponseDTO updateTag(@RequestBody TagDO tagDO) {
        return tagService.updateTag(tagDO);
    }
}

