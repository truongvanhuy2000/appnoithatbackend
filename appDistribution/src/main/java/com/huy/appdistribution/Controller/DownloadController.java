package com.huy.appdistribution.Controller;

import com.huy.appdistribution.Entity.FileRecord;
import com.huy.appdistribution.Service.DownloadService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api/download")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class DownloadController {
    private final DownloadService downloadService;
    @GetMapping("/{id}")
    public void download(@PathVariable(value = "id") int id, HttpServletResponse response) throws IOException {
        FileRecord fileRecord = downloadService.download(id, response.getOutputStream());
        response.setContentType(fileRecord.getFileType());
        response.setHeader("Content-Disposition", "attachment; filename=\"" + fileRecord.getFileName() + "\"");
    }
}
