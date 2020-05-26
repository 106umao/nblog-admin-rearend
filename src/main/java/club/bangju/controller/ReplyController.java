package club.bangju.controller;


import club.bangju.pojo.DO.ReplyDO;
import club.bangju.pojo.DTO.ResponseDTO;
import club.bangju.service.IReplyService;
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
public class ReplyController {
    Logger logger = LoggerFactory.getLogger(ReplyController.class);
    @Autowired
    IReplyService replyService;
    @Secured({ROLE_SUPER_ADMIN, ROLE_RESOURCE_ADMIN, ROLE_REPLY_ADMIN})
    @GetMapping("/reply")
    public ResponseDTO listReply() {
        return replyService.listReply();
    }

    @Secured({ROLE_SUPER_ADMIN, ROLE_RESOURCE_ADMIN, ROLE_REPLY_ADMIN})
    @PutMapping("/reply")
    public ResponseDTO addReply(@RequestBody ReplyDO replyDO) {
        return replyService.addReply(replyDO);
    }

    @Secured({ROLE_SUPER_ADMIN, ROLE_RESOURCE_ADMIN, ROLE_REPLY_ADMIN})
    @DeleteMapping("/reply")
    public ResponseDTO deleteReply(@RequestBody ReplyDO replyDO) {
        return replyService.deleteReply(replyDO);
    }

    @Secured({ROLE_SUPER_ADMIN, ROLE_RESOURCE_ADMIN, ROLE_REPLY_ADMIN})
    @PostMapping("/reply")
    public ResponseDTO updateReply(@RequestBody ReplyDO replyDO) {
        return replyService.updateReply(replyDO);
    }

}

