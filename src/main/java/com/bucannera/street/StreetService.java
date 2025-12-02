package com.bucannera.street;

import com.bucannera.dto.CreateStreetDTO;
import com.bucannera.dto.StreetResponseDTO;
import com.bucannera.mapper.StreetMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StreetService {

    private final StreetRepository repo;


    public StreetService(StreetRepository repo) {
        this.repo = repo;
    }

    public List<StreetResponseDTO> findAll() {
        return repo.findAll()
                .stream()
                .map(StreetMapper::toDTO)
                .toList();
    }
    public StreetResponseDTO findById(Long id) {
        Street street = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Street Not Found"));
        return StreetMapper.toDTO(street);
    }

    public StreetResponseDTO create(CreateStreetDTO dto) {
        Street created = repo.save(StreetMapper.toEntity(dto));
        return StreetMapper.toDTO(created);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public StreetResponseDTO update(Long id, CreateStreetDTO dto) {
        Street street = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Street Not Found"));

        street.setStreetId(dto.streetId());
        street.setStreetName(dto.streetName());
        street.setStreetCity(dto.streetCity());
        return StreetMapper.toDTO(repo.save(street));
        //return null;
    }

}
