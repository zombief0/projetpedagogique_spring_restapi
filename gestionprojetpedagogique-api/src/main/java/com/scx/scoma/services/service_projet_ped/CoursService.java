package com.scx.scoma.services.service_projet_ped;

import com.scx.scoma.services.DTO.DTO_projet_ped.CoursDTO;

import java.util.List;

public interface CoursService {

    CoursDTO findCoursById(Long id);

    CoursDTO saveCours(CoursDTO coursDTO);

    void deleteCours(Long id);

    List<CoursDTO> findCoursByMatiere(Long scxIdMatiere);

    List<CoursDTO> findCoursByMatiereClasse(Long scxIdMatiere,Long scxIdClasse);

}
