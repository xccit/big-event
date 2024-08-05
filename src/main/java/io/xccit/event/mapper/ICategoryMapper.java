package io.xccit.event.mapper;

import io.xccit.event.entity.Category;
import org.apache.ibatis.annotations.Delete;

import java.util.List;

/**
 * @author CH_ywx
 * @version 1.0
 * @create 2024/8/2
 * <p>分类mapper</p>
 */
public interface ICategoryMapper {

    /**
     * 插入分类
     * @param category
     */
    void insert(Category category);

    /**
     * 查询当前用户创建的分类
     * @param id
     * @return
     */
    List<Category> list(Integer id);

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
    @Delete("DELETE FROM category WHERE id = #{id}")
    void deleteById(Integer id);
}
