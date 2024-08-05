package io.xccit.event.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.xccit.event.resut.AjaxResult;
import io.xccit.event.service.IFileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author CH_ywx
 * @version 1.0
 * @create 2024/8/5
 * <p>文件上传接口</p>
 */
@Tag(name = "文件上传")
@RestController
@RequestMapping(value = "/file")
public class FileUploadController {

    @Autowired
    private IFileUploadService fileUploadService;

    /**
     * 文件上传
     * @param file
     * @return
     */
    @Operation(summary = "文件上传")
    @PostMapping("/upload")
    public AjaxResult upload(MultipartFile file) {
        String url = fileUploadService.upload(file);
        return AjaxResult.success(url);
    }
}
