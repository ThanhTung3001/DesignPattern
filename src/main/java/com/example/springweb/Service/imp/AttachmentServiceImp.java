package com.example.springweb.Service.imp;

import com.example.springweb.Service.IAttachmentService;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class AttachmentServiceImp  implements IAttachmentService {
   private final Path root = Paths.get("src/main/resources/static/Uploads");


   @Override
   public String storeFile(MultipartFile file) {
      try {      Date date = new Date();
         SimpleDateFormat formatter = new SimpleDateFormat("dd_MM_yyyy_HH_ss");
         String strDate = formatter.format(date);

         String fileName= strDate+"_"+file.getOriginalFilename();
         Files.copy(file.getInputStream(), this.root.resolve(fileName));
         return "/Uploads/"+fileName;
      } catch (Exception e) {
         throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
      }

   }

   @Override
   public void Init() {
      try{
         Files.createDirectories(root);
      }catch (Exception ex){
         throw new RuntimeException("Could not initialize folder for upload!");
      }
   }

   @Override
   public Resource load(String fileName) {
      try{
         Path file = root.resolve(fileName);
         Resource resource = new UrlResource(file.toUri());
         if (resource.exists() || resource.isReadable()) {
            return resource;
         } else {
            throw new RuntimeException("Could not read the file!");
         }
      }catch (Exception ex){
         throw new RuntimeException("Error: " + ex.getMessage());
      }
//        return null;
   }


}
