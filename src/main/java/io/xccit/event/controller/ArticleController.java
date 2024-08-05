package io.xccit.event.controller;

import com.github.pagehelper.PageInfo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.xccit.event.entity.Article;
import io.xccit.event.page.PageBean;
import io.xccit.event.page.PageUtil;
import io.xccit.event.resut.AjaxHttpStatus;
import io.xccit.event.resut.AjaxResult;
import io.xccit.event.service.IArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author CH_ywx
 * @version 1.0
 * @create 2024/8/2
 * <p>文章控制器</p>
 */
@Tag(name = "文章信息")
@RestController
@RequestMapping(value = "/article")
public class ArticleController {

    @Autowired
    private IArticleService articleService;

    /**
     * 文章列表
     * @return
     */
    @Operation(summary = "文章列表")
    @GetMapping
    public AjaxResult<PageBean<PageInfo<Article>>> list(@RequestParam(value = "pageNum",required = true)Integer pageNum,
                                                        @RequestParam(value = "pageSize",required = true) Integer pageSize,
                                                        @RequestParam(value = "categoryId",required = false) Integer categoryId,
                                                        @RequestParam(value = "state",required = false) String state){
        PageBean<PageInfo<Article>> pageBean =articleService.list(pageNum,pageSize,categoryId,state);
        return AjaxResult.success(pageBean);
    }

    /**
     * 文章详情
     * @param id
     * @return
     */
    @Operation(summary = "文章详情")
    @Parameters({
            @Parameter(name = "id",description = "文章ID",required = true,in = ParameterIn.QUERY)
    })
    @GetMapping(value = "/detail")
    public AjaxResult<Article> detail(Integer id){
        Article article = articleService.selectById(id);
        return AjaxResult.success(article);
    }

    /**
     * 发布文章
     * @param article
     * @return
     */
    @Operation(summary = "发布文章")
    @PostMapping
    public AjaxResult insert(@RequestBody @Validated(Article.Insert.class) Article article){
        articleService.insert(article);
        return AjaxResult.success(AjaxHttpStatus.SUCCESS);
    }

    /**
     * 修改文章
     * @param article
     * @return
     */
    @Operation(summary = "修改文章")
    @PutMapping
    public AjaxResult update(@RequestBody @Validated(Article.Update.class) Article article){
        articleService.update(article);
        return AjaxResult.success(AjaxHttpStatus.SUCCESS);
    }
}
