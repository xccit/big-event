package io.xccit.event.service.impl;

import io.xccit.event.entity.Category;
import io.xccit.event.mapper.ICategoryMapper;
import io.xccit.event.service.ICategoryService;
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
 * <p>分类Service</p>
 */
@Service
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    private ICategoryMapper categoryMapper;

    /**
     * 获取当前用户
     *
     * @return
     */
    private Map<String,Object> getCurrentUser(){
        Map<String,Object> currentUser = ThreadLocalUserUtil.get();
        return currentUser;
    }

    /**
     * 插入分类
     *
     * @param category
     */
    @Override
    public void insert(Category category) {
        Map<String, Object> currentUser = getCurrentUser();
        category.setCreateTime(LocalDateTime.now());
        category.setUpdateTime(LocalDateTime.now());
        category.setCreateUser((Integer) currentUser.get("id"));
        categoryMapper.insert(category);
    }

    /**
     * 查询所有分类
     *
     * @return
     */
    @Override
    public List<Category> list() {
        Map<String, Object> currentUser = getCurrentUser();
        Integer id = (Integer) currentUser.get("id");
        List<Category> categoryList = categoryMapper.list(id);
        return categoryList;
    }

    /**
     * 查询分类详情
     *
     * @param id
     * @return
     */
    @Override
    public Category selectById(Integer id) {
        return categoryMapper.selectById(id);
    }

    /**
     * 修改分类
     *
     * @param category
     */
    @Override
    public void update(Category category) {
        category.setUpdateTime(LocalDateTime.now());
        category.setCreateUser((Integer) getCurrentUser().get("id"));
        categoryMapper.update(category);
    }
}
