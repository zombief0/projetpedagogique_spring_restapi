package com.scx.scoma.web.web_projet_ped;

import com.scx.scoma.entities.entities_projet_ped.Specialite;
import com.scx.scoma.services.service_projet_ped.SpecialiteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/saclex/specialite")
public class SpecialiteRestController {
    private SpecialiteService specialiteService;

    public SpecialiteRestController(SpecialiteService specialiteService) {
        this.specialiteService = specialiteService;
    }

    @GetMapping("/byId/{id}")
    public Specialite specialiteById(@PathVariable Long id){
        return specialiteService.findSpecialiteById(id);
    }

    @GetMapping("/all")
    public List<Specialite> listSpecialite(){
        return specialiteService.listSpecialite();
    }

    @PostMapping
    public Specialite save(@RequestBody Specialite specialite) throws Exception {

        if(specialite.getScxIdSpecialite() != null){
            throw new Exception("Id ne doit pas être présent");
        }

        return specialiteService.saveSpecialite(specialite);
    }

    @PutMapping
    public Specialite update(@RequestBody Specialite specialite) throws Exception {
        if(specialite.getScxIdSpecialite() == null){
            throw new Exception("Id invalide");
        }

        return specialiteService.saveSpecialite(specialite);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        specialiteService.deleteSpecialite(id);
    }
}
