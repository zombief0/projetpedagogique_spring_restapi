package com.scx.scoma.web.web_projet_ped;


import com.scx.scoma.entities.entities_projet_ped.AnneeAcademique;
import com.scx.scoma.services.service_projet_ped.AnneeAcademiqueService;
import com.scx.scoma.services.service_projet_ped.FileService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/saclex/annee")
public class AnneeAcademiqueRestController {
    private AnneeAcademiqueService anneeAcademiqueService;
    //private FileService fileService;

    public AnneeAcademiqueRestController(AnneeAcademiqueService anneeAcademiqueService) {
        this.anneeAcademiqueService = anneeAcademiqueService;
       // this.fileService = fileService;
    }

    @GetMapping("/byId/{id}")
    public AnneeAcademique anneeById(@PathVariable Long id){
        return anneeAcademiqueService.findAnneeById(id);
    }

    @GetMapping("/all")
    public List<AnneeAcademique> listAnnee(){
        return anneeAcademiqueService.listAnnee();

    }

    @PostMapping
    public AnneeAcademique save(@RequestBody AnneeAcademique anneeAcademique) throws Exception {
        if(anneeAcademique.getScxIdAnneeAcademique() != null){
            throw new Exception("Id ne doit pas être présent");
        }

       return anneeAcademiqueService.saveAnnee(anneeAcademique);

    }
    /*@PostMapping("/file")
    public void handleFileUpload(@RequestParam("file") MultipartFile file) throws IOException{
        fileService.storeFile(file);
    }*/

    @PutMapping
    public AnneeAcademique update(@RequestBody AnneeAcademique anneeAcademique) throws Exception {

        if(anneeAcademique.getScxIdAnneeAcademique() == null){
            throw new Exception("Id invalide");
        }

        return anneeAcademiqueService.saveAnnee(anneeAcademique);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        anneeAcademiqueService.deleteAnnee(id);
    }
}
