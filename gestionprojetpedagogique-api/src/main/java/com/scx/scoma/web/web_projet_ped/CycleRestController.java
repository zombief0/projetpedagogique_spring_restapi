package com.scx.scoma.web.web_projet_ped;

import com.scx.scoma.entities.entities_projet_ped.Cycle;
import com.scx.scoma.services.service_projet_ped.CycleService;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@CrossOrigin("*")
@RequestMapping("/saclex/cycle")
public class CycleRestController {
    private CycleService cycleService;

    public CycleRestController(CycleService cycleService) {
        this.cycleService = cycleService;
    }

    @GetMapping("/byId/{id}")
    public Cycle cycleById(@PathVariable Long id){

        return cycleService.findCycleById(id);
    }

    @GetMapping("/all")
    public List<Cycle> allCycle(){
       return cycleService.listCycle();

    }

    @PostMapping
    public Cycle save(@RequestBody Cycle cycle) throws Exception {
        if(cycle.getScxIdCycle() != null){
            throw new Exception("id ne doit pas être présent");
        }
        return cycleService.saveCycle(cycle);
    }

    @PutMapping
    public Cycle update(@RequestBody Cycle cycle) throws Exception {

        if(cycle.getScxIdCycle() == null){
            throw new Exception("Id invalide");
        }
        return cycleService.saveCycle(cycle);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        cycleService.deleteCycle(id);
    }
}
