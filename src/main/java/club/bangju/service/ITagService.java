package club.bangju.service;

import club.bangju.pojo.DO.TagDO;
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
public interface ITagService extends IService<TagDO> {

    ResponseDTO listTag();

    ResponseDTO addTag(TagDO tagDO);

    ResponseDTO deleteTag(TagDO tagDO);

    ResponseDTO updateTag(TagDO tagDO);
}
