package io.xccit.event.mapper;

import io.xccit.event.entity.Article;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author CH_ywx
 * @version 1.0
 * @create 2024/8/2
 * <p>文章mapper</p>
 */
public interface IArticleMapper {

    /**
     * 文章列表
     * @return
     */
    List<Article> list();

    /**
     * 根据id查询文章
     * @param id
     * @return
     */
    Article selectById(Integer id);

    /**
     * 新增文章
     * @param article
     */
    void insert(Article article);

    /**
     * 修改文章
     * @param article
     */
    void update(Article article);

    /**
     * 文章列表
     * @param categoryId
     * @param state
     * @param currentUserId
     * @return
     */
    List<Article> selectList(@Param("categoryId") Integer categoryId, @Param("state") String state, @Param("currentUserId") Integer currentUserId);
}
