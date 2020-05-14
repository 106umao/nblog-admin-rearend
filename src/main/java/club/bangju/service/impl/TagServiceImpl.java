package club.bangju.service.impl;

import club.bangju.dao.TagMapper;
import club.bangju.dao.TagMapper;
import club.bangju.pojo.DO.TagDO;
import club.bangju.pojo.DO.TagDO;
import club.bangju.pojo.DTO.ResponseDTO;
import club.bangju.service.ITagService;
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
public class TagServiceImpl extends ServiceImpl<TagMapper, TagDO> implements ITagService {
    @Autowired
    TagMapper tagMapper;
    Logger logger = LoggerFactory.getLogger(TagMapper.class);

    @Override
    public ResponseDTO updateTag(TagDO tagDO) {
        int i = tagMapper.updateById(tagDO);
        return i == 0 ? ResponseDTO.failed() : ResponseDTO.ok();
    }

    @Override
    public ResponseDTO deleteTag(TagDO tagDO) {
        int i = tagMapper.deleteById(tagDO);
        return i == 0 ? ResponseDTO.failed() : ResponseDTO.ok();
    }

    @Override
    public ResponseDTO addTag(TagDO tagDO) {
        int i = tagMapper.insert(tagDO);
        return i == 0 ? ResponseDTO.failed() : ResponseDTO.ok();
    }

    @Override
    public ResponseDTO listTag() {
        List<TagDO> list = tagMapper.selectByMap(new HashMap<>());
        return ResponseDTO.ok(list);
    }
}
