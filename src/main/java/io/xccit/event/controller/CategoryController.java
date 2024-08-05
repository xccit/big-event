package io.xccit.event.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.xccit.event.entity.Category;
import io.xccit.event.resut.AjaxHttpStatus;
import io.xccit.event.resut.AjaxResult;
import io.xccit.event.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author CH_ywx
 * @version 1.0
 * @create 2024/8/2
 * <p>分类控制器</p>
 */
@Tag(name = "分类信息", description = "分类信息")
@RestController
@RequestMapping(value = "/category")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    /**
     * 查询所有分类
     * @return
     */
    @Operation(summary = "查询所有分类")
    @GetMapping
    public AjaxResult<List<Category>> list(){
        List<Category> categoryList =categoryService.list();
        return AjaxResult.success(categoryList);
    }

    /**
     * 查询分类详情
     * @param id
     * @return
     */
    @Operation(summary = "查询分类详情")
    @Parameters({
            @Parameter(name = "id",description = "分类ID",required = true,in = ParameterIn.QUERY)
    })
    @GetMapping(value = "/detail")
    public AjaxResult<Category> selectById(Integer id){
        Category category = categoryService.selectById(id);
        return AjaxResult.success(category);
    }

    /**
     * 添加分类
     * @param category
     * @return
     */
    @Operation(summary = "添加分类")
    @PostMapping()
    public AjaxResult insert(@RequestBody @Validated(Category.Insert.class) Category category) {
        categoryService.insert(category);
        return AjaxResult.success(AjaxHttpStatus.SUCCESS);
    }

    /**
     * 修改分类
     * @param category
     * @return
     */
    @Operation(summary = "修改分类")
    @PutMapping
    public AjaxResult update(@RequestBody @Validated(Category.Update.class) Category category) {
        categoryService.update(category);
        return AjaxResult.success(AjaxHttpStatus.SUCCESS);
    }
}
