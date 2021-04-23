package com.scx.scoma.web.web_projet_ped;

import com.scx.scoma.entities.entities_projet_ped.Classe;
import com.scx.scoma.services.service_projet_ped.ClasseService;
import com.scx.scoma.services.DTO.DTO_projet_ped.ClasseDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/saclex/classe")
@CrossOrigin("*")
public class ClasseRestController {

    private ClasseService classeService;

    public ClasseRestController(ClasseService classeService) {
        this.classeService = classeService;
    }

    @GetMapping("/byId/{scxIdClasse}")
    public ClasseDTO classeById(@PathVariable Long scxIdClasse){
       return classeService.findClasseById(scxIdClasse);
    }

    @GetMapping("/byCycle/{scxIdCycle}")
    public List<ClasseDTO> classeByCycle(@PathVariable Long scxIdCycle){
        return classeService.classeByCycle(scxIdCycle);
    }

    @PostMapping
    public ClasseDTO save(@RequestBody ClasseDTO classeDTO) throws Exception {
        if(classeDTO.getScxIdClasse() != null){
            throw new Exception("Id ne doit pas etre fournie");
        }

        return classeService.saveClasse(classeDTO);
    }

    @PutMapping
    public ClasseDTO update(@RequestBody ClasseDTO classeDTO) throws Exception {
        if(classeDTO.getScxIdClasse() == null){
            throw new Exception("Id doit etre fourni");
        }

        return classeService.saveClasse(classeDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        classeService.deleteClasse(id);
    }
}
