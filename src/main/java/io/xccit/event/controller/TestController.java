package io.xccit.event.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.xccit.event.entity.Article;
import io.xccit.event.resut.AjaxResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * @author CH_ywx
 * @version 1.0
 * @create 2024/8/9
 * <p>测试控制器</p>
 */
@Tag(name = "测试控制器")
@RestController
@RequestMapping("/test")
@CrossOrigin
public class TestController {
    private ArrayList<Article> articles = new ArrayList<>();

    {
        articles.add(new Article(1,"测试标题1","测试内容1","测试封面","已发布",1,null, LocalDateTime.now(),null));
        articles.add(new Article(2,"测试标题2","测试内容2","测试封面","已发布",1,null, LocalDateTime.now(),null));
        articles.add(new Article(3,"测试标题3","测试内容3","测试封面","已发布",1,null, LocalDateTime.now(),null));
        articles.add(new Article(4,"测试标题4","测试内容4","测试封面","已发布",1,null, LocalDateTime.now(),null));
    }

    @Operation(summary = "测试获取文章列表")
    @GetMapping("/article")
    public AjaxResult list(){
        return AjaxResult.success(articles);
    }
}
