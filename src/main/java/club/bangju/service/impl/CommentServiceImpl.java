package club.bangju.service.impl;

import club.bangju.dao.CommentMapper;
import club.bangju.dao.CommentMapper;
import club.bangju.pojo.DO.CommentDO;
import club.bangju.pojo.DO.CommentDO;
import club.bangju.pojo.DTO.ResponseDTO;
import club.bangju.service.ICommentService;
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
public class CommentServiceImpl extends ServiceImpl<CommentMapper, CommentDO> implements ICommentService {
    @Autowired
    CommentMapper commentMapper;
    Logger logger = LoggerFactory.getLogger(CommentMapper.class);

    @Override
    public ResponseDTO updateComment(CommentDO commentDO) {
        int i = commentMapper.updateById(commentDO);
        return i == 0 ? ResponseDTO.failed() : ResponseDTO.ok();
    }

    @Override
    public ResponseDTO deleteComment(CommentDO commentDO) {
        int i = commentMapper.deleteById(commentDO);
        return i == 0 ? ResponseDTO.failed() : ResponseDTO.ok();
    }

    @Override
    public ResponseDTO addComment(CommentDO commentDO) {
        int i = commentMapper.insert(commentDO);
        return i == 0 ? ResponseDTO.failed() : ResponseDTO.ok();
    }

    @Override
    public ResponseDTO listComment() {
        List<CommentDO> list = commentMapper.selectByMap(new HashMap<>());
        return ResponseDTO.ok(list);
    }
}
