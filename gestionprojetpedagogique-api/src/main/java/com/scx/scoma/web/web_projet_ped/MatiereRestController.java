package com.scx.scoma.web.web_projet_ped;

import com.scx.scoma.entities.entities_projet_ped.Matiere;
import com.scx.scoma.services.service_projet_ped.MatiereService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/saclex/matiere")
public class MatiereRestController {
    private MatiereService matiereService;

    public MatiereRestController(MatiereService matiereService) {
        this.matiereService = matiereService;
    }

    @GetMapping("/byId/{id}")
    public Matiere matiereById(@PathVariable Long id){
        return matiereService.findMatiereById(id);
    }

    @GetMapping("/all")
    public List<Matiere> listMatiere(){
        return matiereService.listMatiere();

    }

    @PostMapping
    public Matiere save(@RequestBody Matiere matiere) throws Exception {
        if(matiere.getScxIdMatiere() != null){
            throw new Exception("Id doit pas être présent");
        }

        return matiereService.saveMatiere(matiere);
    }

    @PutMapping
    public Matiere update(@RequestBody Matiere matiere) throws Exception {
        if(matiere.getScxIdMatiere() == null){
            throw new Exception("Id invalide");
        }

        return matiereService.saveMatiere(matiere);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        matiereService.deleteMatiere(id);
    }
}
