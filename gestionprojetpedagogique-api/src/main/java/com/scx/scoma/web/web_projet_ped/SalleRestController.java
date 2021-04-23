package com.scx.scoma.web.web_projet_ped;

import com.scx.scoma.entities.entities_projet_ped.Salle;
import com.scx.scoma.services.service_projet_ped.*;
import com.scx.scoma.services.DTO.DTO_projet_ped.SalleDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/saclex/salle")
public class SalleRestController {
    private SalleService salleService;

    public SalleRestController(SalleService salleService) {
        this.salleService = salleService;
    }

    @GetMapping("/byId/{scxId}")
    public SalleDTO findSalleById(@PathVariable Long scxId){
        return salleService.findSalleById(scxId);
    }

    @GetMapping("/byClasse/{scxIdClasse}")
    public List<SalleDTO> findSallesByClasse(@PathVariable Long scxIdClasse){
       return salleService.findSalleByClasse(scxIdClasse);
    }

    @GetMapping("byAnneeClasse/{scxIdClasse}/{scxIdAnnee}")
    public List<SalleDTO> findSalleByAnneeClasse(@PathVariable Long scxIdClasse, @PathVariable Long scxIdAnnee){
        return salleService.findSallesByAnneeClasse(scxIdAnnee,scxIdClasse);
    }

    @PostMapping
    public SalleDTO saveSalle(@RequestBody SalleDTO salleDTO) throws Exception {
        if(salleDTO.getScxIdSalle() != null){
            throw new Exception("Id doit etre null");
        }
        return salleService.saveSalle(salleDTO);
    }

    @PutMapping
    public SalleDTO update(@RequestBody SalleDTO salleDTO) throws Exception {
        if(salleDTO.getScxIdSalle() == null){
            throw new Exception("Id doit etre null");
        }
        return salleService.saveSalle(salleDTO);
    }

    @DeleteMapping("/{scxIdSalle}")
    public void delete(@PathVariable(value = "scxIdSalle") Long id){
        salleService.deleteSalle(id);
    }
}
