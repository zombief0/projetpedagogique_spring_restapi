package com.scx.scoma.web.web_projet_ped;

import com.scx.scoma.entities.entities_projet_ped.Enseignant;
import com.scx.scoma.services.service_projet_ped.EnseignantService;
import com.scx.scoma.services.service_projet_ped.EnseignantServiceImpl;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.ValidationException;
import java.util.List;

@RestController
@RequestMapping("/saclex/enseignant")
@CrossOrigin("*")
public class EnseignantRestController {
    private EnseignantService enseignantService;

    public EnseignantRestController(EnseignantServiceImpl enseignantService) {
        this.enseignantService = enseignantService;
    }

    @GetMapping("/byId/{id}")
    public Enseignant enseignantById(@PathVariable Long id){
        return enseignantService.findEnseignantById(id);
    }

    @GetMapping("/all")
    public List<Enseignant> listeEnseignant(){
        return enseignantService.listEnseignant();
    }

    @PostMapping
    public Enseignant save(@RequestBody Enseignant enseignant) throws Exception {
        if(enseignant.getScxIdEnseignant() != null){
            throw new Exception("Id doit etre null");
        }

        return enseignantService.saveEnseignant(enseignant);
    }

    @PutMapping
    public Enseignant update(@RequestBody Enseignant updatedEnseignant) throws Exception {
        if (updatedEnseignant.getScxIdEnseignant() == null){
            throw new Exception("Id ne doit pas etre null");
        }

        return enseignantService.saveEnseignant(updatedEnseignant);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        enseignantService.deleteEnseignant(id);
    }
}
