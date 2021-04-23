package com.scx.scoma.web.web_projet_ped;

import com.scx.scoma.services.service_projet_ped.*;
import com.scx.scoma.services.DTO.DTO_projet_ped.TrimestreDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/saclex/trimestre")
public class TrimestreRestController {
    private TrimestreService trimestreService;

    public TrimestreRestController(TrimestreService trimestreService) {
        this.trimestreService = trimestreService;
    }

    @GetMapping("/byId/{id}")
    public TrimestreDTO trimestreById(@PathVariable Long id){
        return trimestreService.findTrimestreById(id);
    }

    @GetMapping("/bySuivi/{idSuivi}")
    public List<TrimestreDTO> trimestreBySuivi(@PathVariable Long idSuivi){
        return trimestreService.findAllBySuivi(idSuivi);
    }

    @PostMapping
    public TrimestreDTO save(@RequestBody TrimestreDTO trimestreDTO) throws Exception {
        if(trimestreDTO.getScxIdTrimestre() !=null){
            throw new Exception("Id doit etre null");
        }

        return trimestreService.saveTrimestre(trimestreDTO);
    }

    @PutMapping
    public TrimestreDTO update(@RequestBody TrimestreDTO trimestreDTO) throws Exception {
        if(trimestreDTO.getScxIdTrimestre() ==null){
            throw new Exception("Id ne doit pas etre null");
        }

        return trimestreService.updateTrimestre(trimestreDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        trimestreService.deleteTrimestre(id);
    }

}
