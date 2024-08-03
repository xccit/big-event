package io.xccit.event.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.xccit.event.resut.AjaxResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @Operation(summary = "文章列表")
    @GetMapping
    public AjaxResult list(){
        return AjaxResult.success("文章数据");
    }
}
