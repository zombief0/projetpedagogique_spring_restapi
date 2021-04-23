package com.scx.scoma.web.web_projet_ped;

import com.scx.scoma.entities.entities_projet_ped.EnseignerID;
import com.scx.scoma.services.service_projet_ped.EnseignerService;
import com.scx.scoma.services.DTO.DTO_projet_ped.EnseignerDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/saclex/enseigner")
@CrossOrigin("*")
public class EnseignerRestController {

    private EnseignerService enseignerService;

    public EnseignerRestController(EnseignerService enseignerService) {
        this.enseignerService = enseignerService;
    }

    @PostMapping
    public EnseignerDTO saveEns(@RequestBody EnseignerDTO enseignerDTO) {
       return enseignerService.saveEns(enseignerDTO);
    }

    @GetMapping("/{idCours}/{idSalle}/{idEnseignant}")
    public EnseignerDTO enseignerByCoursSalleEns(@PathVariable Long idCours, @PathVariable Long idSalle, @PathVariable Long idEnseignant){
        return enseignerService.findById(idEnseignant,idSalle,idCours );
    }

    @GetMapping("/all")
    public List<EnseignerDTO> listEnseigner(){
        return enseignerService.listEnseigner();
    }

    @GetMapping("/byAnnee/{idAnnee}")
    public List<EnseignerDTO> enseignerByAnnee(@PathVariable Long idAnnee){
        return enseignerService.findEnseignersByAnnee(idAnnee);
    }

    @GetMapping("/byCoursAnnee/{idAnnee}/{idCours}")
    public List<EnseignerDTO> enseignerByAnneeCours(@PathVariable Long idAnnee,@PathVariable Long idCours){
        return enseignerService.findEnseignersByCoursAnnee(idAnnee,idCours);
    }

    @GetMapping("/byCoursSalle/{idSalle}/{idCours}")
    public EnseignerDTO enseignerByCoursSalle(@PathVariable Long idSalle,@PathVariable Long idCours){
        return enseignerService.findEnseignerByCoursSalle(idCours,idSalle);
    }

    @DeleteMapping("/{idCours}/{idSalle}/{idEnseignant}")
    public void deleteEnseigner(@PathVariable Long idCours, @PathVariable Long idSalle, @PathVariable Long idEnseignant){
        enseignerService.deleteById(idEnseignant,idSalle,idCours);
    }
}
