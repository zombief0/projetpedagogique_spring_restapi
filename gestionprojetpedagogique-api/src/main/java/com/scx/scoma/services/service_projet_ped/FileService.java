package com.scx.scoma.services.service_projet_ped;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Objects;

@Service
@Transactional
public class FileService {

    public void storeFile(MultipartFile file) throws IOException{

        //InputStream in = file.getInputStream();

        //Files dir = new P("C:\\Users\\Norman\\Desktop\\Shortcuts");

        //Path path = Paths.get(System.getProperty("user.home") + "/Desktop/Test/");

        /*Path path = Files.createTempDirectory("SCOMA");

        //String fileLocation = path + "\\" + file.getOriginalFilename();
        //Path fileDir = Files.createDirectory(path);
        File testFile = path.resolve(Objects.requireNonNull(file.getOriginalFilename())).toFile();

        file.transferTo(testFile);*/

        /*FileOutputStream f = new FileOutputStream(fileLocation);
        int ch;
        while ((ch = in.read()) != -1){
            f.write(ch);
            System.out.print((char)ch);

        }
        System.out.println(path);
        System.out.print(path.substring(0,path.length()-1));
        f.flush();
        f.close();*/

    }
}