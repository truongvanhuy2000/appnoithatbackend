package com.huy.appdistribution.Service;

import com.huy.appdistribution.Entity.FileRecord;
import jakarta.servlet.ServletOutputStream;

import java.io.OutputStream;

public interface DownloadService {
    void download(String fileName, OutputStream outputStream);

    FileRecord download(int id, ServletOutputStream outputStream);
}
