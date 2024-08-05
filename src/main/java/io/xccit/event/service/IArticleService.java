package io.xccit.event.service;

import com.github.pagehelper.PageInfo;
import io.xccit.event.entity.Article;
import io.xccit.event.page.PageBean;
import io.xccit.event.page.PageUtil;

import java.util.List;

/**
 * @author CH_ywx
 * @version 1.0
 * @create 2024/8/2
 * <p>文章Service</p>
 */
public interface IArticleService {

    /**
     * 文章详情
     * @param id
     * @return
     */
    Article selectById(Integer id);

    /**
     * 发布文章
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
     * @param pageNum
     * @param pageSize
     * @param categoryId
     * @param state
     * @return
     */
    PageBean<PageInfo<Article>> list(Integer pageNum, Integer pageSize,Integer categoryId,String state);
}
