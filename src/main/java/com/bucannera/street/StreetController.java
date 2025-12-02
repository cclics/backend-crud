package com.bucannera.street;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class StreetController {

    private final StreetRepository repository;

    public StreetController(StreetRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/streets")
    List<Street> all() {
        return repository.findAll();
    }

    @PostMapping(value = "/streets", consumes = "application/json", produces = "application/json")
    public Street newPost(@RequestBody Street newStreet) {
        return repository.save(newStreet);
    }

    @GetMapping("/streets/{id}")
    Street one(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new StreetNotFoundException(id));
    }

    @PutMapping("/streets/{id}")
    Street updateStreet(@RequestBody Street newStreet, @PathVariable Long id) {

        return repository.findById(id)
                .map(street -> {
                    street.setStreetId(newStreet.getStreetId());
                    street.setStreetName(newStreet.getStreetName());
                    street.setStreetCity(newStreet.getStreetCity());
                    return repository.save(street);
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/streets/{id}")
    void deletePost(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
