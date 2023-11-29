package com.huy.appdistribution.Service;

import com.huy.appdistribution.DAO.FileRecordDAO;
import com.huy.appdistribution.Entity.FileRecord;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Paths;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UploadServiceImpl implements UploadService {
    @Value("${file.path}")
    private String filePath;
    private final FileRecordDAO fileRecordDAO;
    @Override
    public void upload(MultipartFile file) {
        try {
            upload(file.getOriginalFilename(), file.getInputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        FileRecord fileRecord = FileRecord.builder().id(0)
                .fileName(file.getOriginalFilename())
                .fileSize(file.getSize())
                .fileType(file.getContentType()).build();
        fileRecordDAO.save(fileRecord);
    }
    private void upload(String fileName, InputStream inputStream) throws IOException {
        String path = Paths.get(filePath, fileName).toString();
        try (OutputStream outputStream = new FileOutputStream(path)) {
            IOUtils.copy(inputStream, outputStream);
        }
    }
}
