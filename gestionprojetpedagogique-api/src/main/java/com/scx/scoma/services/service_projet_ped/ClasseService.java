package com.scx.scoma.services.service_projet_ped;

import com.scx.scoma.entities.entities_projet_ped.Classe;
import com.scx.scoma.services.DTO.DTO_projet_ped.ClasseDTO;

import java.util.List;

public interface ClasseService {

    ClasseDTO findClasseById(Long scxIdClasse);

    ClasseDTO saveClasse(ClasseDTO classeDTO);

    List<ClasseDTO> classeByCycle(Long scxIdcycle);

    void deleteClasse(Long id);

    List<ClasseDTO> listClasse();

}
