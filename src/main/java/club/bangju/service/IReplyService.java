package club.bangju.service;

import club.bangju.pojo.DO.ReplyDO;
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
public interface IReplyService extends IService<ReplyDO> {

    ResponseDTO listReply();

    ResponseDTO addReply(ReplyDO replyDO);

    ResponseDTO deleteReply(ReplyDO replyDO);

    ResponseDTO updateReply(ReplyDO replyDO);
}
