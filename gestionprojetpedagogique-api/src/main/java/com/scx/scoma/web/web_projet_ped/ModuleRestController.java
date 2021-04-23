package com.scx.scoma.web.web_projet_ped;

import com.scx.scoma.services.service_projet_ped.ModuleService;
import com.scx.scoma.services.DTO.DTO_projet_ped.ModuleDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/saclex/module")
public class ModuleRestController {
    private ModuleService moduleService;

    public ModuleRestController(ModuleService moduleService) {
        this.moduleService = moduleService;
    }

    @GetMapping("/byId/{id}")
    public ModuleDTO moduleById(@PathVariable Long id){
       return moduleService.findModuleById(id);
    }

    @GetMapping("/byTrimestre/{id}")
    public List<ModuleDTO> moduleByTrimestre(@PathVariable Long id){
       return moduleService.findModuleByTrimestre(id);
    }

    @PostMapping
    public ModuleDTO save(@RequestBody ModuleDTO moduleDTO) throws Exception {
        if (moduleDTO.getScxIdModule() != null){
            throw new Exception("Id doit etre null");
        }

        return moduleService.saveModule(moduleDTO);
    }

    @PutMapping
    public ModuleDTO update(@RequestBody ModuleDTO moduleDTO) throws Exception {
        if (moduleDTO.getScxIdModule() == null){
            throw new Exception("Id ne doit pas etre null");
        }

        return moduleService.updateModule(moduleDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        moduleService.deleteModule(id);
    }
}
