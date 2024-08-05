package io.xccit.event.utils;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyun.oss.model.PutObjectResult;
import io.xccit.event.config.AliyunIOssProperties;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @author CH_ywx
 * @version 1.0
 * @create 2024/8/5
 * <p>OSS工具类</p>
 */
@Component
public class OSSUtil {

    @Autowired
    private AliyunIOssProperties aliyunIOssProperties;

    public OSS getOSSClient() {
        OSS oss = new OSSClientBuilder().build(
                aliyunIOssProperties.getEndpoint(),
                aliyunIOssProperties.getAccessKeyId(),
                aliyunIOssProperties.getAccessKeySecret()
        );
        return oss;
    }


    /**
     * 上传文件
     * @param file
     * @return
     */
    public  String upload(MultipartFile file) {
        String objectName = file.getOriginalFilename();
        objectName = UUID.randomUUID()+objectName;
        String path = new DateTime().toString("yyyy/MM/dd");
        objectName = path + "/" + objectName;
        OSS ossClient = getOSSClient();
        PutObjectRequest putObjectRequest;
        try {
            putObjectRequest = new PutObjectRequest(aliyunIOssProperties.getBucketName(), objectName, file.getInputStream());
            putObjectRequest.setProcess("true");
            PutObjectResult result = ossClient.putObject(putObjectRequest);
            String uri = result.getResponse().getUri();
            return uri;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (ossClient != null){
                ossClient.shutdown();
            }
        }
    }
}
