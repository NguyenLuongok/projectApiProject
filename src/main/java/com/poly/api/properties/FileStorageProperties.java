package com.poly.api.properties;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
/**
 * @author Tong Duy Hai on 05/24/2020.
 * @created 24/05/2020
 * @project PolyProjectApi
 */
@Component
@Data
@ConfigurationProperties(prefix = "file")
public class FileStorageProperties {
    //    @Value("${file.upload-dir}")
    private String uploadDir;

    public FileStorageProperties() {
    }

    public FileStorageProperties(String uploadDir) {
        this.uploadDir = uploadDir;
    }

    public String getUploadDir() {
        return uploadDir;
    }
}
