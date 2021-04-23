package com.scx.scoma.services.mapper.mapper_projet_ped;


import org.mapstruct.Mapper;
import org.mapstruct.MapperConfig;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Interface qui permet de créer des Mapper pour chaque entité et son DTO
 * @param <D> Paramètre de type ViewModel
 * @param <E> Paramètre de type Entity
 */

public interface EntityMapper<D,E> {

    E toEntity(D dto);

    D toDto(E entity);

    List<E> toEntity(List<D> dtoList);

    List<D> toDto(List<E> entityList);
}
