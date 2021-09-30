package com.example.hibernate_example.service.impl;

import com.example.hibernate_example.model.Country;
import com.example.hibernate_example.repository.CountryRepository;
import com.example.hibernate_example.service.CountryService;
import javassist.NotFoundException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {
    CountryRepository countryRepository;

    public  CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public List<Country> getAll(Integer page, String sort) {
        Pageable pageable = PageRequest.of(page != null ? page : 1, 10, Sort.by(sort != null ? sort : "id"));
        return countryRepository.findAll(pageable).toList();
    }

    public Optional<Country> getOne(Long id) {
        return countryRepository.findById(id);
    }

    public Country store(Country country) {
        return countryRepository.save(country);
    }

    public Country update(Country country) {
        Country data = countryRepository.findById(country.getId()).orElseThrow();
        data.setName(country.getName());
        countryRepository.save(data);

        return countryRepository.save(country);
    }

    public String delete(Long id) {
        countryRepository.deleteById(id);
        return "Successfully deleted";
    }
}
