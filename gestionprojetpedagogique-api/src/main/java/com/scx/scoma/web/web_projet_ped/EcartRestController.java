package com.scx.scoma.web.web_projet_ped;

import com.scx.scoma.entities.entities_projet_ped.Ecart;
import com.scx.scoma.services.service_projet_ped.*;
import com.scx.scoma.services.DTO.DTO_projet_ped.EcartDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/saclex/ecart")
public class EcartRestController {
    private EcartService ecartService;

    public EcartRestController(EcartService ecartService) {
        this.ecartService = ecartService;
    }

    @GetMapping("/byId/{id}")
    public EcartDTO ecartById(@PathVariable Long id){
        return ecartService.findEcartById(id);
    }

    @GetMapping("/byEnseignant/{id}")
    public List<EcartDTO> ecartsByEnseignant(@PathVariable Long id){
       return ecartService.findAllEcartByEnseignant(id);
    }

    @GetMapping("/byAnnee/{id}")
    public List<EcartDTO> ecartsByAnnee(@PathVariable Long id){
        return ecartService.findAllEcartByAnnee(id);
    }

    @GetMapping("/byAnneeEnseignant/{idAnnee}/{idEnseignant}")
    public List<EcartDTO> ecartByEnseignantAnnee(@PathVariable Long idAnnee, @PathVariable Long idEnseignant){
        return ecartService.findAllEcartByAnneeAndEnseignant(idAnnee,idEnseignant);
    }

    @PostMapping
    public EcartDTO save(@RequestBody EcartDTO ecartDTO) throws Exception {
        if(ecartDTO.getScxIdEcart() != null){
            throw new Exception("Id doit etre null");
        }

        return ecartService.saveEcart(ecartDTO);
    }

    @PutMapping
    public EcartDTO update(@RequestBody EcartDTO ecartDTO) throws Exception {
        if(ecartDTO.getScxIdEcart() == null){
            throw new Exception("Id ne doit pas etre null");
        }

        return ecartService.saveEcart(ecartDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        ecartService.deleteEcart(id);
    }
}
