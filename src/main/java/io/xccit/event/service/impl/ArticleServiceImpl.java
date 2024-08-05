package io.xccit.event.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.xccit.event.entity.Article;
import io.xccit.event.mapper.IArticleMapper;
import io.xccit.event.page.PageBean;
import io.xccit.event.page.PageUtil;
import io.xccit.event.service.IArticleService;
import io.xccit.event.utils.ThreadLocalUserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * @author CH_ywx
 * @version 1.0
 * @create 2024/8/2
 * <p>文章Service</p>
 */
@Service
public class ArticleServiceImpl implements IArticleService {

    private Map<String,Object> getCurrentUser(){
        Map<String,Object> currentUser = ThreadLocalUserUtil.get();
        return currentUser;
    }

    private Integer getCurrentUserId(){
        return (Integer) getCurrentUser().get("id");
    }

    @Autowired
    private IArticleMapper articleMapper;

    /**
     * 文章详情
     *
     * @param id
     * @return
     */
    @Override
    public Article selectById(Integer id) {
        return articleMapper.selectById(id);
    }

    /**
     * 发布文章
     *
     * @param article
     */
    @Override
    public void insert(Article article) {
        article.setCreateTime(LocalDateTime.now());
        article.setUpdateTime(LocalDateTime.now());
        article.setCreateUser(getCurrentUserId());
        articleMapper.insert(article);
    }

    /**
     * 修改文章
     *
     * @param article
     */
    @Override
    public void update(Article article) {
        article.setUpdateTime(LocalDateTime.now());
        article.setCreateUser(getCurrentUserId());
        articleMapper.update(article);
    }


    /**
     * 文章列表
     * @param pageNum
     * @param pageSize
     * @param categoryId
     * @param state
     * @return
     */
    @Override
    public PageBean<PageInfo<Article>> list(Integer pageNum, Integer pageSize,Integer categoryId,String state) {
        PageBean<PageInfo<Article>> articlePageBean = new PageBean<>();
        PageHelper.startPage(pageNum,pageSize);
        List<Article> articleList =articleMapper.selectList(categoryId,state,getCurrentUserId());
        PageInfo<Article> articlePageInfo = PageInfo.of(articleList);
        articlePageBean.setTotal(articlePageInfo.getTotal());
        articlePageBean.setData(articlePageInfo);
        return articlePageBean;
    }
}
