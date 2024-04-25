package ru.romanov.security.mapper;

import java.util.List;

public interface ToEntityMapper<ENTITY, DTO> {

    ENTITY mapToEntity(DTO dto);

    default List<ENTITY> mapToEntitiesList(List<DTO> dtos) {
        return dtos.stream().map(this::mapToEntity).toList();
    }
}
