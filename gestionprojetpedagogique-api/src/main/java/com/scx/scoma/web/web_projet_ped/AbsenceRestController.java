package com.scx.scoma.web.web_projet_ped;

import com.scx.scoma.entities.entities_projet_ped.Absence;
import com.scx.scoma.services.DTO.DTO_projet_ped.AbsenceDTO;
import com.scx.scoma.services.service_projet_ped.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/saclex/absence")
public class AbsenceRestController {
    private AbsenceService absenceService;

    public AbsenceRestController(AbsenceService absenceService) {
        this.absenceService = absenceService;
    }

    @GetMapping("/byId/{scxIdAbsence}")
    public AbsenceDTO absenceById(@PathVariable(name = "scxIdAbsence") Long id){
        return absenceService.findAbsenceById(id);
    }

    @GetMapping("/byEnseignant/{scxIdEnseignant}")
    public List<AbsenceDTO> absenceByEnseignant(@PathVariable(name = "scxIdEnseignant") Long id){
        return absenceService.findAbsenceByEnseignant(id);
    }

    @GetMapping("/byAnnee/{id}")
    public List<AbsenceDTO> absenceByAnnee(@PathVariable Long id){
        return absenceService.findAbsenceByAnnee(id);
    }

    @GetMapping("/byAnneeEnseignant/{idAnnee}/{idEnseignant}")
    public List<AbsenceDTO> absenceViewModels(@PathVariable Long idAnnee, @PathVariable Long idEnseignant) {
        return absenceService.findAbsenceByEnseignantAndAnnee(idAnnee,idEnseignant);
    }

    @PostMapping
    public AbsenceDTO save(@RequestBody AbsenceDTO absenceDTO) throws Exception {
        if(absenceDTO.getScxIdAbsence() != null){
            throw new Exception("Id fourni doit etre null");
        }

        return absenceService.saveAbsence(absenceDTO);
    }

    @PutMapping
    public AbsenceDTO update(@RequestBody AbsenceDTO updatedAbsenceDTO) throws Exception {
        if(updatedAbsenceDTO.getScxIdAbsence() == null){
            throw new Exception("Id fourni ne doit pas etre null");
        }

        return absenceService.saveAbsence(updatedAbsenceDTO);

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        absenceService.deleteAbsence(id);
    }
}
