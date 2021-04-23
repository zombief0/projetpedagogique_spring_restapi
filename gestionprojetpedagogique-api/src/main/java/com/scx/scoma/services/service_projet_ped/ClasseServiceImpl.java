package com.scx.scoma.services.service_projet_ped;

import com.scx.scoma.dao.dao_projet_ped.ClasseRepository;
import com.scx.scoma.entities.entities_projet_ped.Classe;
import com.scx.scoma.entities.entities_projet_ped.Cycle;
import com.scx.scoma.services.DTO.DTO_projet_ped.ClasseDTO;
import com.scx.scoma.services.mapper.mapper_projet_ped.ClasseMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ClasseServiceImpl implements ClasseService {
    private ClasseRepository classeRepository;
    private CycleService cycleService;
    private ClasseMapper classeMapper;

    public ClasseServiceImpl(ClasseRepository classeRepository, CycleService cycleService, ClasseMapper classeMapper) {
        this.classeRepository = classeRepository;
        this.cycleService = cycleService;
        this.classeMapper = classeMapper;
    }

    @Override
    public ClasseDTO findClasseById(Long scxIdClasse) {

        return classeMapper.toDto(classeRepository.findByScxIdClasse(scxIdClasse));
    }

    @Override
    public ClasseDTO saveClasse(ClasseDTO classeDTO) {
        Classe classe = classeMapper.toEntity(classeDTO);
        classe.setCycle(cycleService.findCycleById(classeDTO.getScxIdCycle()));
        classeRepository.save(classe);
        return classeMapper.toDto(classe);
    }

    @Override
    public List<ClasseDTO> classeByCycle(Long scxIdcycle) {
        Cycle cycle = cycleService.findCycleById(scxIdcycle);

        return classeMapper.toDto(classeRepository.findAllByCycle(cycle));
    }

    @Override
    public void deleteClasse(Long id) {
        classeRepository.deleteById(id);
    }

    @Override
    public List<ClasseDTO> listClasse() {
        return null;
    }


}
