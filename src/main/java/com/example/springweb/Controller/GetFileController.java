package com.example.springweb.Controller;

import com.example.springweb.Service.IAttachmentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.websocket.server.PathParam;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

@Controller
@RequestMapping(value = {"/Uploads"})
public class GetFileController {

    @Autowired
    IAttachmentService iAttachmentService;
    @GetMapping(value = {"/{name}"})

    public  ResponseEntity<byte[]> getImageAsByteArray(@PathVariable String name) throws IOException {
        var imgFile = iAttachmentService.load(name);
        byte[] bytes = StreamUtils.copyToByteArray(imgFile.getInputStream());
        return ResponseEntity
                .ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(bytes);
    }

}
