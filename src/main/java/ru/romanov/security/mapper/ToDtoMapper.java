package ru.romanov.security.mapper;

import java.util.List;

public interface ToDtoMapper<ENTITY, DTO> {

    DTO mapToDto(ENTITY entity);

    default List<DTO> mapToDtoList(List<ENTITY> entities) {
        return entities.stream().map(this::mapToDto).toList();
    }
}