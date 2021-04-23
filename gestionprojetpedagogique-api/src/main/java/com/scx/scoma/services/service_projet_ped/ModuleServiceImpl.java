package com.scx.scoma.services.service_projet_ped;

import com.scx.scoma.dao.dao_projet_ped.ModuleRepository;
import com.scx.scoma.dao.dao_projet_ped.SuiviProjetPedagogiqueRepository;
import com.scx.scoma.dao.dao_projet_ped.TrimestreRepository;
import com.scx.scoma.entities.entities_projet_ped.Module;
import com.scx.scoma.entities.entities_projet_ped.SuiviProjetPedagogique;
import com.scx.scoma.entities.entities_projet_ped.Trimestre;
import com.scx.scoma.services.DTO.DTO_projet_ped.ModuleDTO;
import com.scx.scoma.services.mapper.mapper_projet_ped.ModuleMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ModuleServiceImpl implements ModuleService {
    private ModuleRepository moduleRepository;
    private ModuleMapper moduleMapper;
    private TrimestreRepository trimestreRepository;
    private SuiviProjetPedagogiqueRepository suiviProjetPedagogiqueRepository;

    public ModuleServiceImpl(ModuleRepository moduleRepository, ModuleMapper moduleMapper, TrimestreRepository trimestreRepository, SuiviProjetPedagogiqueRepository suiviProjetPedagogiqueRepository) {
        this.moduleRepository = moduleRepository;
        this.moduleMapper = moduleMapper;
        this.trimestreRepository = trimestreRepository;
        this.suiviProjetPedagogiqueRepository = suiviProjetPedagogiqueRepository;
    }

    @Override
    public ModuleDTO findModuleById(Long id) {

        return moduleMapper.toDto(moduleRepository.findByScxIdModule(id));
    }

    @Override
    public ModuleDTO saveModule(ModuleDTO moduleDTO) {
        Module module = moduleMapper.toEntity(moduleDTO);
        module.setTrimestre(trimestreRepository.findByScxIdTrimestre(moduleDTO.getScxIdTrimestre()));
        moduleRepository.save(module);
        List<SuiviProjetPedagogique> suiviProjetPedagogiques = suiviProjetPedagogiqueRepository.findAllByProjetPedagogique(module.getTrimestre().getSuiviProjetPedagogique().getProjetPedagogique());
        for (SuiviProjetPedagogique suiviProjetPedagogique:suiviProjetPedagogiques){
            List<Trimestre> trimestresList = suiviProjetPedagogique.getTrimestres().stream().filter(trimestre -> trimestre.getScxNumero() == module.getTrimestre().getScxNumero()).collect(Collectors.toList());
            for (Trimestre trimestre : trimestresList){
                Module module1 = new Module(module.getScxProgression(), module.getScxLibelle(), module.getScxDescription(),module.getScxNumero(), module.getScxStatut(),trimestre);
                    if(module.getTrimestre() != module1.getTrimestre()) {
                        moduleRepository.save(module1);
                    }
                }
            }
        return moduleMapper.toDto(module);
    }

    @Override
    public ModuleDTO updateModule(ModuleDTO moduleDTO) {
        Module module = moduleMapper.toEntity(moduleDTO);
        module.setTrimestre(trimestreRepository.findByScxIdTrimestre(moduleDTO.getScxIdTrimestre()));
        moduleRepository.save(module);
        return moduleMapper.toDto(module);
    }

    @Override
    public List<ModuleDTO> findModuleByTrimestre(Long scxIdTrimestre) {
        Trimestre trimestre = trimestreRepository.findByScxIdTrimestre(scxIdTrimestre);
        return moduleMapper.toDto(moduleRepository.findAllByTrimestre(trimestre));
    }

    @Override
    public List<ModuleDTO> listModule() {

        return moduleMapper.toDto(moduleRepository.findAll());
    }

    @Override
    public void deleteAllModuleIdentique(Long id) {
        /*Module module = moduleRepository.findByScxIdModule(id);
        List<SuiviProjetPedagogique> suiviProjetPedagogiques = suiviProjetPedagogiqueRepository.findAllByProjetPedagogique(module.getSequence().getTrimestre().getSuiviProjetPedagogique().getProjetPedagogique());
        for (SuiviProjetPedagogique suiviProjetPedagogique:suiviProjetPedagogiques){
            List<Trimestre> trimestresList = suiviProjetPedagogique.getTrimestres().stream().filter(trimestre -> trimestre.getScxNumero() == module.getSequence().getTrimestre().getScxNumero()).collect(Collectors.toList());
            for (Trimestre trimestre : trimestresList){
                List<Sequence> sequencesFiltre = trimestre.getSequences().stream().filter(sequence -> sequence.getScxNumero() == module.getSequence().getScxNumero()).collect(Collectors.toList());
                for (Sequence sequence:sequencesFiltre){
                    List<Module> modules = sequence.getModules().stream().filter(module1 -> module1.getScxLibelle().equals(module.getScxLibelle())).collect(Collectors.toList());
                    moduleRepository.deleteAll(modules);
                }
            }
        }*/
    }

    @Override
    public void deleteModule(Long id) {
        moduleRepository.deleteById(id);
    }


}
