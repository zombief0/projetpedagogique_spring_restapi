package com.scx.scoma.web.web_projet_ped;

import com.scx.scoma.entities.entities_projet_ped.ProjetPedagogique;
import com.scx.scoma.services.service_projet_ped.AnneeAcademiqueService;
import com.scx.scoma.services.service_projet_ped.CoursService;
import com.scx.scoma.services.service_projet_ped.ProjetPedagogiqueService;
import com.scx.scoma.services.DTO.DTO_projet_ped.ProjetPedagogiqueDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/saclex/projet")
public class ProjetPedagogiqueRestController {
    private ProjetPedagogiqueService projetPedagogiqueService;

    public ProjetPedagogiqueRestController(ProjetPedagogiqueService projetPedagogiqueService) {
        this.projetPedagogiqueService = projetPedagogiqueService;
    }

    @GetMapping("/byId/{id}")
    public ProjetPedagogiqueDTO projetById(@PathVariable Long id){
        return projetPedagogiqueService.findProjetById(id);
    }

    @GetMapping("/byAnnee/{idAnnee}")
    public List<ProjetPedagogiqueDTO> projetByAnnee(@PathVariable Long idAnnee){
        return projetPedagogiqueService.findAllByAnnee(idAnnee);
    }

    @GetMapping("/byCours/{idCours}")
    public List<ProjetPedagogiqueDTO> projetByCours(@PathVariable Long idCours){
       return projetPedagogiqueService.findAllByCours(idCours);
    }

    @GetMapping("/byAnneeCours/{idCours}/{idAnnee}")
    public List<ProjetPedagogiqueDTO> projetByCoursAnnee(@PathVariable Long idCours, @PathVariable Long idAnnee) {
        return projetPedagogiqueService.findAllByAnneeCours(idAnnee,idCours);
    }

    @PostMapping
    public ProjetPedagogiqueDTO save(@RequestBody ProjetPedagogiqueDTO projetPedagogiqueDTO) throws Exception {
       if (projetPedagogiqueDTO.getScxIdProjetPedagogique() != null){
           throw new Exception("Id doit etre null");
       }

       return projetPedagogiqueService.saveProjet(projetPedagogiqueDTO);
    }

    @PutMapping
    public ProjetPedagogiqueDTO update(@RequestBody ProjetPedagogiqueDTO projetPedagogiqueDTO) throws Exception {
        if (projetPedagogiqueDTO.getScxIdProjetPedagogique() == null){
            throw new Exception("Id ne doit pas etre null");
        }

        return projetPedagogiqueService.saveProjet(projetPedagogiqueDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        projetPedagogiqueService.deleteProjet(id);
    }
}
