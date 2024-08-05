package io.xccit.event.service.impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyun.oss.model.PutObjectResult;
import io.xccit.event.service.IFileUploadService;
import io.xccit.event.utils.OSSUtil;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.UUID;

/**
 * @author CH_ywx
 * @version 1.0
 * @create 2024/8/5
 * <p>文件上传</p>
 */
@Service
public class FileUploadServiceImpl implements IFileUploadService {


    @Value("${aliyun.oss.endpoint}")
    private String endpoint;
    @Value("${aliyun.oss.accessKeyId}")
    private String accessKeyId;
    @Value("${aliyun.oss.accessKeySecret}")
    private String accessKeySecret;
    @Value("${aliyun.oss.bucketName}")
    private String bucketName;

    @Autowired
    private OSSUtil ossUtil;

    /**
     * 图片上传
     * @param file 文件
     * @return 文件url
     */
    @Override
    public String upload(MultipartFile file) {
        return ossUtil.upload(file);
    }
}
