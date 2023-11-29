package com.huy.appdistribution.Service;

import org.springframework.web.multipart.MultipartFile;

public interface UploadService {
    void upload(MultipartFile file);
}
