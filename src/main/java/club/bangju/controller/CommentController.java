package club.bangju.controller;


import club.bangju.pojo.DO.CommentDO;
import club.bangju.pojo.DTO.ResponseDTO;
import club.bangju.service.ICommentService;
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
public class CommentController {
    Logger logger = LoggerFactory.getLogger(CommentController.class);
    @Autowired
    ICommentService commentService;
    @Secured({ROLE_SUPER_ADMIN, ROLE_RESOURCE_ADMIN, ROLE_COMMENT_ADMIN})
    @GetMapping("/comment")
    public ResponseDTO listComment() {
        return commentService.listComment();
    }

    @Secured({ROLE_SUPER_ADMIN, ROLE_RESOURCE_ADMIN, ROLE_COMMENT_ADMIN})
    @PutMapping("/comment")
    public ResponseDTO addComment(@RequestBody CommentDO commentDO) {
        return commentService.addComment(commentDO);
    }

    @Secured({ROLE_SUPER_ADMIN, ROLE_RESOURCE_ADMIN, ROLE_COMMENT_ADMIN})
    @DeleteMapping("/comment")
    public ResponseDTO deleteComment(@RequestBody CommentDO commentDO) {
        return commentService.deleteComment(commentDO);
    }

    @Secured({ROLE_SUPER_ADMIN, ROLE_RESOURCE_ADMIN, ROLE_COMMENT_ADMIN})
    @PostMapping("/comment")
    public ResponseDTO updateComment(@RequestBody CommentDO commentDO) {
        return commentService.updateComment(commentDO);
    }
}

