package club.bangju.service;


import club.bangju.pojo.DO.CommentDO;
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
public interface ICommentService extends IService<CommentDO> {

    ResponseDTO listComment();

    ResponseDTO addComment(CommentDO commentDO);

    ResponseDTO deleteComment(CommentDO commentDO);

    ResponseDTO updateComment(CommentDO commentDO);
}
