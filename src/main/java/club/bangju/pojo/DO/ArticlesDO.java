package club.bangju.pojo.DO;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * VIEW
 * </p>
 *
 * @author OrangeCat
 * @since 2020-05-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ArticlesDO implements Serializable {

    private static final long serialVersionUID=1L;

    private Long userId;

    private Long articleId;

    private String title;

    private String content;

    private Integer views;

    private LocalDateTime createTime;

    /**
     * tag不可重复，若用户输入的标签已存在，则在article_tag表中使tag_id指向已存在的那个id
     */
    private String tagName;

    private Long tagId;

    private String categoryName;

    private Long categoryId;


}
