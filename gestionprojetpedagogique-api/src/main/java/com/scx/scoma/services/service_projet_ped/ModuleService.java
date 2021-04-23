package com.scx.scoma.services.service_projet_ped;

import com.scx.scoma.services.DTO.DTO_projet_ped.ModuleDTO;

import java.util.List;

public interface ModuleService {

    ModuleDTO findModuleById(Long id);

    ModuleDTO saveModule(ModuleDTO moduleDTO);
    ModuleDTO updateModule(ModuleDTO moduleDTO);

    List<ModuleDTO> findModuleByTrimestre(Long scxIdTrimestre);

    List<ModuleDTO> listModule();

    void deleteAllModuleIdentique(Long id);

    void deleteModule(Long id);

}
