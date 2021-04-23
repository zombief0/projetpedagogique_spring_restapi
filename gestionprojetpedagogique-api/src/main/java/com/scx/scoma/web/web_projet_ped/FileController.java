package com.scx.scoma.web.web_projet_ped;

import com.scx.scoma.services.service_projet_ped.FileService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/saclex/file")
@CrossOrigin(origins = "http://localhost:4200")
public class FileController {

   /* private FileService fileService;

    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @PostMapping
    public void handleFileUpload(@RequestParam("file") MultipartFile file) throws IOException{
        fileService.storeFile(file);
    }*/
}
