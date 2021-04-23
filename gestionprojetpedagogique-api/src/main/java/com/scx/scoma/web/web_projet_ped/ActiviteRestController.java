package com.scx.scoma.web.web_projet_ped;

import com.scx.scoma.entities.entities_projet_ped.Activite;
import com.scx.scoma.services.service_projet_ped.ActiviteService;
import com.scx.scoma.services.service_projet_ped.ChapitreService;
import com.scx.scoma.services.DTO.DTO_projet_ped.ActiviteDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/saclex/activite")
public class ActiviteRestController {
    private ActiviteService activiteService;

    public ActiviteRestController(ActiviteService activiteService) {
        this.activiteService = activiteService;
    }

    @GetMapping("/byId/{id}")
    public ActiviteDTO activiteById(@PathVariable Long id){
        return activiteService.findById(id);
    }

    @GetMapping("/byChapitre/{idChapitre}")
    public List<ActiviteDTO> activiteByChapitre(@PathVariable Long idChapitre){
        return activiteService.findByChapitre(idChapitre);
    }

    @PostMapping
    public ActiviteDTO save(@RequestBody ActiviteDTO activiteDTO) throws Exception {
        if(activiteDTO.getScxIdActivite() != null){
            throw new Exception("Id ne doit pas etre fourni");
        }

        return activiteService.saveActivite(activiteDTO);
    }

    @PutMapping
    public ActiviteDTO update(@RequestBody ActiviteDTO activiteDTO) throws Exception {

        if(activiteDTO.getScxIdActivite() == null){
            throw new Exception("Id doit etre fournie");
        }

        return activiteService.updateActivite(activiteDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        activiteService.deleteActivite(id);
    }
}
