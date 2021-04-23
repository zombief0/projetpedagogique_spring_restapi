package com.scx.scoma.services.mapper.mapper_projet_ped;

import com.scx.scoma.entities.entities_projet_ped.Enseigner;
import com.scx.scoma.services.DTO.DTO_projet_ped.EnseignerDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",uses = {CoursMapper.class,SalleMapper.class})
public interface EnseignerMapper extends EntityMapper<EnseignerDTO, Enseigner>{

    @Mapping(source = "enseignant", target = "enseignant")
    @Mapping(source = "cours", target = "coursDTO")
    @Mapping(source = "salle", target = "salleDTO")
    EnseignerDTO toDto(Enseigner enseigner);

    @Mapping(source = "enseignant",target = "enseignant")
    @Mapping(source = "coursDTO",target = "cours")
    @Mapping(source = "salleDTO",target ="salle" )
    @Mapping(target = "enseignerID", ignore = true)
    Enseigner toEntity(EnseignerDTO enseignerDTO);
}
