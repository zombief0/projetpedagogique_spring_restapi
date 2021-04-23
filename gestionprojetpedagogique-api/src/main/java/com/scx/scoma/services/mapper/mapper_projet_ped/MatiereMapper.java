package com.scx.scoma.services.mapper.mapper_projet_ped;


import com.scx.scoma.entities.entities_projet_ped.Matiere;
import com.scx.scoma.services.DTO.DTO_projet_ped.MatiereDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring",uses = {})
public interface MatiereMapper extends EntityMapper<MatiereDTO, Matiere> {

    @Mapping(target = "cours",ignore = true)
    Matiere toEntity(MatiereDTO matiereDTO);

}
