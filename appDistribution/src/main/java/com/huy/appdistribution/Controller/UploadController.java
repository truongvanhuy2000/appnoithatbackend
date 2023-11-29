package com.huy.appdistribution.Controller;

import com.huy.appdistribution.DTO.Test;
import com.huy.appdistribution.Service.DownloadService;
import com.huy.appdistribution.Service.UploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/upload")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class UploadController {
    private final UploadService uploadService;
    @PostMapping("")
    public void upload(@RequestPart MultipartFile file, @RequestPart(required = false) Test test) {
        uploadService.upload(file);
    }
}
