package com.huy.appdistribution.Service;

import com.huy.appdistribution.DAO.FileRecordDAO;
import com.huy.appdistribution.Entity.FileRecord;
import jakarta.servlet.ServletOutputStream;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.file.Paths;

@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class DownloadServiceImpl implements DownloadService {
    @Value("${file.path}")
    private String filePath;
    private final FileRecordDAO fileRecordDAO;
    @Override
    public void download(String fileName, OutputStream outputStream) {
        String path = Paths.get(filePath, fileName).toString();
        try (InputStream inputStream = new FileInputStream(path)) {
            IOUtils.copy(inputStream, outputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public FileRecord download(int id, ServletOutputStream outputStream) {
        if (fileRecordDAO.findById(id).isEmpty()) {
            throw new RuntimeException("File not found");
        }
        FileRecord fileRecord = fileRecordDAO.findById(id).get();
        download(fileRecord.getFileName(), outputStream);
        return fileRecord;
    }
}
