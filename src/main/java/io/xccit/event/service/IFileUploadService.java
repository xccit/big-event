package io.xccit.event.service;

import io.xccit.event.config.AliyunIOssProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author CH_ywx
 * @version 1.0
 * @create 2024/8/5
 * <p>文件上传</p>
 */
public interface IFileUploadService {

    /**
     * 文件上传
     * @param file
     * @return
     */
    String upload(MultipartFile file);
}
