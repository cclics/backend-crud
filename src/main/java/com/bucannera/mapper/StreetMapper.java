package com.bucannera.mapper;

import com.bucannera.dto.CreateStreetDTO;
import com.bucannera.dto.StreetResponseDTO;
import com.bucannera.street.Street;

public class StreetMapper {

    public static Street toEntity(CreateStreetDTO dto) {
        return new Street(
                dto.streetId(),
                dto.streetName(),
                dto.streetCity()
        );
    }

    public static StreetResponseDTO toDTO(Street entity) {
        return new StreetResponseDTO(
                entity.getId(),
                entity.getStreetId(),
                entity.getStreetName(),
                entity.getStreetCity()
        );
    }
}
