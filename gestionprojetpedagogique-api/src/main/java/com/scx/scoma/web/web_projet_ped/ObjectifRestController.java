package com.scx.scoma.web.web_projet_ped;

import com.scx.scoma.entities.entities_projet_ped.Objectif;
import com.scx.scoma.services.service_projet_ped.ActiviteService;
import com.scx.scoma.services.service_projet_ped.ObjectifService;
import com.scx.scoma.services.DTO.DTO_projet_ped.ObjectifDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/saclex/objectif")
public class ObjectifRestController {
    private ObjectifService objectifService;

    public ObjectifRestController(ObjectifService objectifService) {
        this.objectifService = objectifService;
    }

    @GetMapping("/byId/{id}")
    public ObjectifDTO objectifById(@PathVariable Long id){
       return objectifService.findObjectifById(id);
    }

    @GetMapping("/byActivite/{idActivite}")
    public List<ObjectifDTO> objectifByActivite(@PathVariable Long idActivite){
       return objectifService.findAllByActivite(idActivite);
    }

    @PostMapping
    public ObjectifDTO save(@RequestBody ObjectifDTO objectifDTO) throws Exception {
        if(objectifDTO.getScxIdObjectif() != null){
            throw new Exception("Id doit etre null");
        }

        return objectifService.saveObjectif(objectifDTO);
    }

    @PutMapping
    public ObjectifDTO update(@RequestBody ObjectifDTO objectifDTO) throws Exception {
        if(objectifDTO.getScxIdObjectif() == null){
            throw new Exception("Id ne doit pas etre null");
        }

        return objectifService.updateObjectif(objectifDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        objectifService.deleteObjectif(id);
    }
}
