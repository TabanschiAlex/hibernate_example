package com.example.hibernate_example.service;

import com.example.hibernate_example.model.Country;

import java.util.List;
import java.util.Optional;

public interface CountryService {
    List<Country> getAll(Integer page, String sort);

    Optional<Country> getOne(Long id);

    Country store(Country country);

    Country update(Country country);

    String delete(Long id);
}
