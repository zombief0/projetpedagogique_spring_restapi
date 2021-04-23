package com.scx.scoma.web.web_projet_ped;

import com.scx.scoma.entities.entities_projet_ped.SuiviProjetPedagogique;
import com.scx.scoma.services.service_projet_ped.ProjetPedagogiqueService;
import com.scx.scoma.services.service_projet_ped.SalleService;
import com.scx.scoma.services.service_projet_ped.SuiviProjetPedagogiqueService;
import com.scx.scoma.services.DTO.DTO_projet_ped.SuiviProjetPedagogiqueDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/saclex/suivi")
public class SuiviProjetPedagogiqueRestController {
    private SuiviProjetPedagogiqueService suiviProjetPedagogiqueService;

    public SuiviProjetPedagogiqueRestController(SuiviProjetPedagogiqueService suiviProjetPedagogiqueService) {
        this.suiviProjetPedagogiqueService = suiviProjetPedagogiqueService;
    }

    @GetMapping("/byId/{id}")
    public SuiviProjetPedagogiqueDTO suiviById(@PathVariable Long id){
        return suiviProjetPedagogiqueService.findSuiviById(id);
    }

    @GetMapping("/bySalle/{idSalle}")
    public List<SuiviProjetPedagogiqueDTO> suiviBySalle(@PathVariable Long idSalle){
        return suiviProjetPedagogiqueService.findSuiviBySalle(idSalle);
    }

    @GetMapping("/byProjet/{idProjet}")
    public List<SuiviProjetPedagogiqueDTO> suiviByProjet(@PathVariable Long idProjet){
        return suiviProjetPedagogiqueService.findSuiviByProjet(idProjet);
    }

    /*@PostMapping
    public List<SuiviProjetPedagogiqueDTO> save(@RequestBody SuiviProjetPedagogiqueDTO suiviProjetPedagogiqueDTO) throws Exception {
        if(suiviProjetPedagogiqueDTO.getScxIdSuivi() != null){
            throw new Exception("Id doit etre null");
        }
        return suiviProjetPedagogiqueService.saveSuivi(suiviProjetPedagogiqueDTO);
    }*/

    @PostMapping
    public SuiviProjetPedagogiqueDTO save(@RequestBody SuiviProjetPedagogiqueDTO suiviProjetPedagogiqueDTO) throws Exception {
        if (suiviProjetPedagogiqueDTO.getScxIdSuivi() != null) {
            throw new Exception("Id doit etre null");
        }
        return suiviProjetPedagogiqueService.saveSuiviUnique(suiviProjetPedagogiqueDTO);
    }

    @PutMapping
    public SuiviProjetPedagogiqueDTO update(@RequestBody SuiviProjetPedagogiqueDTO suiviProjetPedagogiqueDTO) throws Exception {
        if(suiviProjetPedagogiqueDTO.getScxIdSuivi() == null){
            throw new Exception("Id ne doit pas etre null");
        }
        return suiviProjetPedagogiqueService.updateSuivi(suiviProjetPedagogiqueDTO);

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        suiviProjetPedagogiqueService.deleteSuivi(id);
    }

}
