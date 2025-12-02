package com.bucannera.dto;

public record StreetResponseDTO (
        Long id,
        int  streetId,
        String streetName,
        String streetCity
)
{ }
