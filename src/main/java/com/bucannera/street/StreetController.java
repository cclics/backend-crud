package com.bucannera.street;

import java.net.URI;
import java.util.List;

import com.bucannera.dto.CreateStreetDTO;
import com.bucannera.dto.StreetResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class StreetController {

    private final StreetRepository repository;
    private final StreetService service;

    public StreetController(StreetRepository repository, StreetService service) {
        this.repository = repository;
        this.service  = service;
    }

    @GetMapping("/streets")
    List<StreetResponseDTO> all() {
        //return repository.findAll();
        return service.findAll();
    }

    @GetMapping("/streets/{id}")
    StreetResponseDTO one(@PathVariable Long id) {
        return service.findById(id);
       // return repository.findById(id)
               // .orElseThrow(() -> new StreetNotFoundException(id));
    }

    @PostMapping(value = "/streets", consumes = "application/json", produces = "application/json")
    public ResponseEntity<StreetResponseDTO> create(@RequestBody CreateStreetDTO dto) {
       StreetResponseDTO created = service.create(dto);

       return ResponseEntity.created(
               URI.create("/streets/" + created.id())
               ).body(created);
        //return repository.save(newStreet);

    }

    @PutMapping("/streets/{id}")
    StreetResponseDTO update(@PathVariable Long id, @RequestBody CreateStreetDTO dto) {

        return service.update(id, dto);
        //return repository.findById(id)
         //       .map(street -> {
          //          street.setStreetId(newStreet.getStreetId());
          //          street.setStreetName(newStreet.getStreetName());
           //         street.setStreetCity(newStreet.getStreetCity());
           //         return repository.save(street);
           //     })
              //  .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/streets/{id}")
    ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();

        //repository.deleteById(id);
    }

}
