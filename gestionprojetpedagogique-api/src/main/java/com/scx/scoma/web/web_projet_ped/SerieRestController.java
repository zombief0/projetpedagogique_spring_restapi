package com.scx.scoma.web.web_projet_ped;

import com.scx.scoma.entities.entities_projet_ped.Serie;
import com.scx.scoma.services.service_projet_ped.SerieService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/saclex/serie")
public class SerieRestController {
    private SerieService serieService;

    public SerieRestController(SerieService serieService) {
        this.serieService = serieService;
    }

    @GetMapping("/byId/{id}")
    public Serie serieById(@PathVariable Long id){
        return serieService.findSerieById(id);
    }

    @GetMapping("/all")
    public List<Serie> listSerie(){
        return serieService.listSerie();
    }

    @PostMapping
    public Serie save(@RequestBody Serie serie) throws Exception {
        if(serie.getScxIdSerie() != null){
            throw new Exception("l'id ne doit pas être présent");
        }

        return serieService.saveSerie(serie);

    }

    @PutMapping
    public Serie update(@RequestBody Serie serie) throws Exception {
        if(serie.getScxIdSerie() == null){
            throw new Exception("Id invalide");
        }

        return serieService.saveSerie(serie);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        serieService.deleteSerie(id);
    }

}
