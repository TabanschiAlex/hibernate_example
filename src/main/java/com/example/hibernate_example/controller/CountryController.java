package com.example.hibernate_example.controller;

import com.example.hibernate_example.Requests.CountryRequest;
import com.example.hibernate_example.service.CountryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/countries")
public class CountryController {
    private final CountryService countryService;

    public CountryController(CountryService countryService){
        this.countryService = countryService;
    }

    @GetMapping
    public ResponseEntity<?> index(@RequestParam(required = false) Integer page, String sort) {
        try {
            return ResponseEntity.ok(countryService.getAll(page, sort));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<?> edit(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(countryService.getOne(id));
        } catch (Exception e) {
            return ResponseEntity.unprocessableEntity().body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> store(@RequestBody CountryRequest country) {
        try {
            return ResponseEntity.ok(countryService.store(country));
        } catch (Exception e) {
            return ResponseEntity.unprocessableEntity().body(e.getMessage());
        }
    }

    @PatchMapping("{id}")
    public ResponseEntity<?> update(@RequestBody CountryRequest country, @PathVariable Long id) {
        try {
            return ResponseEntity.ok(countryService.update(country, id));
        } catch (Exception e) {
            return ResponseEntity.unprocessableEntity().body(e.getMessage());
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> destroy(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(countryService.delete(id));
        } catch (Exception e) {
            return ResponseEntity.unprocessableEntity().body(e.getMessage());
        }
    }
}
