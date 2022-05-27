package com.example.springweb.Service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface IAttachmentService {
    public String storeFile(MultipartFile file);

    public void Init();

    public Resource load(String fileName);

}
