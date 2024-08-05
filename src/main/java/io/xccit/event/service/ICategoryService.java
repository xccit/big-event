package io.xccit.event.service;

import io.xccit.event.entity.Category;

import java.util.List;

/**
 * @author CH_ywx
 * @version 1.0
 * @create 2024/8/2
 * <p>分类Service</p>
 */
public interface ICategoryService {

    /**
     * 插入分类
     * @param category
     */
    void insert(Category category);

    /**
     * 查询所有分类
     * @return
     */
    List<Category> list();

    /**
     * 查询分类详情
     * @param id
     * @return
     */
    Category selectById(Integer id);

    /**
     * 修改分类
     * @param category
     */
    void update(Category category);

    /**
     * 删除分类
     * @param id
     */
    void delete(Integer id);
}
