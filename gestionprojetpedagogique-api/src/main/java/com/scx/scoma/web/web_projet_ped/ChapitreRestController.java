package com.scx.scoma.web.web_projet_ped;

import com.scx.scoma.entities.entities_projet_ped.Chapitre;
import com.scx.scoma.services.mapper.mapper_projet_ped.ChapitreMapper;
import com.scx.scoma.services.service_projet_ped.ChapitreService;
import com.scx.scoma.services.service_projet_ped.ModuleService;
import com.scx.scoma.services.DTO.DTO_projet_ped.ChapitreDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/saclex/chapitre")
public class ChapitreRestController {
    private ChapitreService chapitreService;

    public ChapitreRestController(ChapitreService chapitreService) {
        this.chapitreService = chapitreService;
    }

    @GetMapping("/byId/{id}")
    public ChapitreDTO chapitreById(@PathVariable Long id){
       return chapitreService.findById(id);
    }

    @GetMapping("/byModule/{idModule}")
    public List<ChapitreDTO> chapitreByModule(@PathVariable Long idModule){
        return chapitreService.findByModule(idModule);
    }

    @PostMapping
    public ChapitreDTO save(@RequestBody ChapitreDTO chapitreDTO) throws Exception {
        if (chapitreDTO.getScxIdChapitre() != null){
            throw new Exception("Id ne doit pas etre fourni");
        }

        return chapitreService.saveChapitre(chapitreDTO);
    }

    @PutMapping
    public ChapitreDTO update(@RequestBody ChapitreDTO chapitreDTO) throws Exception {
        if (chapitreDTO.getScxIdChapitre() == null){
            throw new Exception("Id doit etre fournie");
        }

        return chapitreService.updateChapitre(chapitreDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        chapitreService.deleteChapitre(id);
    }
}
