package club.bangju.service.impl;

import club.bangju.dao.ReplyMapper;
import club.bangju.dao.ReplyMapper;
import club.bangju.pojo.DO.ReplyDO;
import club.bangju.pojo.DO.ReplyDO;
import club.bangju.pojo.DTO.ResponseDTO;
import club.bangju.service.IReplyService;
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
public class ReplyServiceImpl extends ServiceImpl<ReplyMapper, ReplyDO> implements IReplyService {
    @Autowired
    ReplyMapper replyMapper;
    Logger logger = LoggerFactory.getLogger(ReplyMapper.class);

    @Override
    public ResponseDTO updateReply(ReplyDO replyDO) {
        int i = replyMapper.updateById(replyDO);
        return i == 0 ? ResponseDTO.failed() : ResponseDTO.ok();
    }

    @Override
    public ResponseDTO deleteReply(ReplyDO replyDO) {
        int i = replyMapper.deleteById(replyDO);
        return i == 0 ? ResponseDTO.failed() : ResponseDTO.ok();
    }

    @Override
    public ResponseDTO addReply(ReplyDO replyDO) {
        int i = replyMapper.insert(replyDO);
        return i == 0 ? ResponseDTO.failed() : ResponseDTO.ok();
    }

    @Override
    public ResponseDTO listReply() {
        List<ReplyDO> list = replyMapper.selectByMap(new HashMap<>());
        return ResponseDTO.ok(list);
    }
}
