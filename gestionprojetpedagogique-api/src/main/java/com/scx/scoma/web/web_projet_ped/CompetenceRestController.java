package com.scx.scoma.web.web_projet_ped;

import com.scx.scoma.entities.entities_projet_ped.Competence;
import com.scx.scoma.services.service_projet_ped.ChapitreService;
import com.scx.scoma.services.service_projet_ped.CompetenceService;
import com.scx.scoma.services.DTO.DTO_projet_ped.CompetenceDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/saclex/competence")
public class CompetenceRestController {
    private CompetenceService competenceService;

    public CompetenceRestController(CompetenceService competenceService) {
        this.competenceService = competenceService;
    }

    @GetMapping("/byId/{id}")
    public CompetenceDTO competById(@PathVariable Long id){
        return competenceService.findById(id);
    }

    @GetMapping("/byChapitre/{idChapitre}")
    public List<CompetenceDTO> competByChapitre(@PathVariable Long idChapitre) {
        return competenceService.findAllByChapitre(idChapitre);
    }

    @PostMapping
    public CompetenceDTO save(@RequestBody CompetenceDTO competenceDTO) throws Exception {
        if (competenceDTO.getScxIdCompetence() != null){
            throw new Exception("Id ne doit pas etre fourni");
        }

        return competenceService.saveCompetence(competenceDTO);
    }

    @PutMapping
    public CompetenceDTO update(@RequestBody CompetenceDTO competenceDTO) throws Exception {

        if (competenceDTO.getScxIdCompetence() == null){
            throw new Exception("Id doit etre fourni");
        }

        return competenceService.updateCompetence(competenceDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        competenceService.deleteCompetence(id);
    }
}
