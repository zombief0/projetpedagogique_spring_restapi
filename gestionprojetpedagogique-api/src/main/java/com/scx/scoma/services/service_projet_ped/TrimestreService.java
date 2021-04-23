package com.scx.scoma.services.service_projet_ped;

import com.scx.scoma.services.DTO.DTO_projet_ped.TrimestreDTO;

import java.util.List;

public interface TrimestreService {

    TrimestreDTO findTrimestreById(Long id);

    TrimestreDTO saveTrimestre(TrimestreDTO trimestreDTO);

    TrimestreDTO updateTrimestre(TrimestreDTO trimestreDTO);

    List<TrimestreDTO> findAllBySuivi(Long scxIdSuivi);

    void deleteAllTrimestreIdentique(Long id);

    void deleteTrimestre(Long id);

    List<TrimestreDTO> findAllTrimestre();

}
