package com.example.hibernate_example.service;

import com.example.hibernate_example.Requests.CountryRequest;
import com.example.hibernate_example.model.Country;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface CountryService {
    Iterable<Country> getAll(Integer page, String sort);

    Optional<Country> getOne(Long id);

    Country store(CountryRequest country);

    Country update(CountryRequest country, Long id);

    String delete(Long id);
}
