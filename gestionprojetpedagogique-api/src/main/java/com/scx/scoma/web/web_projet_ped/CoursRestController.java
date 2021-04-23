package com.scx.scoma.web.web_projet_ped;

import com.scx.scoma.entities.entities_projet_ped.Cours;
import com.scx.scoma.services.mapper.mapper_projet_ped.CoursMapper;
import com.scx.scoma.services.service_projet_ped.CoursService;
import com.scx.scoma.services.service_projet_ped.MatiereService;
import com.scx.scoma.services.DTO.DTO_projet_ped.CoursDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/saclex/cours")
public class CoursRestController {
    private CoursService coursService;

    public CoursRestController(CoursService coursService) {
        this.coursService = coursService;
    }

    @GetMapping("/byId/{id}")
    public CoursDTO coursById(@PathVariable Long id){
        return coursService.findCoursById(id);
    }

    @GetMapping("/byMatiere/{id}")
    public List<CoursDTO> coursByMatiere(@PathVariable Long id){
        return coursService.findCoursByMatiere(id);
    }

    @GetMapping("/byMatiereClasse/{idMatiere}/{idClasse")
    public List<CoursDTO> coursByMatiereClasse(@PathVariable Long idMatiere, @PathVariable Long idClasse){
        return coursService.findCoursByMatiereClasse(idMatiere,idClasse);
    }

    @PostMapping
    public CoursDTO save(@RequestBody CoursDTO coursDTO) throws Exception {
        if(coursDTO.getScxIdCours() != null){
            throw new Exception("Id doit etre null");
        }

        return coursService.saveCours(coursDTO);
    }

    @PutMapping
    public CoursDTO update(@RequestBody CoursDTO coursDTO) throws Exception {
        if(coursDTO.getScxIdCours() == null){
            throw new Exception("Id ne doit pas etre null");
        }

        return coursService.saveCours(coursDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        coursService.deleteCours(id);
    }

}
